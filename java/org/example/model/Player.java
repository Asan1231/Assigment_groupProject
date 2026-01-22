package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public String name;
    public List<Card> hand = new ArrayList<>();
    public int score;;

    public Player(String name){
        this.name= name;
    }
    public void assCard(Card card){
        hand.add(card);
        calculateScore();
    }
    private void calculateScore() {
        score = 0;
        for (Card card : hand) {
            String rank = card.getRank();
            if (rank.equals("A")) {
                score += 11; // Туз - 11 очков
            } else if (rank.equals("K") || rank.equals("Q") || rank.equals("J")) {
                score += 10; // Король, дама, валет - по 10 очков
            } else {
                score += Integer.parseInt(rank); // Другие карты по номиналу
            }
        }
    }

    public int getScore() {
        return score;
    }

    public List<Card> getHand() {
        return hand;
    }
    public String getName() {
        return name;
    }
    public void addCard(Card card) {
        hand.add(card);
    }

    @Override
    public String toString() {
        return name + " has "+ score +" points";
    }
}
