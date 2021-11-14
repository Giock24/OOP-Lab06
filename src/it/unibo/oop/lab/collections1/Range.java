package it.unibo.oop.lab.collections1;

import java.util.Iterator;

public class Range implements Iterable<Integer> {

	private int start;
	private final int stop;
	
	public Range(final int start, final int stop) {
		this.start = start;
		this.stop = stop;
	}
	
	public Iterator<Integer> iterator() {
		
		return new Iterator<Integer>(){

			private int current = Range.this.start;
			private final int stop = Range.this.stop;
			
			public boolean hasNext() {
				return this.current < this.stop;
			}

			public Integer next() {
				return this.current++;
			}
			
		};
	}
	
}
