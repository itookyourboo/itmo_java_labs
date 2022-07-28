package com.pokemon;

import com.move.BrutalSwing;
import com.move.Confide;
import com.move.Psywave;
import com.move.Slash;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Malamar extends Pokemon {

    public Malamar() {
        super();
        init();
    }

    public Malamar(String name, int level) {
        super(name, level);
        init();
    }

    private void init() {
        setType(Type.DARK, Type.PSYCHIC);
        setStats(86, 92, 88, 68, 75, 73);
        setMove(new Confide(), new Slash(), new Psywave(), new BrutalSwing());
    }
}
