package citadels.player;

import citadels.card.Deck;
import citadels.card.DistrictCard;

import java.util.*;

public class ComputerPlayer extends Player {
    public ComputerPlayer(int id) {
        super(id);
    }

    @Override
    public void takeTurn(Scanner in, Random rng,
                         List<Player> players, Deck<DistrictCard> deck) {
        // 如果牌堆还有牌，就 draw，否则跳过
        if (!deck.isEmpty()) {
            DistrictCard c = deck.draw();
            addCard(c);
            System.out.println(this + " (CPU) drew " + c);
        } else {
            System.out.println(this + " (CPU) could not draw (deck empty)");
        }

        // 简单 AI：跳过建造
        System.out.println(this + " (CPU) skipped build");
        System.out.println(this + " (CPU) ends turn");
    }
}
