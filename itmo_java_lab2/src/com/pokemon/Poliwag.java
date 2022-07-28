package com.pokemon;

import com.move.DoubleSlap;
import com.move.Facade;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Poliwag extends Pokemon {

    public Poliwag() {
        super();
        init();
    }

    public Poliwag(String name, int level) {
        super(name, level);
        init();
    }

    private void init() {
        setType(Type.WATER);
        setStats(40, 50, 40, 40, 40, 90);
        setMove(new DoubleSlap(), new Facade());
    }
}
