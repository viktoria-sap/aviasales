package ru.netology.repository;

import ru.netology.domain.Ticket;

import java.util.Comparator;

public class Repository {

    private Ticket[] tickets = new Ticket[0];

    public void save(Ticket ticket) {
        int length = tickets.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tickets = tmp;
    }

    public Ticket[] findAll() {
        return tickets;
    }

    public Ticket findByFromTo(String from, String to) {
        for (Ticket ticket : tickets) {
            if (ticket.getFrom() == from & ticket.getTo() == to) {
                return ticket;
            }
        }
        return null;
    }

    public Ticket findByFromToComparator(String from, String to, Comparator<Ticket> comparator) {
        for (Ticket ticket : tickets) {
            if (ticket.getFrom() == from & ticket.getTo() == to) {
                return ticket;
            }
        }
        return null;
    }

    public void removeAll() {
        tickets = new Ticket[]{};
    }

    public void removeById(int id) {
        int length = tickets.length - 1;
        Ticket[] tmp = new Ticket[length];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
    }

    public Ticket[] getAll() {
        Ticket[] films = findAll();
        Ticket[] result = new Ticket[films.length];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }

}