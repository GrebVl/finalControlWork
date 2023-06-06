package Animal;

import java.time.format.DateTimeFormatter;

public class Cats extends Pets{

    public Cats(String animalName, String command, String dateBirth) {
        super(animalName, command, dateBirth);
        setGenusName("Кошки");
    }
}
