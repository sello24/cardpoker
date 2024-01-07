package com.cards;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static java.util.logging.Logger logger = java.util.logging.Logger.getLogger("Main.class");
    private static final int CARD_NUM = 5;

    public static void main(String[] args) throws HandleException {


        logger.info("Shuffling ... Shuffling ... Shuffling");
        // Create a standard deck of 52 cards
        List<Card> deck = createDeck();
        // Shuffle the deck
        Collections.shuffle(deck);
        // Deal a hand of 5 cards to the player
        FiveCardDrawHand playerHand = dealHand(deck);
        // Evaluate the player's hand
        logger.info("Your Hand: "+ playerHand);
        logger.info("You have: "+ playerHand.getHandStrength().getDisplayString());
    }

      private static FiveCardDrawHand dealHand(List<Card> deck) throws HandleException {
        FiveCardDrawHand hand = new FiveCardDrawHand();
        for (int i = 0; i < CARD_NUM; i++) {

            hand.addCard(deck.removeFirst());
        }
        return hand;
    }
    private static List<Card> createDeck() {
        List<Card> deck = new ArrayList<>();

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(rank, suit));
            }
        }

        return deck;
    }

}
