package citadels.model;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Stream;
import citadels.character.*;

/**
 * 按 rank 枚举所有角色，并能 newInstance()
 */
public enum CharacterType {
    ASSASSIN (1,  Assassin::new),
    THIEF    (2,  Thief::new),
    MAGICIAN (3,  Magician::new),
    KING     (4,  King::new),
    BISHOP   (5,  Bishop::new),
    MERCHANT (6,  Merchant::new),
    ARCHITECT(7,  Architect::new),
    WARLORD  (8,  Warlord::new);

    private final int rank;
    private final Supplier<citadels.character.Character> ctor;
    private static final Map<Integer,CharacterType> BY_RANK = new HashMap<>();
    static {
        for (CharacterType t : values()) BY_RANK.put(t.rank, t);
    }

    CharacterType(int rank, Supplier<citadels.character.Character> ctor) {
        this.rank = rank;
        this.ctor = ctor;
    }

    public int getRank() { return rank; }
    public citadels.character.Character newInstance() { return ctor.get(); }
    public static CharacterType fromRank(int r) { return BY_RANK.get(r); }

    /** 方便轮询所有 rank 顺序 */
    public static Stream<CharacterType> streamAllRanks() {
        return Stream.of(values()).sorted((a,b) -> Integer.compare(a.rank,b.rank));
    }
}
