package com.cards;

/**
* The Hand Interface class.
*
* @author  Sello Mamorobela
* @version 1.5
 */

public interface Hand {

   void addCard(Card card) throws HandleException;

   HandStrength getHandStrength();

}
