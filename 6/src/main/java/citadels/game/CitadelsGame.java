package citadels.game;

import citadels.card.Deck;
import citadels.card.DistrictCard;
import citadels.player.Player;

import java.util.*;

public class CitadelsGame {
    private final List<Player> players;
    private final Deck<DistrictCard> districtDeck = new Deck<>();
    private final Random rng;

    // assassination, theft, bishop immunity, crown holder
    private int killedRank = -1, stolenRank = -1;
    private Player bishopImmune = null, crownHolder = null;

    public CitadelsGame(List<Player> players) {
        this(players, new Random());
    }

    public CitadelsGame(List<Player> players, Random rng) {
        this.players = players;
        this.rng = rng;
        initDistrictDeck();
    }

    private void initDistrictDeck() {
        districtDeck.add(new DistrictCard("Docks",      3));
        districtDeck.add(new DistrictCard("Market",     2));
        districtDeck.add(new DistrictCard("Castle",     4));
        districtDeck.add(new DistrictCard("Monastery",  3));
        districtDeck.add(new DistrictCard("Watchtower", 1));
        districtDeck.shuffle(rng);
    }

    public DistrictCard drawDistrict()     { return districtDeck.draw(); }
    public void setKilledRank(int r)       { killedRank = r; }
    public int  getKilledRank()            { return killedRank; }
    public void setStolenRank(int r)       { stolenRank = r; }
    public int  getStolenRank()            { return stolenRank; }
    public void setBishopImmune(Player p)  { bishopImmune = p; }
    public Player getBishopImmune()        { return bishopImmune; }
    public void setCrown(Player p)         { crownHolder = p; }
    public Player getCrownHolder()         { return crownHolder; }
    public List<Player> getPlayers()       { return players; }

    public void play(int rounds, Scanner console) {
        for (int r = 1; r <= rounds; r++) {
            System.out.println("=== Round " + r + " ===");
            for (Player p : players) {
                if (p.getId() == killedRank) {
                    System.out.println(p + " was assassinated");
                    continue;
                }
                p.takeTurn(console, rng, players, districtDeck);
            }
            killedRank = stolenRank = -1;
            bishopImmune = null;
        }
    }

    public void play(int rounds) {
        play(rounds, new Scanner(""));
    }
}
