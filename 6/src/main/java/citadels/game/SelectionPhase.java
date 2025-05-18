package citadels.game;

import citadels.character.Character;
import citadels.card.Deck;
import citadels.player.Player;
import citadels.model.CharacterType;

import java.util.*;

public class SelectionPhase {
    private final List<Character> deck;

    public SelectionPhase(Random rng) {
        // build a Character list from all ranks, then shuffle
        deck = new ArrayList<>();
        for (CharacterType t : CharacterType.values()) {
            deck.add(t.newInstance());
        }
        Collections.shuffle(deck, rng);
    }

    public void execute(List<Player> players) {
        // discard one
        deck.remove(0);
        // deal one to each player
        for (Player p : players) {
            Character c = deck.remove(0);
            // map Character instance back to CharacterType
            CharacterType type = CharacterType.fromRank(c.getRank());
            p.setCharacter(type);
            p.setCharacterCard(c);
            System.out.println(p + " selected " + type);
        }
    }
}
