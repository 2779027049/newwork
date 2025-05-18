package citadels.player;

import citadels.card.DistrictCard;
import citadels.card.Deck;

import java.util.*;

public abstract class Player {
    protected final int id;
    protected int gold = 2;
    protected final List<DistrictCard> hand = new ArrayList<>();
    protected final List<DistrictCard> city = new ArrayList<>();

    // character-related
    private citadels.model.CharacterType characterType;
    private citadels.character.Character characterCard;

    public Player(int id) {
        this.id = id;
    }

    public int getId() { return id; }
    public int getGold() { return gold; }
    public List<DistrictCard> getHand() { return hand; }
    public List<DistrictCard> getCity() { return city; }

    public void addGold(int x) { gold += x; }
    public void addCard(DistrictCard c) { if (c != null) hand.add(c); }

    /** Build a district card */
    public void build(DistrictCard c) {
        if (c != null && hand.contains(c) && gold >= c.getCost()) {
            hand.remove(c);
            city.add(c);
            gold -= c.getCost();
            System.out.println(this + " built " + c);
        } else {
            System.out.println(this + " failed to build " + c);
        }
    }

    /** SelectionPhase assigns this player's type */
    public void setCharacter(citadels.model.CharacterType type) {
        this.characterType = type;
    }
    /** SelectionPhase assigns this player's character card instance */
    public void setCharacterCard(citadels.character.Character card) {
        this.characterCard = card;
    }

    public citadels.model.CharacterType getCharacterType() {
        return characterType;
    }
    public citadels.character.Character getCharacterCard() {
        return characterCard;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + id;
    }

    /**
     * All interaction for one turn, implemented by subclasses.
     * @param in      Scanner, for human input
     * @param rng     Random
     * @param players All players
     * @param deck    District-card deck
     */
    public abstract void takeTurn(Scanner in, Random rng,
                                  List<Player> players,
                                  Deck<DistrictCard> deck);
}
