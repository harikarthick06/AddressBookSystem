import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {

    private List<ContactPerson> contacts = new ArrayList<>();

    // UC7 - Add contact and check duplicate
    public void addContact(ContactPerson contact) {
        boolean duplicate = contacts.stream()
                .anyMatch(c -> c.getFullName().equalsIgnoreCase(contact.getFullName()));

        if (duplicate) {
            System.out.println("Duplicate contact found: " + contact.getFullName());
        } else {
            contacts.add(contact);
            System.out.println("Contact added: " + contact.getFullName());
        }
    }

    // UC8 - Search by city
    public List<ContactPerson> searchByCity(String city) {
        return contacts.stream()
                .filter(c -> c.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    // UC8 - Search by state
    public List<ContactPerson> searchByState(String state) {
        return contacts.stream()
                .filter(c -> c.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());
    }

    // UC9 - View persons by city
    public Map<String, List<ContactPerson>> viewByCity() {
        return contacts.stream()
                .collect(Collectors.groupingBy(ContactPerson::getCity));
    }

    // UC9 - View persons by state
    public Map<String, List<ContactPerson>> viewByState() {
        return contacts.stream()
                .collect(Collectors.groupingBy(ContactPerson::getState));
    }

    // UC10 - Count persons by city
    public Map<String, Long> countByCity() {
        return contacts.stream()
                .collect(Collectors.groupingBy(ContactPerson::getCity, Collectors.counting()));
    }

    // UC10 - Count persons by state
    public Map<String, Long> countByState() {
        return contacts.stream()
                .collect(Collectors.groupingBy(ContactPerson::getState, Collectors.counting()));
    }

    // UC11 - Sort by name
    public List<ContactPerson> sortByName() {
        return contacts.stream()
                .sorted(Comparator.comparing(ContactPerson::getFirstName))
                .collect(Collectors.toList());
    }

    // UC12 - Sort by city
    public List<ContactPerson> sortByCity() {
        return contacts.stream()
                .sorted(Comparator.comparing(ContactPerson::getCity))
                .collect(Collectors.toList());
    }

    // UC12 - Sort by state
    public List<ContactPerson> sortByState() {
        return contacts.stream()
                .sorted(Comparator.comparing(ContactPerson::getState))
                .collect(Collectors.toList());
    }

    // UC12 - Sort by zip
    public List<ContactPerson> sortByZip() {
        return contacts.stream()
                .sorted(Comparator.comparing(ContactPerson::getZip))
                .collect(Collectors.toList());
    }

    public void display(List<ContactPerson> contactList) {
        contactList.forEach(System.out::println);
    }

    // UC13 - Write contacts to file
    public void writeDataToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (ContactPerson contact : contacts) {
                writer.write(contact.toString());
                writer.newLine();
            }
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // UC13 - Read contacts from file
    public void readDataFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("\nReading Contacts from File:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}