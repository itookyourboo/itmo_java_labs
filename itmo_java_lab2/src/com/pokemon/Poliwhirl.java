package com.pokemon;

import com.move.Bubble;
import com.move.DoubleSlap;
import com.move.Facade;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Poliwhirl extends Pokemon {

    public Poliwhirl() {
        super();
        init();
    }

    public Poliwhirl(String name, int level) {
        super(name, level);
        init();
    }

    private void init() {
        setType(Type.WATER);
        setStats(65, 65, 65, 50, 50, 90);
        setMove(new DoubleSlap(), new Facade(), new Bubble());
    }
}
