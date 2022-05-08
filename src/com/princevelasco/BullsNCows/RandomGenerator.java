package com.princevelasco.BullsNCows;

class RandomGenerator {
    private final StringBuilder secret = new StringBuilder();

    public RandomGenerator(int secretLength) {
        for (int i = 0; i < secretLength; i++) {
            int number = (int) (Math.random() * 10);

            while (contains(secret, number)) {
                number = (int) (Math.random() * 10);
            }
            secret.append(number);
        }
    }

    public String getSecret() {
        return secret.toString();
    }

    private static boolean contains(StringBuilder numbers, int number) {
        for (String j : numbers.toString().split("")) {
            if (j.equals(String.valueOf(number))) {
                return true;
            }
        }
        return false;
    }
}
