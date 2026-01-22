package org.example;

import org.example.model.Card;
import org.example.model.Player;
import org.example.service.Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name =sc.nextLine().trim();
        if(name.isEmpty()) name="player";

        Game game = new Game(name);
        game.dealInitialCards();

        Player player = game.getPlayer();
        Player dealer = game.getDealer();

        System.out.println();
        System.out.println("=== BLACKJACK ===");
        System.out.println("Player: " + player.getName());
        System.out.println();

        System.out.println("Your cards:");
        printHand(player);

        System.out.println();
        System.out.println("Dealer cards:");
        printHand(dealer);

        System.out.println();
        System.out.println("OK. Next step: we will add points + menu (hit/stand).");
    }
    private static void printHand(Player p) {
        for (int i = 0; i < p.getHand().size(); i++) {
            Card c = p.getHand().get(i);
            System.out.println("- " + c.getRank() + " of " + c.getSuit());
        }
    }
}
