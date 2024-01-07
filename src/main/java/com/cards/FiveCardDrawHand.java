package com.cards;


import java.util.ArrayList;
import java.util.List;

public class FiveCardDrawHand implements Hand {

    private final List<Card> cards;

    public FiveCardDrawHand() {
        cards = new ArrayList<>();
    }


    public void addCard(Card card) throws HandleException{
        if (cards.size() == 5) {
            throw new HandleException("A maximum of 5 cards may be assigned to a hand");
        }
        cards.add(card);
    }

 
    public HandStrength getHandStrength() {
        if (isStraightFlush()) {
            return HandStrength.STRAIGHT_FLUSH;
        }
        if (isFourOfKind()) {
            return HandStrength.FOUR_OF_A_KIND;
        }
        if (isFullHouse()) {
            return HandStrength.FULL_HOUSE;
        }
        if (isFlush()) {
            return HandStrength.FLUSH;
        }
        if (isStraight()) {
            return HandStrength.STRAIGHT;
        }
        if (isThreeOfKind()) {
            return HandStrength.THREE_OF_A_KIND;
        }
        if (isTwoPair()) {
            return HandStrength.TWO_PAIR;
        }
        if (isOnePair()) {
            return HandStrength.ONE_PAIR;
        }
        return HandStrength.HIGH_CARD;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Card card : cards) {
            stringBuilder.append(card.toString());
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    private boolean isStraightFlush() {
        return isFlush() && isStraight();
    }

    private boolean isFourOfKind() {
        int[] countRanks = countRanks();
        for (int countRank : countRanks) {
            if (countRank == 4) {
                return true;
            }
        }
        return false;
    }

    private boolean isFullHouse() {
        int pairCount = 0;
        int threeOfKindCount = 0;
        int[] countRanks = countRanks();
        for (int countRank : countRanks) {
            if (countRank == 2) {
                pairCount++;
            }
            if (countRank == 3) {
                threeOfKindCount++;
            }
        }
        return (threeOfKindCount == 1) && (pairCount == 1);
    }

    private boolean isFlush() {
        int[] countSuits = countSuits();
        for (int countSuit : countSuits) {
            if (countSuit == 5) {
                return true;
            }
        }
        return false;
    }

    private boolean isStraight() {
        int seriesLength = 0;
        int[] countRanks = countRanks();
        for (int countRank : countRanks) {
            if (countRank == 1) {
                seriesLength++;
            } else {
                seriesLength = 0;
            }
            if (seriesLength == 5) {
                return true;
            }
        }
        return false;
    }

    private boolean isThreeOfKind() {
        int[] countRanks = countRanks();
        for (int countRank : countRanks) {
            if (countRank == 3) {
                return true;
            }
        }
        return false;
    }

    private boolean isTwoPair() {
        int pairCount = 0;
        int[] countRanks = countRanks();
        for (int countRank : countRanks) {
            if (countRank == 2) {
                pairCount++;
            }
        }
        return pairCount == 2;
    }

    private boolean isOnePair() {
        int[] countRanks = countRanks();
        for (int countRank : countRanks) {
            if (countRank == 2) {
                return true;
            }
        }
        return false;
    }

    private int[] countSuits() {
        int[] suitCount = new int[4];
        for (Card card : cards) {
            if (card.suit() == Suit.HEART) {
                suitCount[0]++;
            }
            if (card.suit() == Suit.SPADE) {
                suitCount[1]++;
            }
            if (card.suit() == Suit.DIAMOND) {
                suitCount[2]++;
            }
            if (card.suit() == Suit.CLUB) {
                suitCount[3]++;
            }
        }
        return suitCount;
    }

    private int[] countRanks() {
        int[] rankCount = new int[13];
        for (Card card : cards) {
            switch (card.rank()) {
                case ACE -> rankCount[0]++;
                case KING -> rankCount[1]++;
                case QUEEN -> rankCount[2]++;
                case JACK -> rankCount[3]++;
                case TEN -> rankCount[4]++;
                case NINE -> rankCount[5]++;
                case EIGHT -> rankCount[6]++;
                case SEVEN -> rankCount[7]++;
                case SIX -> rankCount[8]++;
                case FIVE -> rankCount[9]++;
                case FOUR -> rankCount[10]++;
                case THREE -> rankCount[11]++;
                case TWO -> rankCount[12]++;
                default -> throw new IllegalStateException("Unexpected value: " + card.rank());
            }
        }
        return rankCount;
    }
}
