public class AddressBookMain {
    public static void main(String[] args) {

        AddressBook addressBook = new AddressBook();

        addressBook.addContact(new ContactPerson(
                "Hari", "Karthick", "Chennai", "Tamil Nadu",
                "600001", "9876543210", "hari@gmail.com"
        ));

        addressBook.addContact(new ContactPerson(
                "Arun", "Kumar", "Coimbatore", "Tamil Nadu",
                "641001", "9876543211", "arun@gmail.com"
        ));

        addressBook.addContact(new ContactPerson(
                "Rahul", "Sharma", "Bangalore", "Karnataka",
                "560001", "9876543212", "rahul@gmail.com"
        ));

        addressBook.addContact(new ContactPerson(
                "Divya", "Raj", "Chennai", "Tamil Nadu",
                "600040", "9876543213", "divya@gmail.com"
        ));

        // Duplicate contact
        addressBook.addContact(new ContactPerson(
                "Hari", "Karthick", "Madurai", "Tamil Nadu",
                "625001", "9999999999", "duplicate@gmail.com"
        ));

        System.out.println("\nSearch by City: Chennai");
        addressBook.display(addressBook.searchByCity("Chennai"));

        System.out.println("\nSearch by State: Tamil Nadu");
        addressBook.display(addressBook.searchByState("Tamil Nadu"));

        System.out.println("\nView Persons By City");
        addressBook.viewByCity().forEach((city, contacts) -> {
            System.out.println(city + " : " + contacts);
        });

        System.out.println("\nView Persons By State");
        addressBook.viewByState().forEach((state, contacts) -> {
            System.out.println(state + " : " + contacts);
        });

        System.out.println("\nCount By City");
        addressBook.countByCity().forEach((city, count) -> {
            System.out.println(city + " = " + count);
        });

        System.out.println("\nCount By State");
        addressBook.countByState().forEach((state, count) -> {
            System.out.println(state + " = " + count);
        });

        System.out.println("\nSort By Name");
        addressBook.display(addressBook.sortByName());

        System.out.println("\nSort By City");
        addressBook.display(addressBook.sortByCity());

        System.out.println("\nSort By State");
        addressBook.display(addressBook.sortByState());

        System.out.println("\nSort By Zip");
        addressBook.display(addressBook.sortByZip());
    }
}