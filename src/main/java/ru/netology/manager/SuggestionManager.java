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

    public void add(Suggestion ticket) {
        repository.save(ticket);
    }

    public Suggestion[] getAll() {
        return repository.findAll();
    }

    public void removeAll() {
        repository.removeAll();
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Suggestion[] findByFromTo(String from, String to) {
        Suggestion[] result = new Suggestion[0];
        for (Suggestion ticket : getAll()) {
            if (ticket.getFrom().equals(from) & ticket.getTo().equals(to)) {
                Suggestion[] tmp = new Suggestion[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public Suggestion[] findByFromToComparator(String from, String to, Comparator<Suggestion> comparator) {
        Suggestion[] result = new Suggestion[0];
        for (Suggestion ticket : getAll()) {
            if (ticket.getFrom().equals(from) & ticket.getTo().equals(to)) {
                Suggestion[] tmp = new Suggestion[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }

}