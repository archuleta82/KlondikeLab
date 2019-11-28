/**
 * @author Steven Archuleta
 * @date 27 November 2019
 * Lab 8 - Klondike Solitaire
 */

public class Card {
    Rank rank;
    Suit suit;
    boolean faceUp = true;

    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
        this.faceUp = true;

    }

    /**
     * This method gets the rank of the card.
     * The ranks range from Ace to King.
     * @return - The enum rank value of the card object.
     */
    public Rank getRank(){
        return rank;
    }

    /**
     * This method gets the suit of the card.
     * The possible suits are Diamonds, Hearts, Spades or Clubs.
     * @return - Suit of the card object.
     */
    public Suit getSuit(){
        return suit;
    }

    /**
     * This method determines whether or not the card is facing up.
     * @return - Boolean value true if card is face-up or false if not.
     */
    public boolean isFaceUp(){
        boolean result = false;
        if(Card.this.faceUp){
            result = true;
        }
        return result;
    }

    /**
     * This will determine whether the suit of the card is red or black.
     * Red suits are Diamonds and Hearts.
     * Black suits are Spades and Clubs.
     * @return - boolean value true if the card's suit is red, false if not.
     */
    public boolean isRed(){
        boolean result = false;
        if(getSuit().equals(Suit.HEARTS)||getSuit().equals(Suit.DIAMONDS)){
            result = true;
        }
        return result;
    }

    /**
     * Toggles the faceUp status of the card.
     * If the card is faceUp it will be flipped to be face down and vice-versa.
     * This is accomplished by modifying the boolean value.
     * boolean value of faceUp is true if it is currently face-up,
     * false if not.
     */
    public void flipOver(){
        if(isFaceUp()){
            faceUp = false;
        }else{
            faceUp = true;
        }
    }
}
