package citadels.character;

import citadels.game.CitadelsGame;
import citadels.player.Player;
import citadels.card.DistrictCard;      // ← 新增这一行
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Warlord: can destroy the cheapest district of another player.
 */
public class Warlord extends Character {
    public Warlord() { super("Warlord", 8); }

    @Override
    public void performAbility(CitadelsGame game, Player owner) {
        Player target = game.getPlayers().stream()
            .filter(p -> p != owner && !p.getCity().isEmpty())
            .min(Comparator.comparingInt(p ->
                p.getCity().stream()
                 .mapToInt(DistrictCard::getCost)
                 .sum()))
            .orElse(null);

        if (target != null) {
            DistrictCard cheapest = target.getCity().stream()
                .min(Comparator.comparingInt(DistrictCard::getCost))
                .get();
            target.getCity().remove(cheapest);
            System.out.println(owner
                + " destroys " + target
                + "'s " + cheapest);
        }
    }
}
