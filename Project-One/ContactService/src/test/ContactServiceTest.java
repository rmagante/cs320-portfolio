package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import contact.Contact;
import contact.ContactService;

/**
 * Unit tests for the ContactService class.
 * Verifies add, delete, and per-field update behavior.
 */
public class ContactServiceTest {

    @Test
    void testAddContactSuccess() {
        ContactService service = new ContactService();
        Contact c = new Contact("1", "Ryan", "Magante", "1234567890", "123 Main Street");

        service.addContact(c);

        assertNotNull(service.getContact("1"));
        assertEquals("Ryan", service.getContact("1").getFirstName());
    }

    @Test
    void testAddNullContactThrows() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
    }

    @Test
    void testAddDuplicateIdThrows() {
        ContactService service = new ContactService();
        Contact c1 = new Contact("1", "Ryan", "Magante", "1234567890", "123 Main Street");
        Contact c2 = new Contact("1", "Bob", "Smith", "1112223333", "456 Other Street");

        service.addContact(c1);

        assertThrows(IllegalArgumentException.class, () -> service.addContact(c2));
    }

    @Test
    void testDeleteContactSuccess() {
        ContactService service = new ContactService();
        Contact c = new Contact("1", "Ryan", "Magante", "1234567890", "123 Main Street");

        service.addContact(c);
        service.deleteContact("1");

        assertNull(service.getContact("1"));
    }

    @Test
    void testDeleteNullIdThrows() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact(null));
    }

    @Test
    void testDeleteNonexistentThrows() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("does-not-exist"));
    }

    @Test
    void testUpdateFirstNameOnly() {
        ContactService service = new ContactService();
        Contact c = new Contact("1", "Ryan", "Magante", "1234567890", "123 Main Street");
        service.addContact(c);

        service.updateFirstName("1", "NewFirst");

        Contact updated = service.getContact("1");
        assertEquals("NewFirst", updated.getFirstName());
        assertEquals("Magante", updated.getLastName());
        assertEquals("1234567890", updated.getPhone());
        assertEquals("123 Main Street", updated.getAddress());
        assertEquals("1", updated.getContactId()); // ID not updatable
    }

    @Test
    void testUpdateLastNameOnly() {
        ContactService service = new ContactService();
        Contact c = new Contact("1", "Ryan", "Magante", "1234567890", "123 Main Street");
        service.addContact(c);

        service.updateLastName("1", "NewLast");

        Contact updated = service.getContact("1");
        assertEquals("Ryan", updated.getFirstName());
        assertEquals("NewLast", updated.getLastName());
    }

    @Test
    void testUpdatePhoneOnly() {
        ContactService service = new ContactService();
        Contact c = new Contact("1", "Ryan", "Magante", "1234567890", "123 Main Street");
        service.addContact(c);

        service.updatePhone("1", "0987654321");

        Contact updated = service.getContact("1");
        assertEquals("0987654321", updated.getPhone());
    }

    @Test
    void testUpdateAddressOnly() {
        ContactService service = new ContactService();
        Contact c = new Contact("1", "Ryan", "Magante", "1234567890", "123 Main Street");
        service.addContact(c);

        service.updateAddress("1", "999 Updated Ave");

        Contact updated = service.getContact("1");
        assertEquals("999 Updated Ave", updated.getAddress());
    }

    @Test
    void testUpdateNonexistentThrows() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("missing", "A"));
    }

    @Test
    void testUpdateNullIdThrows() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName(null, "A"));
    }

    @Test
    void testUpdateRejectsInvalidFieldViaContactValidation() {
        ContactService service = new ContactService();
        Contact c = new Contact("1", "Ryan", "Magante", "1234567890", "123 Main Street");
        service.addContact(c);

        // invalid phone (not 10 digits) should throw from Contact.setPhone
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("1", "123"));
    }
}