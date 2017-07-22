package com.example.beavi5.iceandfire;

/**
 * Created by beavi5 on 22.07.2017.
 */

public class Character {
    String name;

String gender;
   String        culture;
   String[]        aliases;

    public String[] getAliases() {
        return aliases;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getCulture() {
        return culture;
    }

    public Character(String name, String gender, String culture, String[] aliases) {

        this.name = name;
        this.aliases = aliases;
        this.gender = gender;
        this.culture = culture;
    }
}
