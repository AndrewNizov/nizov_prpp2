package lab_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TransportCardTest {

    @Test
    public void defaultConstructorLeavesFieldsEmpty() {
        TransportCard card = new TransportCard();

        assertNull(card.getOwner());
        assertEquals(0, card.getBalance());
        assertEquals(0, card.getTrips());
        assertEquals(0, card.getSpent());
    }

    @Test
    public void constructorRejectsNegativeBalance() {
        TransportCard card = new TransportCard("Ivanov", -50);

        assertEquals("Ivanov", card.getOwner());
        assertEquals(0, card.getBalance());
    }

    @Test
    public void topUpIgnoresNonPositiveAmount() {
        TransportCard card = new TransportCard("Ivanov", 100);

        card.topUp(0);
        card.topUp(-50);

        assertEquals(100, card.getBalance());
    }

    @Test
    public void topUpAddsPositiveAmount() {
        TransportCard card = new TransportCard("Ivanov", 100);

        card.topUp(200);

        assertEquals(300, card.getBalance());
    }

    @Test
    public void isPremiumIsTrueExactlyAt500() {
        TransportCard card = new TransportCard("Ivanov", 500);

        assertTrue(card.isPremium());

        TransportCard anotherCard = new TransportCard("Petrov", 499);

        assertFalse(anotherCard.isPremium());
    }

    @Test
    public void payReducesBalanceAndCountsTrip() {
        TransportCard card = new TransportCard("Ivanov", 500);

        boolean result = card.pay(35);

        assertTrue(result);
        assertEquals(465, card.getBalance());
        assertEquals(1, card.getTrips());
        assertEquals(35, card.getSpent());
    }

    @Test
    public void payRejectsAmountGreaterThanBalance() {
        TransportCard card = new TransportCard("Ivanov", 100);

        boolean result = card.pay(150);

        assertFalse(result);
        assertEquals(100, card.getBalance());
        assertEquals(0, card.getTrips());
        assertEquals(0, card.getSpent());
    }

    @Test
    public void averageFareUsesIntegerDivision() {
        TransportCard card = new TransportCard("Ivanov", 500);

        card.pay(35);
        card.pay(40);

        assertEquals(37, card.getAverageFare());
    }

    @Test
    public void averageFareIsZeroWithoutTrips() {
        TransportCard card = new TransportCard("Ivanov", 500);

        assertEquals(0, card.getAverageFare());
    }

    @Test
    public void copyConstructorMakesIndependentCopy() {
        TransportCard original = new TransportCard("Ivanov", 500);

        original.pay(100);

        TransportCard copy = new TransportCard(original);

        copy.topUp(200);

        assertEquals(400, original.getBalance());
        assertEquals(600, copy.getBalance());
        assertEquals(original.getTrips(), copy.getTrips());
        assertEquals(original.getSpent(), copy.getSpent());
    }
}