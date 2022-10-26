package com.net128.jvm.util.sizeof;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Floats {
	public Data data;
	public class Data {
		public Map<String, float[]> attrValues;
		public Data(int size, int depth) {
			attrValues=new HashMap<>();
			new Random(123).ints(depth).forEach(i -> attrValues.put(i+"", getFloats(size)));
		}
		private float [] getFloats(int size) {
			var f = new float[size];
			for(var i=0;i<size;) f[i++] = new Random(123).nextFloat();
			return f;
		}
	}

	public Floats(int size, int depth) {
		this.data = new Data(size, depth);
	}
}
