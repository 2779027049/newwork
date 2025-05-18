package citadels.character;
import citadels.game.CitadelsGame;
import citadels.player.Player;
import java.util.Random;

public class Assassin extends Character {
    public Assassin() { super("Assassin", 1); }
    @Override public void performAbility(CitadelsGame game, Player owner) {
        int target = new Random().nextInt(8) + 1;
        game.setKilledRank(target);
        System.out.println(owner + " will assassinate rank " + target);
    }
}