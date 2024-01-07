package com.cards;

/**
 * The Card class implements a Card that
 * that is part of a Deck.
 *
 * @author Sello Mamorobela
 * @version 1.5
 */

public record Card(Rank rank, Suit suit) {

    @Override
    public String toString() {
        return rank.getDisplayValue() + suit.getUnicodeCharacter();
    }

}
