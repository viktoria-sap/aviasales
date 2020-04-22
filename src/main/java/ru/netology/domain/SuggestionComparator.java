package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SuggestionComparator implements Comparator<Suggestion> {
    private int id;
    private int price;
    private String from;
    private String to;
    private int time;

    public int compare(Suggestion o1, Suggestion o2) {
        return o1.getTime() - o2.getTime();
    }
}
