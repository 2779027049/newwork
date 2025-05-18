package citadels.character;
import citadels.game.CitadelsGame;
import citadels.player.Player;

public class Magician extends Character {
    public Magician() { super("Magician", 3); }
    @Override public void performAbility(CitadelsGame game, Player owner) {
        owner.addCard(game.drawDistrict());
        owner.addCard(game.drawDistrict());
        System.out.println(owner + " exchanges two cards");
    }
}