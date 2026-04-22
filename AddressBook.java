

import java.util.ArrayList;

public class AddressBook {
    private ArrayList<ContactPerson> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(ContactPerson person) {
        contacts.add(person);
        System.out.println("Contact added successfully.");
    }

    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        for (ContactPerson person : contacts) {
            person.displayContact();
        }
    }

    public ContactPerson findContactByFirstName(String firstName) {
        for (ContactPerson person : contacts) {
            if (person.getFirstName().equalsIgnoreCase(firstName)) {
                return person;
            }
        }
        return null;
    }

    public boolean deleteContactByFirstName(String firstName) {
        ContactPerson person = findContactByFirstName(firstName);
        if (person != null) {
            contacts.remove(person);
            return true;
        }
        return false;
    }
}