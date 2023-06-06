package Animal;

import java.time.format.DateTimeFormatter;

public class Dogs extends Pets {

    public Dogs(String animalName, String command, String dateBirth) {
        super(animalName, command, dateBirth);
        setGenusName("Собаки");
    }
}
