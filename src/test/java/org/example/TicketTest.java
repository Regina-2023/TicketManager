package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test
    public void sortTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Omsk", "SPB", 7_000, 8, 9);
        Ticket ticket2 = new Ticket("MSK", "Istanbul", 20_000, 10, 13);
        Ticket ticket3 = new Ticket("Omsk", "SPB", 5_000, 6, 7);
        Ticket ticket4 = new Ticket("Omsk", "SPB", 15_000, 13, 14);
        Ticket ticket5 = new Ticket("MSK", "Dubai", 8_000, 8, 12);
        Ticket ticket6 = new Ticket("Omsk", "SPB", 8_000, 12, 13);
        Ticket ticket7 = new Ticket("SPB", "Dubai", 13_000, 11, 14);
        Ticket ticket8 = new Ticket("Omsk", "SPB", 12_000, 22, 23);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket3, ticket1, ticket6, ticket8, ticket4};
        Ticket[] actual = manager.search("Omsk", "SPB");

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void sortTicketsNotFound() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Omsk", "SPB", 7_000, 8, 9);
        Ticket ticket2 = new Ticket("MSK", "Istanbul", 20_000, 10, 13);
        Ticket ticket3 = new Ticket("Omsk", "SPB", 5_000, 6, 7);
        Ticket ticket4 = new Ticket("Omsk", "SPB", 15_000, 13, 14);
        Ticket ticket5 = new Ticket("MSK", "Dubai", 8_000, 8, 12);
        Ticket ticket6 = new Ticket("Omsk", "SPB", 8_000, 12, 13);
        Ticket ticket7 = new Ticket("SPB", "Dubai", 13_000, 11, 14);
        Ticket ticket8 = new Ticket("Omsk", "SPB", 12_000, 22, 23);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("Omsk", "MSK");

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void sortTicketsOneFound() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Omsk", "SPB", 7_000, 8, 9);
        Ticket ticket2 = new Ticket("MSK", "Istanbul", 20_000, 10, 13);
        Ticket ticket3 = new Ticket("Omsk", "SPB", 5_000, 6, 7);
        Ticket ticket4 = new Ticket("Omsk", "SPB", 15_000, 13, 14);
        Ticket ticket5 = new Ticket("MSK", "Dubai", 8_000, 8, 12);
        Ticket ticket6 = new Ticket("Omsk", "SPB", 8_000, 12, 13);
        Ticket ticket7 = new Ticket("SPB", "Dubai", 13_000, 11, 14);
        Ticket ticket8 = new Ticket("Omsk", "SPB", 12_000, 22, 23);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.search("MSK", "Dubai");

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void sortTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Omsk", "SPB", 7_000, 8, 10);            // 2
        Ticket ticket2 = new Ticket("MSK", "Istanbul", 20_000, 10, 13);
        Ticket ticket3 = new Ticket("Omsk", "SPB", 5_000, 6, 10);            // 4
        Ticket ticket4 = new Ticket("Omsk", "SPB", 15_000, 13, 14);          // 1
        Ticket ticket5 = new Ticket("MSK", "Dubai", 8_000, 8, 12);
        Ticket ticket6 = new Ticket("Omsk", "SPB", 8_000, 12, 15);           // 3
        Ticket ticket7 = new Ticket("SPB", "Dubai", 13_000, 11, 14);
        Ticket ticket8 = new Ticket("Omsk", "SPB", 12_000, 22, 23);          // 1
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket4, ticket8, ticket1, ticket6, ticket3};
        Ticket[] actual = manager.search("Omsk", "SPB", comparator);

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void sortTicketsWithComparatorNotFound() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Omsk", "SPB", 7_000, 8, 10);
        Ticket ticket2 = new Ticket("MSK", "Istanbul", 20_000, 10, 13);
        Ticket ticket3 = new Ticket("Omsk", "SPB", 5_000, 6, 10);
        Ticket ticket4 = new Ticket("Omsk", "SPB", 15_000, 13, 14);
        Ticket ticket5 = new Ticket("MSK", "Dubai", 8_000, 8, 12);
        Ticket ticket6 = new Ticket("Omsk", "SPB", 8_000, 12, 15);
        Ticket ticket7 = new Ticket("SPB", "Dubai", 13_000, 11, 14);
        Ticket ticket8 = new Ticket("Omsk", "SPB", 12_000, 22, 23);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.search("MSK", "SPB", comparator);

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void sortTicketsWithComparatorOneFound() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Omsk", "SPB", 7_000, 8, 10);
        Ticket ticket2 = new Ticket("MSK", "Istanbul", 20_000, 10, 13);
        Ticket ticket3 = new Ticket("Omsk", "SPB", 5_000, 6, 10);
        Ticket ticket4 = new Ticket("Omsk", "SPB", 15_000, 13, 14);
        Ticket ticket5 = new Ticket("MSK", "Dubai", 8_000, 8, 12);
        Ticket ticket6 = new Ticket("Omsk", "SPB", 8_000, 12, 15);
        Ticket ticket7 = new Ticket("SPB", "Dubai", 13_000, 11, 14);
        Ticket ticket8 = new Ticket("Omsk", "SPB", 12_000, 22, 23);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket7};
        Ticket[] actual = manager.search("SPB", "Dubai", comparator);

        Assertions.assertArrayEquals(expected,actual);
    }

}