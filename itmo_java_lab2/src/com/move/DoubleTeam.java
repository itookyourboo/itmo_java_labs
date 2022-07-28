package com.move;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class DoubleTeam extends StatusMove {

    public DoubleTeam() {
        super();
        type = Type.NORMAL;
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        if (pokemon.getStat(Stat.EVASION) < 6)
            pokemon.setMod(Stat.EVASION, +1);
    }

    @Override
    protected String describe() {
        return "использует Double Team";
    }
}
