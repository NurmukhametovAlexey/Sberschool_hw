package ru.sbrf.lesson5.hw5;

import java.util.*;

public class Balda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the initial word: ");
        String generatingWord = sc.nextLine().toLowerCase();
        Set<Character> availableLetters = new HashSet<Character>();

        for (Character c : generatingWord.toCharArray())
            availableLetters.add(c);

        List<Set<String>> usersWords = List.of(new LinkedHashSet<>(), new LinkedHashSet<>());
        boolean[] playersActive = {true, true};
        int playersTurn = 0;
        String tmpWord = "";

        while (playersActive[0] || playersActive[1])
        {
            System.out.println("Player " + (playersTurn+1) + " turn: ");

            tmpWord = sc.nextLine();
            if (tmpWord.isEmpty()) {
                playersActive[playersTurn] = false;
                playersTurn = (playersTurn + 1) % 2;
                continue;
            }

            boolean writeFlag = true;
            for (char sym : tmpWord.toLowerCase().toCharArray())
                if (!availableLetters.contains(sym)) {
                    System.err.println("You used unavailable letter(s)! Try again");
                    writeFlag = false;
                    break;
                }
            if (!writeFlag)
                continue;

            if(usersWords.get(0).contains(tmpWord) || usersWords.get(1).contains(tmpWord)) {
                System.err.println("This word already exists! Try again");
                continue;
            }
            usersWords.get(playersTurn).add(tmpWord);
            playersTurn = (playersTurn + (playersActive[0] && playersActive[1] ? 1 : 0)) % 2;
        }

        for (int player = 0; player < usersWords.size(); player++) {
            System.out.println("\nPlayer #" + (player+1) + " result: " + usersWords.get(player).size());
            System.out.println("Printing words:");
            for (String word : usersWords.get(player))
                System.out.println(word);
        }
        if (usersWords.get(0).size() > usersWords.get(1).size())
            System.out.println("\nPlayer 1 wins!");
        else if (usersWords.get(0).size() < usersWords.get(1).size())
            System.out.println("\nPlayer 2 wins!");
        else
            System.out.println("\nIt`s a draw!");
    }
}
