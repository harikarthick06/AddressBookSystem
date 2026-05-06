import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AddressBook {
    private List<ContactPerson> contactList = new ArrayList<>();

    public void addContact(ContactPerson contactPerson) {
        boolean isDuplicate = contactList.stream()
                .anyMatch(contact -> contact.equals(contactPerson));

        if (isDuplicate) {
            System.out.println("Duplicate contact found. Contact not added.");
        } else {
            contactList.add(contactPerson);
            System.out.println("Contact added successfully.");
        }
    }

    public void displayContacts() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        contactList.forEach(System.out::println);
    }

    public List<ContactPerson> getContactList() {
        return contactList;
    }

    // UC11: Sort contacts by name
    public void sortContactsByName() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        contactList.stream()
                .sorted(Comparator.comparing(ContactPerson::getFirstName)
                        .thenComparing(ContactPerson::getLastName))
                .forEach(System.out::println);
    }

    // UC11: Sort contacts by city
    public void sortContactsByCity() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        contactList.stream()
                .sorted(Comparator.comparing(ContactPerson::getCity))
                .forEach(System.out::println);
    }

    // UC11: Sort contacts by state
    public void sortContactsByState() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        contactList.stream()
                .sorted(Comparator.comparing(ContactPerson::getState))
                .forEach(System.out::println);
    }

    // UC11: Sort contacts by zip
    public void sortContactsByZip() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        contactList.stream()
                .sorted(Comparator.comparing(ContactPerson::getZip))
                .forEach(System.out::println);
    }
}