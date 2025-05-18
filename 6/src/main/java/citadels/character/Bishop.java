package citadels.character;
import citadels.game.CitadelsGame;
import citadels.player.Player;

public class Bishop extends Character {
    public Bishop() { super("Bishop", 5); }
    @Override public void performAbility(CitadelsGame game, Player owner) {
        game.setBishopImmune(owner);
        System.out.println(owner + " is immune this round");
    }
}