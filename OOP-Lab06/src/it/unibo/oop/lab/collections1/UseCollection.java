package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
	private static final int ELEMS = 1_000_000;
    private static final int TO_MS = 1_000_000;
    private static final int READINGS= 1000;

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
    	final var list = new ArrayList<Integer>();
    	for (int i = 1000; i < 2000; i ++) {
    		list.add(i);
    	}
    	
    	System.out.println(list);
    	
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	final var list2 = new LinkedList<Integer>(list);
        
    	System.out.println(list2);
    	
    	/*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	
    	final var temp = list.get(0);
    	list.set(0, list.get(list.size() - 1));
    	list.set(list.size() - 1, temp);
    	
    	System.out.println(list);
    	
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	
    	for (final int i : list2) {
    		System.out.println(i);
    	}
    	
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	
    	long time = System.nanoTime();
    	
    	for (int i = 0; i < ELEMS; i++) {
            list.add(i);
        }
    	
    	time = System.nanoTime() - time;
    	System.out.println("Adding " + ELEMS + " in ArrayList took : " + time / TO_MS + "ms");
    	
    	long time2 = System.nanoTime();
    	
    	for (int i = 0; i < ELEMS; i++) {
            list2.add(i);
        }
    	
    	time2 = System.nanoTime() - time2;
    	System.out.println("Adding " + ELEMS + " in LinkedList took : " + time2 / TO_MS + "ms");
    	
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	
    	long time3 = System.nanoTime();
    	
    	for (int i = 0; i < READINGS; i ++) {
    		System.out.println(list.get(list.size() / 2));
    	}
    	
    	time3 = System.nanoTime() - time3;
    	System.out.println("READING " + list.size() + " elements in ArrayList took : " + time3 / TO_MS + "ms");
    	
    	long time4 = System.nanoTime();
    	
    	for (int i = 0; i < READINGS; i ++) {
    		System.out.println(list2.get(list2.size() / 2));
    	}
    	
    	time4 = System.nanoTime() - time4;
    	System.out.println("READING " + list2.size() + " elements in LinkedList took : " + time4 / TO_MS + "ms");
    	
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
    	final Map<String,Double> map = new HashMap<>();
    	
    	map.put("Africa",     1110635000.0);
    	map.put("Americas",    972005000.0);
    	map.put("Antarctica",          0.0);
    	map.put("Asia",       4298723000.0);
    	map.put("Europe",      742452000.0);
    	map.put("Oceania",      38304000.0);
    	
    	System.out.println(map);
    	
        /*
         * 8) Compute the population of the world
         */
    	var total = 0;
    	for (final Double i : map.values()) {
    		total += i;
    	}
    	
    	System.out.println("Totale popolazione nel mondo: " +total);
    }
}
