package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public String name;
    public List<Card> hand = new ArrayList<>();
    public int score;

    public Player(String name){
        this.name = name;
    }

    public void addCard(Card card) {
        hand.add(card);
        calculateScore();
    }

    private void calculateScore() {
        score = 0;
        int aces = 0;
        
        // Считаем все карты
        for (Card card : hand) {
            String rank = card.getRank();
            if (rank.equals("A")) {
                aces++;
                score += 11; // Сначала считаем туз как 11
            } else if (rank.equals("K") || rank.equals("Q") || rank.equals("J")) {
                score += 10;
            } else {
                score += Integer.parseInt(rank);
            }
        }
        
        // Если перебор и есть тузы, переводим тузы из 11 в 1
        while (score > 21 && aces > 0) {
            score -= 10; // Туз из 11 становится 1 (разница 10)
            aces--;
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

    @Override
    public String toString() {
        return name + " has " + score + " points";
    }
}
