package com.net128.jvm.util.sizeof;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class N20FloatAttrObjects extends StatsProvider {
	public Data data;
	Random r = new Random(123);
	public class Data {
		@SuppressWarnings("unused")
		public class Item {
			public float attribute01 = nf();
			public float attribute02 = nf();
			public float attribute03 = nf();
			public float attribute04 = nf();
			public float attribute05 = nf();
			public float attribute06 = nf();
			public float attribute07 = nf();
			public float attribute08 = nf();
			public float attribute09 = nf();
			public float attribute10 = nf();
			public float attribute11 = nf();
			public float attribute12 = nf();
			public float attribute13 = nf();
			public float attribute14 = nf();
			public float attribute15 = nf();
			public float attribute16 = nf();
			public float attribute17 = nf();
			public float attribute18 = nf();
			public float attribute19 = nf();
			public float attribute20 = nf();
		}
		public Map<String, Item> attrValues;

		public Data(int size) {
			attrValues=new HashMap<>();
			new Random(123).ints(size).forEach(i -> attrValues.put(i+"", new Item()));
		}
	}

	public N20FloatAttrObjects(int size) {
		setN(size);
		this.data = new Data(size);
	}
}
