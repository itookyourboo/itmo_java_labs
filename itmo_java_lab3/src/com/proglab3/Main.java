package com.proglab3;

import com.proglab3.entity.Baby;
import com.proglab3.entity.Carlson;
import com.proglab3.entity.Entity;
import com.proglab3.misc.Lessons;
import com.proglab3.place.Roof;
import com.proglab3.place.Room;
import com.proglab3.place.School;

public class Main {

    public static void main(String[] args) {
        runIncredibleStory();
    }

    private static void runIncredibleStory() {
        Baby baby = new Baby();
        Roof roof = new Roof(baby);

        Carlson carlson = new Carlson();
        carlson.setBaby(baby);
        carlson.setOnPlaceChangedListener(baby);
        carlson.setPlace(roof);

        // Улетает
        carlson.setPlace(null);

        Room room = new Room(baby);
        baby.run(room);

        if (!room.getWindow().isOpened())
            baby.openWindowInRoom(room);

        Entity babyThinksAbout = baby.thinksAbout();
        if (babyThinksAbout == null)
            System.out.printf("%s ни о чем не думал\n", baby.toString());
        else
            System.out.printf("%s думал о %s\n", baby.toString(), babyThinksAbout.toString());

        Entity babyCriesAbout = baby.criesAbout();
        if (babyCriesAbout == null)
            System.out.printf("%s не плакал\n", baby.toString());
        else
            System.out.printf("%s плакал из-за %s\n", baby.toString(), babyCriesAbout.toString());

        School school = new School();
        Lessons lessons = new Lessons();

        school.printInstance();
        lessons.printInstance();
        carlson.printInstance();
    }
}
