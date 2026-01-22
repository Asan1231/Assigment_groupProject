package org.example.model;

public class Card {
    public String rank;
    public String suit;

    public Card(String rank,String suit){
        this.rank = rank;
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of" + suit;
    }
}
