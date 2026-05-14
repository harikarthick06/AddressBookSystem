import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

// UC14 - Read/Write Address Book as CSV File
public class CSVService {

    private static final String CSV_FILE_PATH = "addressbook.csv";

    public void writeContactsToCSV(List<Contact> contactList) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE_PATH))) {

            String[] header = {
                    "First Name",
                    "Last Name",
                    "Address",
                    "City",
                    "State",
                    "Zip",
                    "Phone Number",
                    "Email"
            };

            writer.writeNext(header);

            for (Contact contact : contactList) {
                String[] data = {
                        contact.getFirstName(),
                        contact.getLastName(),
                        contact.getAddress(),
                        contact.getCity(),
                        contact.getState(),
                        contact.getZip(),
                        contact.getPhoneNumber(),
                        contact.getEmail()
                };

                writer.writeNext(data);
            }

            System.out.println("Contacts written to CSV file successfully.");

        } catch (Exception e) {
            System.out.println("Error while writing CSV file: " + e.getMessage());
        }
    }

    public List<Contact> readContactsFromCSV() {
        List<Contact> contactList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE_PATH))) {

            String[] data;
            boolean isHeader = true;

            while ((data = reader.readNext()) != null) {

                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                Contact contact = new Contact(
                        data[0],
                        data[1],
                        data[2],
                        data[3],
                        data[4],
                        data[5],
                        data[6],
                        data[7]
                );

                contactList.add(contact);
            }

            System.out.println("Contacts read from CSV file successfully.");

        } catch (Exception e) {
            System.out.println("Error while reading CSV file: " + e.getMessage());
        }

        return contactList;
    }
}
