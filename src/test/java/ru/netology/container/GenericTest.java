package ru.netology.container;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.*;

class GenericBoxTest {
    @Test
    public void shouldParametrizedWithProduct() {
        Ticket ticket = new Ticket();
        Generic<Ticket> ticketBox = new Generic<>(ticket);

        Ticket value = ticketBox.getValue();
        assertEquals(ticket, value);
    }

    @Test
    public void shouldParametrizedWithString() {
        String str = "Hello world";
        Generic<String> stringBox = new Generic<>(str);

        String value = stringBox.getValue();
        assertEquals(str, value);
    }
}