package com.move;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class Psywave extends SpecialMove {

    public Psywave() {
        super();
        type = Type.PSYCHIC;
        accuracy = 100;
    }

    @Override
    protected void applyOppDamage(Pokemon pokemon, double v) {
        pokemon.setMod(Stat.HP,
                (int) Math.round(pokemon.getLevel() * randomCoefficient()));
    }

    private double randomCoefficient() {
        return Math.random() + .5d;
    }

    @Override
    protected String describe() {
        return "применяет Psy Wave";
    }
}
