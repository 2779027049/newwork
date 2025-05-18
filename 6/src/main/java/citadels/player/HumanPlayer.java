package citadels.player;

import citadels.card.Deck;
import citadels.card.DistrictCard;

import java.util.*;

public class HumanPlayer extends Player {
    private final Scanner in;

    public HumanPlayer(int id, Scanner in) {
        super(id);
        this.in = in;
    }

    @Override
    public void takeTurn(Scanner ignored, Random rng,
                         List<Player> players,
                         Deck<DistrictCard> deck) {
        // 在空 Scanner 情况下也能安全 skip
        System.out.println(this + " manual turn: draw or skip:");
        String cmd = in.hasNextLine() ? in.nextLine() : "skip";
        if ("draw".equalsIgnoreCase(cmd)) {
            addCard(deck.draw());
            System.out.println(this + " drew a card");
        } else {
            System.out.println(this + " skipped draw");
        }

        System.out.println(this + " build or skip:");
        String buildCmd = in.hasNextLine() ? in.nextLine() : "skip";
        if ("build".equalsIgnoreCase(buildCmd) && !getHand().isEmpty()) {
            build(getHand().get(0));
        } else {
            System.out.println(this + " skipped build");
        }
        System.out.println(this + " ends turn");
    }
}
