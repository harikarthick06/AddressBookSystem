import java.util.ArrayList;
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
}