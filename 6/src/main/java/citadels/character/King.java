package citadels.character;
import citadels.game.CitadelsGame;
import citadels.player.Player;

public class King extends Character {
    public King() { super("King", 4); }
    @Override public void performAbility(CitadelsGame game, Player owner) {
        game.setCrown(owner);
        System.out.println(owner + " now holds the crown");
    }
}