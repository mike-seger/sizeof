package com.net128.jvm.util.sizeof;

import org.ehcache.sizeof.impl.ReflectionSizeOf;
import org.openjdk.jol.info.GraphLayout;

/*
 see: https://github.com/openjdk/jol/blob/master/README.md
 */
public class TestSizeof {
    private long floatSize = 4;
    public static void main(String[] args) {
        new TestSizeof().run(args);
    }
    public void run(String[] args) {
        //dummy call to show following output after warnings
        var dummy = new Floats(10, 20);
        GraphLayout.parseInstance(dummy).totalSize();
        new ReflectionSizeOf().deepSizeOf(dummy);

        long started = System.currentTimeMillis();
        int n = 1000000;

        showSize(null, true);
        showSize(new Floats(n, 20));
        showSize(new Doubles(n, 20));
        showSize(new N20FloatAttrObjects(n));
        showSize(new N20NestedObjects(n));
        showSize(new N20K8NestedObjects(n));
        showSize(new Floats(n, 10));
        showSize(new Doubles(n, 10));
        showSize(new N10FloatAttrObjects(n));
        showSize(new N10NestedObjects(n));
        showSize(new N10K8NestedObjects(n));
        showSize(new Floats(n, 4));
        showSize(new Doubles(n, 4));
        showSize(new N4FloatAttrObjects(n));

        System.out.println();
        System.out.printf("Elapsed time: %d ms\n", System.currentTimeMillis()-started);
    }

    private void showSize(StatsProvider o) { showSize(o, false); }
    private void showSize(StatsProvider o, @SuppressWarnings("SameParameterValue") boolean onlyTitle) {
        if(onlyTitle) {
            System.out.printf("\n%-20s  s1(MB)   s2(MB)   items  val/item  bytes/value  float ratio\n", "Type");
            return;
        }
        var size = GraphLayout.parseInstance(o).totalSize();
        var size2 = new ReflectionSizeOf().deepSizeOf(o);
        System.out.printf("%-20s %7.1f  %7.1f   %1.0e     %2d     %-11s  %.2f\n",
            o.getClass().getSimpleName(),
            size/1024.0/1024.0,
            size2/1024.0/1024.0,
            o.getN()*1.0,
            o.getCount()/o.getN(),
            String.format("%2.2f", size*1.0/o.getCount()).replace(".00", ""),
            size*1.0/o.getCount()/1.0/floatSize
        );
    }
}