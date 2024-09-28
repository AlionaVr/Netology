package org.spacePersonComparator;

import java.util.Comparator;

class SpacePersonComparator implements Comparator<Person> {


    @Override
    public int compare(Person p1, Person p2) {
        int comparisonOfExp = Integer.compare(p2.getExperience(), p1.getExperience());
        if (comparisonOfExp != 0) {
            return comparisonOfExp;
        }
        String name1 = p1.getName();
        String name2 = p2.getName();
        int countS1 = countOfSInName(name1);
        int countS2 = countOfSInName(name2);

        if (countS2 != countS1) {
            return Integer.compare(countS2, countS1);
        }
        return Integer.compare(name1.length(), name2.length());
    }


    public int countOfSInName(String name) {
        int counter = 0;
        char[] letters = name.toLowerCase().toCharArray();
        for (char letter : letters) {
            if (letter == 's') {
                counter++;
            }
        }
        return counter;
    }
}