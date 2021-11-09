package it.unibo.oop.lab.collections1;

import java.util.Iterator;

public class RangeIterator implements Iterator<Integer> {

	private int current;
	private final int stop;
	
	public RangeIterator(final int start, final int stop) {
		this.current = start;
		this.stop = stop;
	}
	
	public boolean hasNext() {
		return this.current < this.stop;
	}

	public Integer next() {
		return this.current++;
	}
}
