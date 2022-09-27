package academy.learnprogramming.list.interfaces.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Monsters implements ISaveable{

    private String name;
    private String weapon;
    private int health;

    public Monsters(String name, String weapon){
        this.name = name;
        this.weapon = weapon;
        this.health = 100;
    }


    public String getName() {
        return name;
    }

    public String getWeapon() {
        return weapon;
    }

    public int getHealth() {
        return health;
    }


    @Override
    public List<String> saveValues() {
        List<String> savedValues = new ArrayList<>();

        if ( !name.equals("") || !weapon.equals("") || health < 0){
            savedValues.add(name);
            savedValues.add(weapon);
            savedValues.add(String.valueOf(health));
        }
        return savedValues;
    }

    @Override
    public void readValues(List<String> arrayList) {

    }

    @Override
    public String toString() {
        return "Monsters{" +
                "name='" + name + '\'' +
                ", weapon='" + weapon + '\'' +
                ", health=" + health +
                '}';
    }
}
