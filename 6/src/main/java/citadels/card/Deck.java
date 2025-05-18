package citadels.card;

import java.util.*;

public class Deck<T> {
    private final List<T> cards = new ArrayList<>();

    public void add(T c)            { cards.add(c); }
    public void shuffle(Random rng) { Collections.shuffle(cards, rng); }
    public T    draw()              { return cards.remove(0); }
    public boolean isEmpty()        { return cards.isEmpty(); }
    public int     size()           { return cards.size(); }
}
