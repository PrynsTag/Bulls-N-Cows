package com.princevelasco.BullsNCows;

import java.util.Scanner;

class Game {
    private final Scanner scanner = new Scanner(System.in);

    protected void start() {
        int[] inputs = getInputs();

        int secretLength = inputs[0];
        int symbolsCount = inputs[1];

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

    private int[] getInputs() {
        System.out.println("Input the length of the secret code:");
        String strSecretLength = scanner.nextLine();
        int secretLength = 0;
        try {
            secretLength = Integer.parseInt(strSecretLength);
        } catch (NumberFormatException e) {
            System.out.printf("Error: \"%s\" isn't a valid number.\n", strSecretLength);
            System.exit(0);
        }

        System.out.println("Input the number of possible symbols in the code:");
        String strCountSymbols = scanner.nextLine();
        int symbolsCount = 0;
        try {
            symbolsCount = Integer.parseInt(strCountSymbols);
        } catch (NumberFormatException e) {
            System.out.printf("Error: \"%s\" isn't a valid number.\n", strCountSymbols);
            System.exit(0);
        }

        if (secretLength > 10) {
            System.out.println("Error: " +
                    "can't generate a secret number " +
                    "with a length of 11 because there " +
                    "aren't enough unique digits."
            );
            System.exit(0);
        } else if (secretLength <= 0) {
            System.out.println("Error: " +
                    "can't generate a secret number " +
                    "with a negative number of symbols."
            );
            System.exit(0);
        }

        if (symbolsCount > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            System.exit(0);
        }

        if (secretLength > symbolsCount) {
            System.out.printf("Error: " +
                            "it's not possible to generate a code " +
                            "with a length of %d with %d unique symbols."
                    , secretLength, symbolsCount
            );
            System.exit(0);
        }

        return new int[]{secretLength, symbolsCount};
    }
}
