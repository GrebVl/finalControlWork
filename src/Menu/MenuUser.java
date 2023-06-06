package Menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import WorkFile.FileJSON;
import WorkFile.FileJSON.*;

import Animal.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class MenuUser {
    private boolean ex;
    private ScannerInput scn;

    private Map<String, List<HumanFriends>> animal;
    private List<HumanFriends> cats;
    private List<HumanFriends> dogs;
    private List<HumanFriends> hamsters;
    private FileJSON a;

    public MenuUser() {
        this.ex = true;
        this.scn = new ScannerInput();
        this.animal = new HashMap<>();
        this.cats = new ArrayList<>();
        this.dogs = new ArrayList<>();
        this.hamsters = new ArrayList<>();
        this.animal.put("кошки", this.cats);
        this.animal.put("собаки", this.dogs);
        this.animal.put("хомяк", this.hamsters);
        this.a = new FileJSON();
        fileAddAnimal();
    }

    public void menuUser() {
        while (true) {
            System.out.println("1 Список всех животных\n" +
                    "2 Дбавить новое животное\n" +
                    "3 Редактировние животных\n" +
                    "4 Выход");

            int number = scn.getInt();
            switch (number) {
                case 1:
                    printAnimal();
                    break;
                case 2:
                    addAnimalCategory();
                    break;
                case 3:

                    break;
                case 4:
                    a.WreatFile(animal, "PetsAnimal");
                    scn.closeScn();
                    return;
            }

        }
    }

    public void fileAddAnimal() {
        try {
            ArrayList<String[]> arr = a.ReadFile("PetsAnimal");
            for (int j = 0; j < arr.size(); j++) {
                addAnimal(arr.get(j)[0], arr.get(j)[1], arr.get(j)[2], arr.get(j)[3], arr.get(j)[4]);
            }
        }catch (IOException | ParseException e){
            System.out.println(e.getMessage());
        }
    }

    public void addAnimalCategory() {
        while (true) {
            System.out.println("1 Добавить вьючное\n" +
                    "2 Добавить домашнее\n" +
                    "3 Выход");

            int number = scn.getInt();
            switch (number) {
                case 1:
                    addAnimalPack("вьючное");
                    break;
                case 2:
                    addAnimalPets("домашнее");
                    break;
                case 3:
                    return;
            }
        }
    }

    public void addAnimalPets(String category) {
        while (true) {
            System.out.println("1 Добавить кошки\n" +
                    "2 Добавить собаки\n" +
                    "3 Добавить хомяк\n" +
                    "4 Выход");

            int number = scn.getInt();
            switch (number) {
                case 1:
                    addNewAnimals(category, "кошки");
                    break;
                case 2:
                    addNewAnimals(category, "собаки");
                    break;
                case 3:
                    addNewAnimals(category, "хомяк");
                    break;
                case 4:
                    return;
            }
        }
    }

    public void printAnimal() {
        String[] kMap = new String[]{"кошки", "собаки", "хомяк"};
        int count = 0;
        for (int j = 0; j < kMap.length; j++) {
            if (animal.containsKey(kMap[j])) {
                for (int i = 0; i < animal.get(kMap[j]).size(); i++) {
                    count++;
                    System.out.println(count + ": " + animal.get(kMap[j]).get(i).toString());
                }
            }
        }
    }

    public void addAnimalPack(String category) {
        while (true) {
            System.out.println("1 Добавить лошади\n" +
                    "2 Добавить верблюды\n" +
                    "3 Добавить ослы\n" +
                    "4 Выход");

            int number = scn.getInt();
            switch (number) {
                case 1:
                    addNewAnimals(category, "лошади");
                    break;
                case 2:
                    addNewAnimals(category, "верблюды");
                    break;
                case 3:
                    addNewAnimals(category, "ослы");
                    break;
                case 4:
                    return;
            }
        }
    }

    public void addNewAnimals(String category, String genus) {
        ScannerInput scnInput = new ScannerInput();
        System.out.println("Введите имя");
        String nameAnimal = scnInput.getString();
        System.out.println("Введите дату рождения");
        String nameData = scnInput.getString();
        System.out.println("Введите команду");
        String nameCommand = scnInput.getString();
        addAnimal(category, genus, nameAnimal, nameData, nameCommand);

    }

    public void addAnimal(String category, String genus, String nameAnimal, String nameData, String nameCommand) {
        switch (category) {
            case "домашнее":
                switch (genus) {
                    case "кошки":
                        cats.add(new Cats(nameAnimal, nameCommand, nameData));
                        break;
                    case "собаки":
                        dogs.add(new Cats(nameAnimal, nameCommand, nameData));
                        break;
                    case "хомяк":
                        hamsters.add(new Cats(nameAnimal, nameCommand, nameData));
                        break;
                    case "вьючное":
                        switch (genus) {
                            case "лошади":

                                break;
                            case "верблюды":

                                break;
                            case "ослы":
                                break;

                        }
                }
        }
    }
}




