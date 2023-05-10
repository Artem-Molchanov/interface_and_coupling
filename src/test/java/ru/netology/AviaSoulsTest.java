package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Moscow", "St.Petersburg", 500, 11, 13);
    Ticket ticket2 = new Ticket("Moscow", "St.Petersburg", 400, 11, 14);
    Ticket ticket3 = new Ticket("Moscow", "St.Petersburg", 300, 11, 15);
    Ticket ticket4 = new Ticket("Moscow", "St.Petersburg", 200, 11, 16);
    Ticket ticket5 = new Ticket("Moscow", "St.Petersburg", 100, 11, 17);

    AviaSouls aviaSouls = new AviaSouls();

    TicketTimeComparator comparator = new TicketTimeComparator();

    @Test
    public void shouldTestCompareTo() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] tickets = {ticket1, ticket2, ticket3,ticket4,ticket5};
        Arrays.sort(tickets);

        Ticket[] expected = {ticket5, ticket4,ticket3,ticket2,ticket1};
        Ticket[] actual = tickets;

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldTestTicketPriceSort() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.search("Moscow", "St.Petersburg");

        Ticket[] expected = {ticket5, ticket4, ticket3, ticket2, ticket1};
        Ticket[] actual = aviaSouls.findAll();

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldTestFlyTimeSort() {

        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);

        Ticket[] tickets = {ticket2, ticket1};
        Arrays.sort(tickets, ticketTimeComparator);

        Ticket[] expected =  {ticket1, ticket2};
        Ticket[] actual = tickets;

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldTestParamsComparator() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        aviaSouls.searchAndSortBy("Moscow", "St.Petersburg", comparator);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = aviaSouls.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }
}
