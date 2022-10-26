package com.net128.jvm.util.sizeof;

import org.openjdk.jol.info.GraphLayout;

/*
 see: https://github.com/openjdk/jol/blob/master/README.md
 */
public class TestSizeof {
    public static void main(String[] arguments) {
        showSize(new Floats(10000000, 20));
        showSize(new Doubles(10000000, 20));
        showSize(new N20FloatAttrObjects(10000000));
        showSize(new Floats(10000000, 10));
        showSize(new Doubles(10000000, 10));
        showSize(new N10FloatAttrObjects(10000000));
        showSize(new Floats(10000000, 4));
        showSize(new Doubles(10000000, 4));
        showSize(new N4FloatAttrObjects(10000000));
    }

    private static void showSize(RandomCounting o) {
        var size = GraphLayout.parseInstance(o).totalSize();
        System.out.printf("%s: %.2f MB, %d items, %d floats/item, %f bytes/item)\n",
            o.getClass().getSimpleName(), size/1024.0/1024.0, o.getN(), o.getCount()/o.getN(), size*1.0/o.getCount() );
    }
}