import org.example.MontyHallGame;

import java.util.HashMap;
import java.util.Map;

public class MontyHallTest {
    public static void main(String[] args) {
        int totalGames = 1000;

        Map<String, Integer> results = new HashMap<>();
        results.put("winWithoutSwitching", 0);
        results.put("loseWithoutSwitching", 0);
        results.put("winWithSwitching", 0);
        results.put("loseWithSwitching", 0);

        for (int i = 0; i < totalGames; i++) {
            MontyHallGame game = new MontyHallGame();
            game.playerSelectDoor();
            game.hostSelectDoor();

            if (game.playWithoutSwitching()) {
                results.put("winWithoutSwitching", results.get("winWithoutSwitching") + 1);
            } else {
                results.put("loseWithoutSwitching", results.get("loseWithoutSwitching") + 1);
            }

            if (game.playWithSwitching()) {
                results.put("winWithSwitching", results.get("winWithSwitching") + 1);
            } else {
                results.put("loseWithSwitching", results.get("loseWithSwitching") + 1);
            }
        }

        System.out.println("Статистика по игре Монти Холла (1000 игр):");
        System.out.println("Побед без смены: " + results.get("winWithoutSwitching"));
        System.out.println("Поражений без смены: " + results.get("loseWithoutSwitching"));
        System.out.println("Побед с сменой: " + results.get("winWithSwitching"));
        System.out.println("Поражений с сменой: " + results.get("loseWithSwitching"));
    }
}