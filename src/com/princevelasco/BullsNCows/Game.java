package com.princevelasco.BullsNCows;

import java.util.Scanner;

public class Game {
    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, enter the secret code's length:");
        int secretLength = Integer.parseInt(scanner.nextLine());

        if (secretLength > 10) {
            System.out.println("Error: " +
                    "can't generate a secret number " +
                    "with a length of 11 because there " +
                    "aren't enough unique digits."
            );
            return;
        }

        System.out.println("Okay, let's start a game!");

        RandomGenerator randomGenerator = new RandomGenerator(secretLength);
        boolean isGameOver;
        int numTurns = 1;

        do {
            System.out.println("Turn " + numTurns);
            String guess = scanner.nextLine();

            isGameOver = Grader.check(randomGenerator.getSecret(), guess);
            numTurns++;
        } while (isGameOver);

    }
}
