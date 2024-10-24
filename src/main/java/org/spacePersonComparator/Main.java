package org.spacePersonComparator;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;


public class
Main {

    public static void main(String[] args) {
        TreeSet<Person> candidates = new TreeSet<>(new SpacePersonComparator());
        //Comparator.comparing(Person::getExperience, Comparator.reverseOrder())
        //        .thenComparing(Main::countS, Comparator.reverseOrder())
        //        .thenComparing(person -> person.getName().length()));
        candidates.add(new Person("Sonya Popova", 35, 15));
        candidates.add(new Person("Dazdraperma Sponzhova", 33, 15));
        candidates.add(new Person("Salavat Netologshvili", 23, 13));
        candidates.add(new Person("Sasha Sun", 31, 15));
        candidates.add(new Person("Svetlana Morkov", 38, 15));
        candidates.add(new Person("Sasha Sosnova", 38, 11));

        Iterator<Person> it = candidates.iterator();
        System.out.println(it.next());
        System.out.println(it.next());

    }
}

