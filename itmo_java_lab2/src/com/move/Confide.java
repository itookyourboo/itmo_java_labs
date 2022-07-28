package com.move;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class Confide extends StatusMove {

    public Confide() {
        super();
        type = Type.NORMAL;
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if (pokemon.getStat(Stat.SPECIAL_ATTACK) > -6)
            pokemon.setMod(Stat.SPECIAL_ATTACK, -1);
    }

    @Override
    protected String describe() {
        return "использует Confide";
    }
}
