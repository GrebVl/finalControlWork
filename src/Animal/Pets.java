package Animal;

import java.time.format.DateTimeFormatter;

public class Pets extends HumanFriends{

    public Pets(String animalName, String command, String dateBirth){
        super(animalName, command, dateBirth);
        setAnimalCategory("Домашние");
    }


}
