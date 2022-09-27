package academy.learnprogramming.list.interfaces.challenge;

import java.util.ArrayList;
import java.util.List;

public interface ISaveable {

    // allows an object to be saved to some sort of storage medium.
    public List<String> saveValues();
    //populate the object's fields from an ArrayList
    // add method to append a value to the ArrayList
    public void readValues(List<String> savedValues);

}
