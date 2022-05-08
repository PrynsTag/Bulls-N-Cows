package com.princevelasco.BullsNCows;

public class Grader {
    static void check(String secret, String guess) {
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

        String gradeBulls = bulls > 0 ? String.format("%d bull(s)", bulls) : "";
        String gradeCows = cows > 0 ? String.format("%d cow(s)", cows) : "";

        if (gradeBulls.isEmpty() && gradeCows.isEmpty()) {
            System.out.printf("Grade: None. The secret code is %s.", secret);
        } else if (gradeBulls.isEmpty()) {
            System.out.printf("Grade: %s. The secret code is %s.", gradeCows, secret);
        } else if (gradeCows.isEmpty()) {
            System.out.printf("Grade: %s. The secret code is %s.", gradeBulls, secret);
        } else {
            System.out.printf("Grade: %s and %s. The secret code is %s.", gradeBulls, gradeCows, secret);
        }
    }
}
