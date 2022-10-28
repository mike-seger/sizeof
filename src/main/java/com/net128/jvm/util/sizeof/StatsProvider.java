package com.net128.jvm.util.sizeof;

import java.util.Random;

public class StatsProvider {
	private long count;
	private long n;
	private final Random r = new Random(123);
	public float nfnc() {
		return r.nextFloat();
	}
	public float nf() {
		count++;
		return r.nextFloat();
	}
	public double nd() {
		count++;
		return r.nextDouble();
	}

	public long getCount() { return count; }
	public long getN() { return n; }
	public void setN(int n) { this.n = n; }
}
