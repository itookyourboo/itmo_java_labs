package com.pokemon;

import com.move.Blizzard;
import com.move.DoubleTeam;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Cryogonal extends Pokemon {

    public Cryogonal() {
        super();
        init();
    }

    public Cryogonal(String name, int level) {
        super(name, level);
        init();
    }

    private void init() {
        setType(Type.ICE);
        setStats(80, 50, 50, 95, 135, 105);
        setMove(new Blizzard(), new DoubleTeam());
    }
}
