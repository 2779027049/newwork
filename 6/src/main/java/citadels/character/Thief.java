package citadels.character;
import citadels.game.CitadelsGame;
import citadels.player.Player;
import java.util.Random;

public class Thief extends Character {
    public Thief() { super("Thief", 2); }
    @Override public void performAbility(CitadelsGame game, Player owner) {
        int target = new Random().nextInt(8) + 1;
        game.setStolenRank(target);
        System.out.println(owner + " will steal from rank " + target);
    }
}