package academy.learnprogramming.list.interfaces.challenge;

import java.util.ArrayList;
import java.util.List;

public class Players implements ISaveable{

    private String name;
    private String weapon;
    private int health;

    public Players(String name, String weapon) {
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

    /* insert the value, the values of all the members that are needed to save the state of our player*/
    @Override
    public List<String> saveValues() {
        List<String> savedValues = new ArrayList<>();

        if ( !name.equals("") || !weapon.equals("") || health < 0){
            savedValues.add(0,this.name);
            savedValues.add(1, this.weapon);
            savedValues.add(2, String.valueOf(this.health));
        }
        return savedValues;
    }

    @Override
    public void readValues(List<String> savedValues) {
        // validation
        if (savedValues != null && !savedValues.isEmpty()) {
            for (int i = 0; i < savedValues.size(); i++) {
                this.name = savedValues.get(0);
                this.weapon = savedValues.get(1);
                this.health = Integer.parseInt(savedValues.get(2));
            }
        }
    }

    @Override
    public String toString() {
        return "Players{" +
                "name='" + name + '\'' +
                ", weapon='" + weapon + '\'' +
                ", health=" + health +
                '}';
    }
}
