package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class MontyHallGame {
    private boolean[] doors;
    private int playerChoice;
    private int hostChoice;

    public MontyHallGame() {
        doors = new boolean[3];
        Random rand = new Random();

        int prizeDoor = rand.nextInt(3);
        doors[prizeDoor] = true;
    }

    public void playerSelectDoor() {
        Random rand = new Random();
        playerChoice = rand.nextInt(3);
    }

    public void hostSelectDoor() {
        hostChoice = -1;
        for (int i = 0; i < 3; i++) {
            if (i != playerChoice && !doors[i]) {
                hostChoice = i;
                break;
            }
        }
    }

    public boolean playWithoutSwitching() {
        return doors[playerChoice];
    }

    public boolean playWithSwitching() {
        for (int i = 0; i < 3; i++) {
            if (i != playerChoice && i != hostChoice) {
                playerChoice = i;
                break;
            }
        }
        return doors[playerChoice];
    }
}