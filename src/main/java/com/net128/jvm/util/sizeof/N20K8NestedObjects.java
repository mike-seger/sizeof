package com.net128.jvm.util.sizeof;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class N20K8NestedObjects extends NestedObjectStatProvider {
	public Data data;
	Random r = new Random(123);
	public class Data {
		@SuppressWarnings("unused")
		public class Item {
			public class Sub1 {
				public float attribute01 = nf();
				public float attribute02 = nf();
				public float attribute03 = nf();

			}
			public class Sub2 {
				public float attribute01 = nf();
				public float attribute02 = nf();
			}

			public Sub1 sub1 = new Sub1();
			public Sub2 sub2 = new Sub2();
			public Sub2 sub3 = new Sub2();
			public Sub1 sub4 = new Sub1();
			public Sub1 sub5 = new Sub1();
			public Sub2 sub6 = new Sub2();
			public Sub2 sub7 = new Sub2();
			public Sub1 sub8 = new Sub1();

		}
		public Map<NestedObjectStatProvider.Key8, Item> attrValues;

		public Data(int size) {
			attrValues=new HashMap<>();
			new Random(123).ints(size).forEach(i -> attrValues.put(createKey8(), new Item()));
		}
	}

	public N20K8NestedObjects(int size) {
		setN(size);
		this.data = new Data(size);
	}
}
