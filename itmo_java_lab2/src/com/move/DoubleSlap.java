package com.move;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class DoubleSlap extends PhysicalMove {

    public DoubleSlap() {
        super(Type.NORMAL, 15, 85);
    }

    @Override
    protected void applyOppDamage(Pokemon pokemon, double v) {
        int hits = 1;
        double random = Math.random();
        if (random < .375d) hits = 2;
        else if (random < .75d) hits = 3;
        else if (random < .875d) hits = 4;
        else hits = 5;

        super.applyOppDamage(pokemon, v * hits);
    }

    @Override
    protected String describe() {
        return "применяет Double Slap";
    }
}
