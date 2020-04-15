package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Ticket;
import ru.netology.repository.Repository;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Manager {
    private Repository repository;

    public Manager(Repository repository) {
        this.repository = repository;
    }

    private Ticket[] tickets = new Ticket[0];

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public void removeAll() {
        repository.removeAll();
    }

    public Ticket[] getAll() {
        Ticket[] tickets = repository.findAll();
        Ticket[] result = new Ticket[tickets.length];
        for (int i = 0; i < result.length; i++) {
            int index = tickets.length - i - 1;
            result[i] = tickets[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Ticket findByFromTo(String from, String to) {
        return repository.findByFromTo(from, to);
    }

}