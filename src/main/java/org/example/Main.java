package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        TripletDeque<Integer> a = new TripletDeque<>();

        a.addFirst( 5);
        a.addFirst(5);
        a.addLast(4);
        a.addFirst( 47);
        a.addLast(4);
        a.addLast(48);
        a.addFirst( 1);
        a.addFirst( 2);
        a.addFirst( 6);
        a.addLast(440);
        Collection<Integer> IntegerCollection = new ArrayList<>();
        IntegerCollection.add(8);
        IntegerCollection.add(8);
        IntegerCollection.add(8);
////        IntegerCollection.add(null);
//        IntegerCollection.add(880);
//        System.out.println(a.addAll(IntegerCollection));
//        a.push(440);
//        a.push(440);
//        a.push(44000);
//        System.out.println(a.size());
//        a.removeFirst();
////        a.removeFirst();
//        a.removeFirstOccurrence(4);
//        a.removeFirstOccurrence(4);
////        a.removeFirstOccurrence(47);
//        a.removeFirstOccurrence(5);
//        a.removeFirstOccurrence(5);

//        a.removeLastOccurrence(47);
        while (a.iterator().hasNext()){
            System.out.print(a.iterator().next() + " ");
        }
        System.out.println(a.It());


//        Iterator<Integer> it =  a.iterator();
//        System.out.println(it);

//        System.out.println(a.removeLastOccurrence(6));
//        System.out.println(a.removeLastOccurrence(47));
//        System.out.println(a.removeLastOccurrence(4));
//        System.out.println(a.removeLastOccurrence(4));
//        System.out.println(a.removeLastOccurrence(48));
//        System.out.println(a.removeLastOccurrence(2));
//        System.out.println(a.removeLastOccurrence(1));
//        System.out.println(a.removeLastOccurrence(5));
//        System.out.println(a.removeFirstOccurrence(1));
//        System.out.println(a.removeFirstOccurrence(6));
//        System.out.println(a.removeFirstOccurrence(1));
//        System.out.println(a.removeFirstOccurrence(4));
//        System.out.println(a.removeFirstOccurrence(4));
//        System.out.println(a.removeFirstOccurrence(40));
//        System.out.println(a.removeFirstOccurrence(440));
//        System.out.println(a.removeFirstOccurrence(5));
//        System.out.println(a.removeFirstOccurrence(5));
//        System.out.println(a.removeFirstOccurrence(48));
//        a.addFirst( 2);
//        a.addLast(4);
//        System.out.println(a.pollFirst());
//        System.out.println(a.offerFirst(null));

//        a.addFirst( 3);
//        a.addFirst( 5);
//        a.addFirst( 5);
//        a.addLast(4);

        a.Print();
//        a.addFirst("one");
//        a.addFirst("two");
//        System.out.println(a.getFirst());
//        System.out.println(a.getLast());
//        a.addFirst("three");
//        System.out.println(a.getFirst());
//        System.out.println(a.getLast());
//        a.addFirst("four");
//        a.addLast("five");
//        a.addFirst("six");
//        System.out.println(a.getFirst());
//        System.out.println(a.getLast());
//        System.out.println(a.getLast());
    }
}