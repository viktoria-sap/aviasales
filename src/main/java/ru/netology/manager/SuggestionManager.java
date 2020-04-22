package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Suggestion;
import ru.netology.domain.SuggestionComparator;
import ru.netology.repository.SuggestionRepository;

import java.util.Arrays;
import java.util.Comparator;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SuggestionManager {
    private SuggestionRepository repository;

    public SuggestionManager(SuggestionRepository repository) {
        this.repository = repository;
    }

    private Suggestion[] tickets = new Suggestion[0];
    private SuggestionComparator[] ticketsComparator = new SuggestionComparator[0];

    public void add(Suggestion ticket) {
        repository.save(ticket);
    }

    public void removeAll() {
        repository.removeAll();
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void getAll() {
        repository.findAll();
    }

    public Suggestion[] findByFromTo(String from, String to) {
        Suggestion[] tmp = new Suggestion[0];
        int index = 0;
        for (Suggestion ticket : tickets) {
            if (ticket.getFrom().equals(from) & ticket.getTo().equals(to)) {
                tmp[index] = ticket;
                index++;
            }
        }
        Arrays.sort(tmp);
        return tmp;
    }

    public SuggestionComparator[] findByFromToComparator(String from, String to, Comparator<SuggestionComparator> comparator) {
        SuggestionComparator[] tmp = new SuggestionComparator[0];
        int index = 0;
        for (SuggestionComparator ticket : ticketsComparator) {
            if (ticket.getFrom().equals(from) & ticket.getTo().equals(to)) {
                tmp[index] = ticket;
                index++;
            }
        }
        Arrays.sort(tmp, comparator);
        return tmp;
    }

}