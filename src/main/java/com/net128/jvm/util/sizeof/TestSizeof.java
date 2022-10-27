package com.net128.jvm.util.sizeof;

import org.openjdk.jol.info.GraphLayout;

/*
 see: https://github.com/openjdk/jol/blob/master/README.md
 */
public class TestSizeof {
    public static void main(String[] arguments) {
        //dummy call to show following output after warnings
        GraphLayout.parseInstance(new Floats(10, 20)).totalSize();

        int n = 5000000;
        System.out.println("\nType                   size (MB)  items  val/item  bytes/value");
        showSize(new Floats(n, 20));
        showSize(new Doubles(n, 20));
        showSize(new N20FloatAttrObjects(n));
        showSize(new N20NestedObjects(n));
        showSize(new Floats(n, 10));
        showSize(new Doubles(n, 10));
        showSize(new N10FloatAttrObjects(n));
        showSize(new N10NestedObjects(n));
        showSize(new Floats(n, 4));
        showSize(new Doubles(n, 4));
        showSize(new N4FloatAttrObjects(n));

        System.out.println();
    }

    private static void showSize(StatsProvider o) {
        var size = GraphLayout.parseInstance(o).totalSize();
        System.out.printf("%-20s %7.1f MB   %1.0e     %2d     %2.2f\n",
            o.getClass().getSimpleName(),
            size/1024.0/1024.0,
            o.getN()*1.0,
            o.getCount()/o.getN(),
            size*1.0/o.getCount());
    }
}