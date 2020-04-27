package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.SuggestionManager;
import ru.netology.repository.SuggestionRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    private SuggestionRepository repository = new SuggestionRepository();
    private SuggestionManager manager = new SuggestionManager(repository);
    private SuggestionComparator comparator = new SuggestionComparator();

    private Suggestion first = new Suggestion(1, 3500, "LED", "SVO", 300);
    private Suggestion second = new Suggestion(2, 3000, "LED", "SVO", 120);
    private Suggestion third = new Suggestion(3, 5000, "VOG", "VKO", 150);
    private Suggestion fourth = new Suggestion(4, 4500, "GOJ", "IST", 210);

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        manager.removeById(idToRemove);
        Suggestion[] actual = manager.getAll();
        Suggestion[] expected = new Suggestion[]{second, third, fourth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {

        manager.removeAll();
        Suggestion[] actual = manager.getAll();
        Suggestion[] expected = new Suggestion[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByFromTo() {
        Suggestion[] expected = new Suggestion[]{second, first};
        Suggestion[] actual = manager.findByFromTo("LED", "SVO");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByFromToComparator() {
        String from = "LED";
        String to = "SVO";

        Suggestion[] expected = new Suggestion[]{second, first};
        Suggestion[] result = manager.findByFromToComparator(from, to, comparator);

        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldFindByIdIfNotExists() {
        String from = "LED";
        String to = "VOG";

        Suggestion[] expected = new Suggestion[]{};
        Suggestion[] actual = manager.findByFromTo(from, to);
        assertArrayEquals(expected, actual);
    }

}