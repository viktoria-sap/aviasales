package ru.netology.domain;

import java.util.Comparator;

public class SuggestionComparator implements Comparator<Suggestion> {

    public int compare(Suggestion o1, Suggestion o2) {
        return o1.getTime() - o2.getTime();
    }
}
