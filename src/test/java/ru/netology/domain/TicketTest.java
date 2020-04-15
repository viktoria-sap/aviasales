package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.Manager;
import ru.netology.repository.Repository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    private Repository repository = new Repository();
    private Manager manager = new Manager(repository);

    private Ticket first = new Ticket(1, 3500, "LED", "SVO", 120);
    private Ticket second = new Ticket(2, 3000, "LED", "SVO", 300);
    private Ticket third = new Ticket(3, 5000,  "VOG", "VKO", 150);
    private Ticket fourth = new Ticket(4, 4500,  "GOJ", "IST", 210);

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

    }

    @Test
    public void shouldSortById() {
        Ticket[] expected = new Ticket[]{second, first, fourth, third};
        Ticket[] actual = new Ticket[]{first, second, third, fourth};

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        manager.removeById(idToRemove);
        Ticket[] actual = repository.getAll();
        Ticket[] expected = new Ticket[]{fourth, third, second};
        assertArrayEquals(expected, actual);
    }
//
//    @Test
//    public void shouldNotRemoveIfNotExists() {
//        int idToRemove = 4;
//        repository.removeById(idToRemove);
//        Film[] actual = repository.getAll();
//        Film[] expected = new Film[]{third, second, first};
//        assertArrayEquals(expected, actual);
//    }

    @Test
    public void shouldRemoveAll() {

        manager.removeAll();
        Ticket[] actual = repository.getAll();
        Ticket[] expected = new Ticket[]{};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindByFromTo() {
        String from = "LED";
        String to = "SVO";

        manager.findByFromTo(from, to);
        Ticket[] expected = new Ticket[]{second, first};
        Ticket[] actual = new Ticket[]{first, second};

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdNonExists() {
        String from = "LED";
        String to = "VOG";

        Ticket expected = null;
        Ticket actual = manager.findByFromTo(from, to);
        assertEquals(expected, actual);
    }

}