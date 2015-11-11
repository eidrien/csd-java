package org.agilar.csd.oop.inheritance;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSet<E> extends HashSet<E> {

	private static final long serialVersionUID = 1L;

	private int addCount = 0;

	@Override
	public boolean add(E e) {
		addCount++;
		return super.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		addCount += c.size();
		return super.addAll(c);
	}

	public static void main(String args[]) {
		InstrumentedHashSet<String> s = new InstrumentedHashSet<String>();
		s.addAll(Arrays.asList("Hola", "Esto", "Es"));
		System.out.println(s.addCount);
	}
}
