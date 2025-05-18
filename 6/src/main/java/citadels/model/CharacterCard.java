
package citadels.model;

public class CharacterCard {
    private final CharacterType type;

    public CharacterCard(CharacterType type) {
        this.type = type;
    }

    public CharacterType getType() { return type; }
    @Override
    public String toString() { return type.name().charAt(0) + type.name().substring(1).toLowerCase(); }
}
