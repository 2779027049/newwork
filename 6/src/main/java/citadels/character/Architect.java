package citadels.character;

import citadels.game.CitadelsGame;
import citadels.player.Player;

public class Architect extends Character {
    public Architect() {
        super("ARCHITECT", 7);
    }

    @Override
    public boolean skipStandardDraw() {
        return true;  // Architect 跳过默认的抽一张/选一张逻辑
    }

    @Override
    public void performAbility(CitadelsGame game, Player owner) {
        // Architect 的额外抽两张选一张 或者 建两座的逻辑
    }
}
