package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketComparator implements Comparator<Ticket> {
    private int id;
    private int price;
    private String from;
    private String to;
    private int time;

    public int compare(Ticket o1, Ticket o2) {
        return o1.getPrice() - o2.getPrice();
    }
}