package com.princevelasco.BullsNCows;

import java.util.Scanner;

public class Game {
    private final StringBuilder secret = new StringBuilder();

    public Game() {
        for (int i = 0; i < 4; i++) {
            this.secret.append((int) (Math.random() * 10));
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String guess = scanner.nextLine();

        Grader.check(this.secret.toString(), guess);
    }
}
