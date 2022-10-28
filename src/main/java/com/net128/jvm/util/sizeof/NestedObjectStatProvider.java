package com.net128.jvm.util.sizeof;

import java.util.Objects;

public class NestedObjectStatProvider extends StatsProvider {
	@SuppressWarnings("unused")
	public class Key8 {
		public double k1 = nfnc();
		public String k2 = nfnc()+"";
		public int k3 = Float.valueOf(nfnc()).intValue();
		public float k4 = nfnc();
		public short k5 = Float.valueOf(nfnc()).shortValue();
		public int k6 = Float.valueOf(nfnc()).intValue();
		public int k7 = Float.valueOf(nfnc()).intValue();
		public int k8 = Float.valueOf(nfnc()).intValue();

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof Key8)) return false;
			Key8 key8 = (Key8) o;
			return Double.compare(key8.k1, k1) == 0 && k3 == key8.k3 && Float.compare(key8.k4, k4) == 0 && k5 == key8.k5 && k6 == key8.k6 && k7 == key8.k7 && k8 == key8.k8 && k2.equals(key8.k2);
		}

		@Override
		public int hashCode() {
			return Objects.hash(k1, k2, k3, k4, k5, k6, k7, k8);
		}
	}

	public Key8 createKey8() {
		return new Key8();
	}
}
