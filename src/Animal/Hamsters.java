package Animal;

import java.time.format.DateTimeFormatter;

public class Hamsters extends Pets{


    public Hamsters(String animalName, String command, String dateBirth) {
        super(animalName, command, dateBirth);
        setGenusName("Хомяк");
    }

}
