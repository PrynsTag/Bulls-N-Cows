package com.princevelasco.BullsNCows;

import java.util.Random;

class RandomGenerator {
    private final StringBuilder secret = new StringBuilder();
    private final Random random = new Random();
    private final int secretLength;
    private final int symbolsCount;

    protected RandomGenerator(int secretLength, int symbolsCount) {
        this.random.setSeed(System.currentTimeMillis());
        this.secretLength = secretLength;
        this.symbolsCount = symbolsCount;
    }

    protected void generate() {
        String symbolRange =
                symbolsCount <= 10 ? String.format("(0-%d)", 10 - 1) :
                        String.format("(0-9, a-%c)", (char) (this.symbolsCount + 86));
        System.out.printf("The secret is prepared: %s %s.\n", "*".repeat(this.secretLength), symbolRange);

        for (int i = 0; i < secretLength; i++) {
            int randNumber = this.random.nextInt(symbolsCount);
            String numOrChar = randNumber < 10 ? String.valueOf(randNumber) : String.valueOf((char) (randNumber + 87));

            while (secret.toString().contains(numOrChar)) {
                randNumber = this.random.nextInt(symbolsCount);
                numOrChar = randNumber < 10 ? String.valueOf(randNumber) : String.valueOf((char) (randNumber + 87));
            }

            secret.append(numOrChar);
        }
    }

    public String getSecret() {
        return secret.toString();
    }

    public int getSecretLength() {
        return secretLength;
    }

    public int getSymbolsCount() {
        return symbolsCount;
    }
}
