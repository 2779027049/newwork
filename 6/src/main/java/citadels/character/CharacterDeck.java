package citadels.character;

import java.util.*;
import citadels.character.Character;

public class CharacterDeck {
    private final List<Character> cards = new ArrayList<>();
    private final Random rng;

    public CharacterDeck(Random rng) {
        this.rng = rng;
        cards.add(new Assassin());
        cards.add(new Thief());
        cards.add(new Magician());
        cards.add(new King());
        cards.add(new Bishop());
        cards.add(new Merchant());
        cards.add(new Architect());
        cards.add(new Warlord());
        Collections.shuffle(cards, rng);
    }

    public void discardTop() {
        cards.remove(0);
    }

    public Character drawRandom() {
        return cards.remove(rng.nextInt(cards.size()));
    }
}
