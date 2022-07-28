package com.move;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class NightSlash extends PhysicalMove {
    public NightSlash() {
        super(Type.DARK, 70, 100);
    }

    @Override
    protected double calcCriticalHit(Pokemon pokemon, Pokemon pokemon1) {
        if (Math.random() < .125f)
            return 2;
        return 1;
    }

    @Override
    protected String describe() {
        return "использует Night Slash";
    }
}
