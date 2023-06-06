package WorkFile;

import Animal.HumanFriends;
import Menu.MenuUser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileJSON {
    public ArrayList<String[]> ReadFile(String FileName) throws IOException, ParseException {
        String[] arr = new String[]{"animalName", "commands", "dateBirth", "animalCategory", "genusName"};
        ArrayList<String[]> animal = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        try (FileReader fileTaskRead = new FileReader(FileName)) {
            JSONArray arrF = (JSONArray) jsonParser.parse(fileTaskRead);
            for (Object obj : arrF) {
                JSONObject per = (JSONObject) obj;
                String nameAnimal = (String) per.get(arr[0]);
                String nameCommand = (String) per.get(arr[1]);
                String nameData = (String) per.get(arr[2]);
                String category = (String) per.get(arr[3]);
                String genus = (String) per.get(arr[4]);
                animal.add(new String[]{category, genus, nameAnimal, nameData, nameCommand});
            }
        } catch (Exception e) {
            System.out.println("Parsing error " + e.toString());
        }
        return animal;
    }

    public void WreatFile(Map<String, List<HumanFriends>> animal, String FileName) {
        ArrayList<JSONObject> arrJson = new ArrayList<>();
        String[] arr = new String[]{"animalName", "commands", "dateBirth", "animalCategory", "genusName"};
        String[] kMap = new String[]{"кошки", "собаки", "хомяк"};
        for (int j = 0; j < kMap.length; j++){
            if (animal.containsKey(kMap[j])) {
                for (int i = 0; i < animal.get(kMap[j]).size(); i++) {
                    arrJson.add(new JSONObject());
                    arrJson.get(i).put(arr[0], animal.get(kMap[j]).get(i).getAnimalName());
                    arrJson.get(i).put(arr[1], animal.get(kMap[j]).get(i).getCommands());
                    arrJson.get(i).put(arr[2], animal.get(kMap[j]).get(i).getDateBirth());
                    arrJson.get(i).put(arr[3], animal.get(kMap[j]).get(i).getAnimalCategory());
                    arrJson.get(i).put(arr[4], animal.get(kMap[j]).get(i).getGenusName());
                }
            }
        }
        try (PrintWriter out = new PrintWriter(new FileWriter(FileName))) {
            out.write(arrJson.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}