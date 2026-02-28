package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import contact.Contact;

/**
 * Unit tests for the Contact class.
 * Verifies that Contact enforces all required field constraints through
 * constructor validation and setter validation.
 */
public class ContactTest {

    @Test
    void testCreateContactSuccess() {
        Contact c = new Contact("12345", "Ryan", "Magante", "1234567890", "123 Main Street");

        assertEquals("12345", c.getContactId());
        assertEquals("Ryan", c.getFirstName());
        assertEquals("Magante", c.getLastName());
        assertEquals("1234567890", c.getPhone());
        assertEquals("123 Main Street", c.getAddress());
    }

    @Test
    void testMaxLengthsAllowed() {
        String id10 = "1234567890"; // 10 chars
        String name10 = "ABCDEFGHIJ"; // 10 chars
        String address30 = "123456789012345678901234567890"; // 30 chars

        Contact c = new Contact(id10, name10, name10, "1234567890", address30);

        assertEquals(id10, c.getContactId());
        assertEquals(name10, c.getFirstName());
        assertEquals(name10, c.getLastName());
        assertEquals("1234567890", c.getPhone());
        assertEquals(address30, c.getAddress());
    }

    @Test
    void testContactIdNullThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Ryan", "Magante", "1234567890", "123 Main Street");
        });
    }

    @Test
    void testContactIdTooLongThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Ryan", "Magante", "1234567890", "123 Main Street");
        });
    }

    @Test
    void testFirstNameNullThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Magante", "1234567890", "123 Main Street");
        });
    }

    @Test
    void testFirstNameTooLongThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "ThisNameIs11", "Magante", "1234567890", "123 Main Street");
        });
    }

    @Test
    void testLastNameNullThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ryan", null, "1234567890", "123 Main Street");
        });
    }

    @Test
    void testLastNameTooLongThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ryan", "ThisNameIs11", "1234567890", "123 Main Street");
        });
    }

    @Test
    void testPhoneNullThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ryan", "Magante", null, "123 Main Street");
        });
    }

    @Test
    void testPhoneNot10DigitsThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ryan", "Magante", "12345", "123 Main Street");
        });
    }

    @Test
    void testPhoneNotNumericThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ryan", "Magante", "12345abcde", "123 Main Street");
        });
    }

    @Test
    void testAddressNullThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ryan", "Magante", "1234567890", null);
        });
    }

    @Test
    void testAddressTooLongThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ryan", "Magante", "1234567890",
                    "1234567890123456789012345678901"); // 31 chars
        });
    }

    @Test
    void testSettersValidate() {
        Contact c = new Contact("12345", "Ryan", "Magante", "1234567890", "123 Main Street");

        c.setFirstName("Bob");
        assertEquals("Bob", c.getFirstName());

        assertThrows(IllegalArgumentException.class, () -> c.setFirstName("ThisNameIs11"));
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("111"));
        assertThrows(IllegalArgumentException.class, () -> c.setAddress(null));
    }
}