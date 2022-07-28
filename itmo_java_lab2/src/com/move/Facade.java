package com.move;

import ru.ifmo.se.pokemon.*;

public class Facade extends PhysicalMove {

    public Facade() {
        super(Type.NORMAL, 70, 100);
    }

    @Override
    protected void applyOppDamage(Pokemon pokemon, double v) {
        super.applyOppDamage(pokemon, v);
        Status s = pokemon.getCondition();
        if (s == Status.BURN || s == Status.PARALYZE || s == Status.POISON)
            pokemon.setMod(Stat.HP, (int) Math.round(v * 2));
    }

    @Override
    protected String describe() {
        return "применяет Facade";
    }
}
