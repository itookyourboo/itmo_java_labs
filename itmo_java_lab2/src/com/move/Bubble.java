package com.move;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class Bubble extends SpecialMove {

    public Bubble() {
        super(Type.WATER, 40, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if (Math.random() < .1d)
            pokemon.setMod(Stat.SPEED, -1);
    }

    @Override
    protected String describe() {
        return "использует Bubble";
    }
}
