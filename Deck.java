/**
 * @author Steven Archuleta
 * @date 27 November 2019
 * Lab 8 - Klondike Solitaire
 */

// Import everything from java.util to have access to shuffle() from Collections.
import java.util.*;

public class Deck {

    // Class variable
    private static int deckTotal = 52;

    // Instance variables
    private Card[] deck;
    private static int deckCount;

    /**
     * Constructor to make a deck object. A deck object contains 52 card objects
     * in an array called deck. The number of cards in this array is controlled by
     * the deckcount.
     */
    public Deck(){
        deck = new Card[deckTotal];
        this.deckCount = 0;
    }

    /**
     * Adds a card object to the top of this deck object's internal
     * array of cards. Increments the amount of card objects in array through
     * deckcount variable.
     * @param card - Card object to be added to the deck.
     */
    public void add(Card card){
        if(this.deck[this.size()] == null){
            this.deck[this.size()] = card;
            this.deckCount++;
        }
    }

    /**
     * Adds a standard deck of cards to the deck object's internal array.
     * Standard deck does not include jokers and consists of 52 unique cards.
     */
    public void fill(){
        for (int r = 0; r <= 12; r++) {
            for (int s = 0; s <= 3; s++) {
                add(new Card(Rank.values()[r] , Suit.values()[s]));
            }
        }
    }

    /**
     * Helper method to handle possible errors with getting a null value.
     * @return - Boolean value true if the array is empty, false if not.
     */
    public boolean isEmpty(){
        boolean result = false;
        if(deck[0]==null){
            result = true;
        }
        return result;
    }

    /**
     * This method gets the card at the specified index without modifying the deck.
     * @param n - integer value for the index of desired card.
     * @return - Card object at the index n.
     */
    public Card getCardAt(int n){
        Card result = null;
        if(!isEmpty()){
            result = this.deck[n];
        }
        return result;
    }

    /**
     * Moves a card from the top of this deck to the top of the other deck.
     * @param other - Deck object to receive new card.
     */
    public void moveTo(Deck other){

        // Gain card at top index of this deck.
        Card fromDeck = this.deck[topIndex()];

        // Add card to top of the other deck.
        other.add(fromDeck);

        // Set card object move from this deck to null and update size.
        this.deck[topIndex()] = null;
        this.deckCount = this.size();
    }

    /**
     * Moves top n cards from top of this deck to the top of the other deck
     * while maintaining order.
     * @param other - other deck object to receive cards from this deck.
     * @param n - Number of cards to move from top of this deck to other deck.
     */
    public void moveTo(Deck other, int n){
        // Gain card at the top index of this deck.
        int fromDeckIndex = this.topIndex();

        // Loop and add cards from top index - n to top index
        // from this deck to other deck.
        for(int i = n-1; i >-1; i--){
            Card fromDeck = this.deck[fromDeckIndex-i];
            other.add(fromDeck);

            // Update this deck card object values to null and update size.
            this.deck[fromDeckIndex-i] = null;
            this.deckCount = this.size();
        }
    }

    /**
     * Gets the number of cards inside the deck.
     * @return - integer number of cards in this deck.
     */
    public int size(){
        int result = 0;
        for(int i = 0; i < deckTotal; i++){
            if(deck[i] != null){
                result++;
            }
        }
        return result;
    }

    /**
     * Helper method to get the index of the top card in the deck.
     * @return - integer number for index of top card in deck.
     */
    public int topIndex(){
        return size()-1 >0 ? size()-1: 0;
    }

    /**
     * Gets the top card in the deck.
     * @return - Card object at the top index of the deck.
     */
    public Card getTopCard(){
        Card result = null;
        if(!isEmpty()){
            result = deck[topIndex()];
        }
        return result;
    }

    /**
     * This method randomizes the order of the card objects in the deck.
     * Found the shuffle method @
     * https://docs.oracle.com/javase/tutorial/collections/interfaces/list.html
     */
    public void shuffle(){
        // Make intermediate deck.
        Deck intermediate = new Deck();

        // Generate a list of indices.
        // Shuffle() only works with lists.
        List<Integer> indexes = new ArrayList<Integer>();
        for(int i = 0; i < size(); i++){
            indexes.add(i);
        }
        // Shuffle the list using Collections.shuffle() method.
        Collections.shuffle(indexes);
        //Assign cards according to shuffled indices in list to intermediate deck.
        for (int ind = 0; ind < size();ind++){
            intermediate.deck[ind] = this.deck[indexes.get(ind)];
        }
        //Transfer values to deck in use.
        for(int index = 0; index < size(); index++){
            this.deck[index] = intermediate.deck[index];
        }
    }
}
