package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Suggestion;
import ru.netology.repository.SuggestionRepository;

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

    public void removeAll() {
        repository.removeAll();
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void findByFromTo(String from, String to) {
        repository.findByFromTo(from, to);
    }

    public Suggestion findByFromToComparator(String from, String to, Comparator<Suggestion> comparator) {
        return repository.findByFromToComparator(from, to, comparator);
    }

}