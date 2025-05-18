package citadels.character;
import citadels.game.CitadelsGame;
import citadels.player.Player;

public class Merchant extends Character {
    public Merchant() { super("Merchant", 6); }
    @Override public void performAbility(CitadelsGame game, Player owner) {
        owner.addGold(1);
        System.out.println(owner + " gains 1 extra gold");
    }
}