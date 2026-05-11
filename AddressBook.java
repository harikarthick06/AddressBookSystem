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
}