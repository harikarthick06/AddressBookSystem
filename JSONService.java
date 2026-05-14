import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

// UC15 - Read/Write Address Book as JSON File
public class JSONService {

    private static final String JSON_FILE_PATH = "addressbook.json";

    public void writeContactsToJSON(List<Contact> contactList) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(JSON_FILE_PATH)) {

            gson.toJson(contactList, writer);
            System.out.println("Contacts written to JSON file successfully.");

        } catch (Exception e) {
            System.out.println("Error while writing JSON file: " + e.getMessage());
        }
    }

    public List<Contact> readContactsFromJSON() {
        Gson gson = new Gson();
        List<Contact> contactList = new ArrayList<>();

        try (FileReader reader = new FileReader(JSON_FILE_PATH)) {

            Type contactListType = new TypeToken<List<Contact>>() {}.getType();
            contactList = gson.fromJson(reader, contactListType);

            if (contactList == null) {
                contactList = new ArrayList<>();
            }

            System.out.println("Contacts read from JSON file successfully.");

        } catch (Exception e) {
            System.out.println("Error while reading JSON file: " + e.getMessage());
        }

        return contactList;
    }
}
