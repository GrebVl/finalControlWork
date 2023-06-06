package Animal;

import java.time.format.DateTimeFormatter;

public class PackAnimals extends HumanFriends{


    public PackAnimals(String animalName, String command, String dateBirth){
        super(animalName, command, dateBirth);
        setAnimalCategory("Вьючные");
    }
}
