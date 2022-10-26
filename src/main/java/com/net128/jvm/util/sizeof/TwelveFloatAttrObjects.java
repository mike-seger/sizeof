package com.net128.jvm.util.sizeof;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TwelveFloatAttrObjects {
	public Data data;
	Random r = new Random(123);
	public class Data {
		@SuppressWarnings("unused")
		public class Item {
			public float attribute01 = r.nextFloat();
			public float attribute02 = r.nextFloat();
			public float attribute03 = r.nextFloat();
			public float attribute04 = r.nextFloat();
			public float attribute05 = r.nextFloat();
			public float attribute07 = r.nextFloat();
			public float attribute08 = r.nextFloat();
			public float attribute09 = r.nextFloat();
			public float attribute10 = r.nextFloat();
			public float attribute11 = r.nextFloat();
			public float attribute12 = r.nextFloat();
		}
		public Map<String, Item> attrValues;

		public Data(int size) {
			attrValues=new HashMap<>();
			new Random(123).ints(size).forEach(i -> attrValues.put(i+"", new Item()));
		}
	}

	public TwelveFloatAttrObjects(int size) {
		this.data = new Data(size);
	}
}
