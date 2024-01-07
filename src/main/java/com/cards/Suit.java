package com.cards;

/**
* The Suit enumeration class to represent a Suit .
*
* @author  Sello Mamorobela
* @version 1.5
 */


public enum Suit {
	
	/**
	 * The unicode characters next to the enum value may be used as the constructor,
	 * but will only work if the console and JVM file encoding is set to UTF-8.
	 * This does not work well on Windows.
	 */
	
    HEART('\u2665'),
    SPADE('\u2660'),
    DIAMOND('\u2666'),
    CLUB('\u2663');

    private final char unicodeCharacter;

    Suit(char unicodeCharacter) {
        this.unicodeCharacter = unicodeCharacter;
    }

    public char getUnicodeCharacter() {
        return unicodeCharacter;
    }
}
