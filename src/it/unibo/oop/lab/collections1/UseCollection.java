package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
	private static final int ELEMS = 100_000;
	private static final int TO_MS = 100_000;
	private static final int MAX_READING = 1_000;
	private static final int TO_MS2 = 1_000;
	private static final int TWO = 2;

    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
        /*
         * 8) Compute the population of the world
         */
    	
    	List<Integer> arrayList = new ArrayList<>();
    	
    	for (int population: new Range(1000, 2000)) {
    		arrayList.add(population);
    	}
    	
    	//System.out.println(arrayList);
    	
    	var linkedList = new LinkedList<>(arrayList);
    	
    	//System.out.println(linkedList);
    	
    	int first = arrayList.get(0);
    	
    	arrayList.set(0, arrayList.get(arrayList.size() - 1));
    	arrayList.set(arrayList.size() - 1, first);
    	
    	//System.out.println(arrayList);
    	
    	for (int numbers: arrayList) {
    		System.out.println(numbers);
    	}
    	
    	long time = System.nanoTime();
    	
    	for (int i = 1; i <= ELEMS; i++) {
            arrayList.add(i);
        }
    	
    	time = System.nanoTime() - time;
        System.out.println("Converting " + ELEMS
                + " int to String and inserting them in a ArrayList took " + time
                + "ns (" + time / TO_MS + "ms)");
        
        long time2 = System.nanoTime();
    	
    	for (int i = 1; i <= ELEMS; i++) {
            linkedList.add(i);
        }
    	
    	time2 = System.nanoTime() - time2;
        System.out.println("Converting " + ELEMS
                + " int to String and inserting them in a LinkedList took " + time2
                + "ns (" + time2 / TO_MS + "ms)");
        
        int mid = arrayList.size()/TWO;
        
        long time3 = System.nanoTime();
        
        for (int i = 0; i <= MAX_READING; i++) {
        	mid++;
        	//System.out.println(arrayList.get(mid));
        }
        
        time3 = System.nanoTime() - time3;
        
        System.out.println("Reading 1000 times an element whose "
        		+ "position is in the middle of the collection took " + time3
        		+ "ns (" + time3 / TO_MS2 + "ms)");
        
        int mid2 = linkedList.size()/TWO;
        
        long time4 = System.nanoTime();
        
        for (int i = 0; i <= MAX_READING; i++) {
        	mid2++;
        	//System.out.println(linkedList.get(mid));
        }
        
        time4 = System.nanoTime() - time4;
        
        System.out.println("Reading 1000 times an element whose "
        		+ "position is in the middle of the collection took " + time4
        		+ "ns (" + time4 / TO_MS2 + "ms)");
        
        Map<String, Long> worldMap = new HashMap<>();
        
        worldMap.put("Africa", 1_110_635_000L);
        worldMap.put("Americas", 972_005_000L);
        worldMap.put("Antartica", 0L);
        worldMap.put("Asia", 4_298_723_000L);
        worldMap.put("Europe", 742_452_000L);
        worldMap.put("Oceania", 38_304_000L);
        
        System.out.println(worldMap);
        
        long sum = 0;
        
        for(final Map.Entry<String, Long> entry : worldMap.entrySet()) {
        	sum = sum + entry.getValue();
        }
        /*
        for (long people : worldMap.values()){
        	sum += people;
        }
        */
        System.out.println("Actually in the World we are in Total: " + sum + " People");
    }
}
