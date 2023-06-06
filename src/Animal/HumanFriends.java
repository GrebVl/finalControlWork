package Animal;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class HumanFriends {
    private String animalName;
    private String commands;
    private String dateBirth;
    private String animalCategory;
    private String genusName;

    public HumanFriends(String animalName, String command, String dateBirth){
        this.animalName = animalName;
        this.commands = command;
        this.dateBirth = dateBirth;
    }
    

    public void setAnimalCategory(String animalCategory) {
        this.animalCategory = animalCategory;
    }

    public String getAnimalCategory() {
        return this.animalCategory;
    }

    public void setGenusName(String genusName){
        this.genusName = genusName;
    }

    public String getGenusName() {
        return this.genusName;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getCommands() {
        return commands;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s", animalCategory, genusName, animalName, dateBirth, commands);
    }
}
