package com.princevelasco.BullsNCows;

import java.util.Arrays;
import java.util.stream.Collectors;

class Grader {
    protected static boolean check(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        String guessNoDuplicate = Arrays.stream(guess.split(""))
                .distinct()
                .collect(Collectors.joining());
        for (int i = 0; i < secret.length(); i++) {
            for (int j = 0; j < guessNoDuplicate.length(); j++) {
                if (secret.charAt(i) == guessNoDuplicate.charAt(j)) {
                    bulls++;
                } else if (secret.contains(String.valueOf(guessNoDuplicate.charAt(j)))) {
                    cows++;
                }
            }
        }

        String gradeBulls = bulls > 0 ? String.format("%d bull", bulls) : "";
        String gradeCows = cows > 0 ? String.format("%d cow", cows) : "";

        String isPluralBull = bulls > 1 ? gradeBulls + "s" : gradeBulls;
        String isPluralCow = cows > 1 ? gradeCows + "s" : gradeCows;

        if (bulls == secret.length()) {
            System.out.println("Grade: " + isPluralBull);
            System.out.println("Congratulations! You guessed the secret code.");
            return false;
        } else if (gradeBulls.isEmpty() && gradeCows.isEmpty()) {
            System.out.println("Grade: None");
            return true;
        } else if (gradeBulls.isEmpty()) {
            System.out.printf("Grade: %s\n", isPluralCow);
            return true;
        } else if (gradeCows.isEmpty()) {
            System.out.printf("Grade: %s\n", isPluralBull);
            return true;
        } else {
            System.out.printf("Grade: %s and %s\n", isPluralBull, isPluralCow);
            return true;
        }
    }
}
