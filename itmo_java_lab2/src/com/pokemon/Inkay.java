package com.pokemon;

import com.move.Confide;
import com.move.Psywave;
import com.move.Slash;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Inkay extends Pokemon {

    public Inkay() {
        super();
        init();
    }

    public Inkay(String name, int level) {
        super(name, level);
        init();
    }

    private void init() {
        setType(Type.DARK, Type.PSYCHIC);
        setStats(53, 54, 53, 37, 46, 45);
        setMove(new Confide(), new Slash(), new Psywave());
    }
}
