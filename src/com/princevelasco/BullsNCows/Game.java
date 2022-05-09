package com.princevelasco.BullsNCows;

import java.util.Scanner;

class Game {
    protected void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the length of the secret code:");
        int secretLength = Integer.parseInt(scanner.nextLine());

        System.out.println("Input the number of possible symbols in the code:");
        int symbolsCount = Integer.parseInt(scanner.nextLine());

        if (secretLength > 10) {
            System.out.println("Error: " +
                    "can't generate a secret number " +
                    "with a length of 11 because there " +
                    "aren't enough unique digits."
            );
            return;
        }

        RandomGenerator randomGenerator = new RandomGenerator(secretLength, symbolsCount);
        randomGenerator.generate();

        System.out.println("Okay, let's start a game!");
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
