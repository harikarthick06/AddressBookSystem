import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private List<ContactPerson> contactList = new ArrayList<>();

    public void addContact(ContactPerson contactPerson) {
        contactList.add(contactPerson);
        System.out.println("Contact added successfully.");
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