import com.cards.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
* The FiveCardTest class to implement all Unit Tests.
*
* @author  Sello Mamorobela
* @version 1.5
* @since   2021-01-15 
 */


public class FiveCardTest {

    private FiveCardDrawHand hand;

    @Before
    public void setUp() {
        hand = new FiveCardDrawHand();
    }

    @Test(expected = HandleException.class)
    public void hasTooManyCards() throws HandleException {
        try {
            hand.addCard(new Card(Rank.ACE, Suit.HEART));
            hand.addCard(new Card(Rank.KING, Suit.HEART));
            hand.addCard(new Card(Rank.QUEEN, Suit.HEART));
            hand.addCard(new Card(Rank.JACK, Suit.HEART));
            hand.addCard(new Card(Rank.TEN, Suit.HEART));
            hand.addCard(new Card(Rank.NINE, Suit.HEART));
        } catch (HandleException ex) {
            Assert.assertEquals("A maximum of 5 cards may be assigned to a hand", ex.getMessage());
            throw ex;
        }
    }
    
    @Test
    public void isStraigthtflush() throws HandleException {
        hand.addCard(new Card(Rank.ACE, Suit.HEART));
        hand.addCard(new Card(Rank.KING, Suit.HEART));
        hand.addCard(new Card(Rank.QUEEN, Suit.HEART));
        hand.addCard(new Card(Rank.JACK, Suit.HEART));
        hand.addCard(new Card(Rank.TEN, Suit.HEART));
        Assert.assertEquals(HandStrength.STRAIGHT_FLUSH, hand.getHandStrength());
    }

    @Test
    public void isFourOfKind() throws HandleException {
        hand.addCard(new Card(Rank.ACE, Suit.HEART));
        hand.addCard(new Card(Rank.ACE, Suit.SPADE));
        hand.addCard(new Card(Rank.ACE, Suit.DIAMOND));
        hand.addCard(new Card(Rank.ACE, Suit.CLUB));
        hand.addCard(new Card(Rank.TEN, Suit.HEART));
        Assert.assertEquals(HandStrength.FOUR_OF_A_KIND, hand.getHandStrength());
    }

    @Test
    public void isFullHouse() throws HandleException {
        hand.addCard(new Card(Rank.ACE, Suit.HEART));
        hand.addCard(new Card(Rank.ACE, Suit.SPADE));
        hand.addCard(new Card(Rank.ACE, Suit.DIAMOND));
        hand.addCard(new Card(Rank.KING, Suit.HEART));
        hand.addCard(new Card(Rank.KING, Suit.CLUB));
        Assert.assertEquals(HandStrength.FULL_HOUSE, hand.getHandStrength());
    }

    @Test
    public void isFlush() throws HandleException {
        hand.addCard(new Card(Rank.ACE, Suit.HEART));
        hand.addCard(new Card(Rank.JACK, Suit.HEART));
        hand.addCard(new Card(Rank.NINE, Suit.HEART));
        hand.addCard(new Card(Rank.SIX, Suit.HEART));
        hand.addCard(new Card(Rank.THREE, Suit.HEART));
        Assert.assertEquals(HandStrength.FLUSH, hand.getHandStrength());
    }

    @Test
    public void isStraightAceHigh() throws HandleException {
        hand.addCard(new Card(Rank.ACE, Suit.HEART));
        hand.addCard(new Card(Rank.KING, Suit.SPADE));
        hand.addCard(new Card(Rank.QUEEN, Suit.DIAMOND));
        hand.addCard(new Card(Rank.JACK, Suit.CLUB));
        hand.addCard(new Card(Rank.TEN, Suit.HEART));
        Assert.assertEquals(HandStrength.STRAIGHT, hand.getHandStrength());
    }
    
    @Test
    public void isStraightKingHigh() throws HandleException {
        hand.addCard(new Card(Rank.KING, Suit.HEART));
        hand.addCard(new Card(Rank.QUEEN, Suit.SPADE));
        hand.addCard(new Card(Rank.JACK, Suit.DIAMOND));
        hand.addCard(new Card(Rank.TEN, Suit.CLUB));
        hand.addCard(new Card(Rank.NINE, Suit.HEART));
        Assert.assertEquals(HandStrength.STRAIGHT, hand.getHandStrength());
    }
    
    @Test
    public void isStraightSixHigh() throws HandleException {
        hand.addCard(new Card(Rank.SIX, Suit.HEART));
        hand.addCard(new Card(Rank.FIVE, Suit.SPADE));
        hand.addCard(new Card(Rank.FOUR, Suit.DIAMOND));
        hand.addCard(new Card(Rank.THREE, Suit.CLUB));
        hand.addCard(new Card(Rank.TWO, Suit.HEART));
        Assert.assertEquals(HandStrength.STRAIGHT, hand.getHandStrength());
    }

    @Test
    public void isThreeOfKind() throws HandleException {
        hand.addCard(new Card(Rank.ACE, Suit.HEART));
        hand.addCard(new Card(Rank.ACE, Suit.SPADE));
        hand.addCard(new Card(Rank.ACE, Suit.DIAMOND));
        hand.addCard(new Card(Rank.THREE, Suit.CLUB));
        hand.addCard(new Card(Rank.TWO, Suit.HEART));
        Assert.assertEquals(HandStrength.THREE_OF_A_KIND, hand.getHandStrength());
    }

    @Test
    public void isTwoPair() throws HandleException {
        hand.addCard(new Card(Rank.ACE, Suit.HEART));
        hand.addCard(new Card(Rank.ACE, Suit.SPADE));
        hand.addCard(new Card(Rank.KING, Suit.DIAMOND));
        hand.addCard(new Card(Rank.KING, Suit.CLUB));
        hand.addCard(new Card(Rank.TWO, Suit.HEART));
        Assert.assertEquals(HandStrength.TWO_PAIR, hand.getHandStrength());
    }

    @Test
    public void isOnePair() throws HandleException {
        hand.addCard(new Card(Rank.ACE, Suit.HEART));
        hand.addCard(new Card(Rank.ACE, Suit.SPADE));
        hand.addCard(new Card(Rank.FOUR, Suit.DIAMOND));
        hand.addCard(new Card(Rank.THREE, Suit.CLUB));
        hand.addCard(new Card(Rank.TWO, Suit.HEART));
        Assert.assertEquals(HandStrength.ONE_PAIR, hand.getHandStrength());
    }

    @Test
    public void isHighCard() throws HandleException {
        hand.addCard(new Card(Rank.ACE, Suit.HEART));
        hand.addCard(new Card(Rank.FIVE, Suit.SPADE));
        hand.addCard(new Card(Rank.FOUR, Suit.DIAMOND));
        hand.addCard(new Card(Rank.THREE, Suit.CLUB));
        hand.addCard(new Card(Rank.TWO, Suit.HEART));
        Assert.assertEquals(HandStrength.HIGH_CARD, hand.getHandStrength());
    }

}
