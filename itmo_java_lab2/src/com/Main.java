package com;

import com.pokemon.*;
import ru.ifmo.se.pokemon.Battle;

public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();
        addAllies(b);
        addFoes(b);
        b.go();
    }

    private static void addAllies(Battle b) {
        Cryogonal cryogonal = new Cryogonal("Толян", 10);
        Inkay inkay = new Inkay("Миха", 15);
        Malamar malamar = new Malamar("Радик", 20);
        b.addAlly(cryogonal);
        b.addAlly(inkay);
        b.addAlly(malamar);
    }

    private static void addFoes(Battle b) {
        Poliwag poliwag = new Poliwag("Диман", 30);
        Poliwhirl poliwhirl = new Poliwhirl("Саня", 5);
        Poliwrath poliwrath = new Poliwrath("Володя", 10);
        b.addFoe(poliwag);
        b.addFoe(poliwhirl);
        b.addFoe(poliwrath);
    }
}
