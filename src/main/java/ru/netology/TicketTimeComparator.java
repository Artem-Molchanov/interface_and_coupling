package ru.netology;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {

        int hoursT1 = t1.getTimeTo() - t1.getTimeFrom();
        int hoursT2 = t2.getTimeTo() - t2.getTimeFrom();

        if (hoursT1 < hoursT2) {
            return -1;
        } else if (hoursT1 > hoursT2) {
            return 1;
        } else {
            return 0;

        }
    }

}


