package com.net128.jvm.util.sizeof;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Doubles extends RandomCounting {
	public Data data;
	public class Data {
		public Map<String, double[]> attrValues;
		public Data(int size, int depth) {
			attrValues=new HashMap<>();
			new Random(123).ints(depth).forEach(i -> attrValues.put(i+"", getDoubles(size)));
		}
		private double [] getDoubles(int size) {
			var f = new double[size];
			for(var i=0;i<size;) f[i++] = nd();
			return f;
		}
	}

	public Doubles(int size, int depth) {
		setN(size*depth);
		this.data = new Data(size, depth);
	}
}
