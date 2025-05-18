package citadels.character;

import citadels.game.CitadelsGame;
import citadels.model.CharacterType;
import citadels.player.Player;

/**
 * 抽象父类：所有角色卡的共同数据
 */
public abstract class Character {
    private final String name;
    private final int    rank;
    private final CharacterType type;

    /**
     * 通过 rank 推断 model.CharacterType
     */
    protected Character(String name, int rank) {
        this(name, rank, CharacterType.fromRank(rank));
    }

    /**
     * 可直接指定 model.CharacterType
     */
    protected Character(String name, int rank, CharacterType type) {
        this.name = name;
        this.rank = rank;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    /**
     * 返回对应的 model.CharacterType，
     * 供 SelectionPhase 和 CitadelsGameTest 调用
     */
    public CharacterType getType() {
        return type;
    }

    /**
     * 标准抽牌阶段是否要跳过？默认 false。
     * Architect 可重写为 true。
     */
    public boolean skipStandardDraw() {
        return false;
    }

    /**
     * 每张角色牌在自己回合最先执行的特殊能力
     */
    public abstract void performAbility(CitadelsGame game, Player owner);
}
