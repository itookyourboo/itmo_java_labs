package com.move;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Slash extends PhysicalMove {

    public Slash() {
        super(Type.NORMAL, 70, 100);
    }

    @Override
    protected double calcCriticalHit(Pokemon pokemon, Pokemon pokemon1) {
        if (Math.random() < 1d / 8)
            return 2;
        return 1;
    }

    @Override
    protected String describe() {
        return "использует Slash";
    }
}
