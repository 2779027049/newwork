package citadels;

import citadels.player.Player;
import citadels.player.HumanPlayer;
import citadels.player.ComputerPlayer;
import citadels.game.CitadelsGame;
import citadels.game.SelectionPhase;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter # human players:");
        int h = Integer.parseInt(console.nextLine());
        System.out.println("Enter # computer players:");
        int c = Integer.parseInt(console.nextLine());

        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= h; i++) players.add(new HumanPlayer(i, console));
        for (int j = 1; j <= c; j++) players.add(new ComputerPlayer(h + j));

        // **1) Create a single Random and pass it to both SelectionPhase and CitadelsGame**
        Random rng = new Random();

        // 2) Do the role-selection phase before starting play()
        SelectionPhase sel = new SelectionPhase(rng);
        sel.execute(players);

        // 3) Construct game with same rng, then start playing
        CitadelsGame game = new CitadelsGame(players, rng);
        game.play(3, console);
    }
}
