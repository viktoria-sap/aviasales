package ru.netology.repository;

import ru.netology.domain.Suggestion;

import java.util.Comparator;

public class SuggestionRepository {

    private Suggestion[] tickets = new Suggestion[0];

    public void save(Suggestion ticket) {
        int length = tickets.length + 1;
        Suggestion[] tmp = new Suggestion[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tickets = tmp;
    }

    public Suggestion[] findAll() {
        return tickets;
    }

    public void findByFromTo(String from, String to) {
        Suggestion[] tmp = new Suggestion[0];
        int index = 0;
        for (Suggestion ticket : tickets) {
            if (ticket.getFrom().equals(from) & ticket.getTo().equals(to)) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
    }

    public Suggestion findByFromToComparator(String from, String to, Comparator<Suggestion> comparator) {
        for (Suggestion ticket : tickets) {
            if (ticket.getFrom().equals(from) & ticket.getTo().equals(to)) {
                return ticket;
            }
        }
        return null;
    }

    public void removeAll() {
        tickets = new Suggestion[]{};
    }

    public void removeById(int id) {
        int length = tickets.length - 1;
        Suggestion[] tmp = new Suggestion[length];
        int index = 0;
        for (Suggestion ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
    }


}