package com.princevelasco.BullsNCows;

public class Grader {
    static boolean check(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            for (int j = 0; j < guess.length(); j++) {
                if (guess.charAt(i) == secret.charAt(j)) {
                    if (i == j) {
                        bulls++;
                    } else {
                        cows++;
                    }
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
