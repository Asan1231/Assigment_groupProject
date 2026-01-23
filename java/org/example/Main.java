package org.example;

import org.example.model.Card;
import org.example.model.Player;
import org.example.service.Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = sc.nextLine().trim();
        if(name.isEmpty()) name = "Player";

        Game game = new Game(name);
        game.dealInitialCards();

        Player player = game.getPlayer();
        Player dealer = game.getDealer();

        System.out.println();
        System.out.println("=== BLACKJACK ===");
        System.out.println("Player: " + player.getName());
        System.out.println();

        // Игровой цикл для игрока
        boolean playing = true;
        while (playing) {
            System.out.println("Your cards:");
            printHand(player);
            System.out.println("Your score: " + player.getScore());
            System.out.println();

            System.out.println("Dealer's visible card:");
            System.out.println("- " + dealer.getHand().get(0).getRank() +
                    " of " + dealer.getHand().get(0).getSuit());
            System.out.println();

            if (player.getScore() > 21) {
                System.out.println("BUST! You went over 21!");
                break;
            }

            System.out.println("Hit or Stand? (h/s): ");
            String choice = sc.nextLine().trim().toLowerCase();

            if (choice.equals("h")) {
                game.playerHit();
            } else {
                playing = false;
            }
        }

        // Ход дилера
        if (player.getScore() <= 21) {
            System.out.println();
            System.out.println("Dealer's turn...");
            System.out.println("Dealer cards:");
            printHand(dealer);
            System.out.println("Dealer score: " + dealer.getScore());

            while (dealer.getScore() < 17) {
                System.out.println("Dealer hits...");
                game.dealerHit();
                printHand(dealer);
                System.out.println("Dealer score: " + dealer.getScore());
            }
        }

        System.out.println();
        System.out.println("=== FINAL SCORES ===");
        System.out.println(player);
        System.out.println(dealer);
        System.out.println();
        game.checkWinner();

        sc.close();
    }

    private static void printHand(Player p) {
        for (int i = 0; i < p.getHand().size(); i++) {
            Card c = p.getHand().get(i);
            System.out.println("- " + c.getRank() + " of " + c.getSuit());
        }
    }
}
