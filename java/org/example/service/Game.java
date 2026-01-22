package org.example.service;

import org.example.model.Card;
import org.example.model.Player;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Game {
    public List<Card> deck= new ArrayList<>();
    public Player player;
    public Player dealer;

    public Game(String playerName){
        player = new Player(playerName);
        dealer = new Player("Dealer");
        createDeck();
        shuffleDeck();
    }
    private void createDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(rank, suit));
            }
        }
    }
    private void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public void dealInitialCards() {
        player.addCard(deck.remove(0));
        dealer.addCard(deck.remove(0));
        player.addCard(deck.remove(0));
        dealer.addCard(deck.remove(0));
    }

    public void playerHit() {
        player.addCard(deck.remove(0));
    }

    public void dealerHit() {
        dealer.addCard(deck.remove(0));
    }
    public void displayScores() {
        System.out.println(player);
        System.out.println(dealer);
    }
    public void checkWinner() {
        int playerScore = player.getScore();
        int dealerScore = dealer.getScore();

        if (dealerScore > 21) {
            System.out.println("Dealer busts! You win!");
        } else if (playerScore > 21) {
            System.out.println("You bust! You lose!");
        } else if (dealerScore > playerScore) {
            System.out.println("You lose");
        } else if (dealerScore < playerScore) {
            System.out.println("You win!");
        } else {
            System.out.println("Push (draw)");
        }
    }

    public Player getPlayer() {
        return player;
    }

    public Player getDealer() {
        return dealer;
    }
}
