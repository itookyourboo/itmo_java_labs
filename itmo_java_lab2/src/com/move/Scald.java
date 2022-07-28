package com.move;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class Scald extends SpecialMove {

    public Scald() {
        super(Type.WATER, 80, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if (Math.random() < .3d)
            Effect.burn(pokemon);
    }

    @Override
    protected String describe() {
        return "применяет Scald";
    }
}
