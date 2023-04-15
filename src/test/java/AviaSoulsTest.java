import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    Ticket t1 = new Ticket("Samara", "Moscow", 2500, 19, 21);
    Ticket t2 = new Ticket("Samara", "Sochi", 5500, 15, 19);
    Ticket t3 = new Ticket("Samara", "Kazan", 1000, 14, 15);
    Ticket t4 = new Ticket("Samara", "Saint Petersburg", 5500, 12, 15);
    Ticket t5 = new Ticket("Samara", "Moscow", 2400, 19, 21);
    Ticket t6 = new Ticket("Samara", "Moscow", 2700, 19, 20);

    @Test
    public void compareToTestOne() {
        AviaSouls tickets = new AviaSouls();

        tickets.add(t1);
        tickets.add(t2);
        tickets.add(t3);
        tickets.add(t4);

        int expected = -1;
        int actual = t1.compareTo(t2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareToTestTwo() {
        AviaSouls tickets = new AviaSouls();

        tickets.add(t1);
        tickets.add(t2);
        tickets.add(t3);
        tickets.add(t4);

        int expected = 1;
        int actual = t4.compareTo(t3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareToTestThree() {
        AviaSouls tickets = new AviaSouls();

        tickets.add(t1);
        tickets.add(t2);
        tickets.add(t3);
        tickets.add(t4);

        int expected = 0;
        int actual = t2.compareTo(t4);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchTest() {
        AviaSouls tickets = new AviaSouls();

        tickets.add(t1);
        tickets.add(t2);
        tickets.add(t3);
        tickets.add(t4);
        tickets.add(t5);

        Ticket[] expected = {t5, t1};
        Ticket[] actual = tickets.search("Samara", "Moscow");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void comparatorTestOne() {
        TicketTimeComparator comparator = new TicketTimeComparator();

        int expected = -1;
        int actual = comparator.compare(t1, t2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void comparatorTestTwo() {
        TicketTimeComparator comparator = new TicketTimeComparator();

        int expected = 1;
        int actual = comparator.compare(t1, t3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void comparatorTestThree() {
        TicketTimeComparator comparator = new TicketTimeComparator();

        int expected = 0;
        int actual = comparator.compare(t1, t5);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchAndSortByTest() {
        AviaSouls tickets = new AviaSouls();

        tickets.add(t1);
        tickets.add(t2);
        tickets.add(t3);
        tickets.add(t4);
        tickets.add(t5);
        tickets.add(t6);

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] expected = {t6, t1, t5};
        Ticket[] actual = tickets.searchAndSortBy("Samara", "Moscow", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

}
