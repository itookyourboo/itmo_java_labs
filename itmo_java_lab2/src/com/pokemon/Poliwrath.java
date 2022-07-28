package com.pokemon;

import com.move.Bubble;
import com.move.DoubleSlap;
import com.move.Facade;
import com.move.Scald;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Poliwrath extends Pokemon {

    public Poliwrath() {
        super();
        init();
    }

    public Poliwrath(String name, int level) {
        super(name, level);
        init();
    }

    private void init() {
        setType(Type.WATER, Type.FIGHTING);
        setStats(90, 95, 95, 70, 90, 70);
        setMove(new DoubleSlap(), new Facade(), new Bubble(), new Scald());
    }
}
