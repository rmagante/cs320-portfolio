package contact;

import java.util.HashMap;
import java.util.Map;

/**
 * Service class for managing Contact objects in-memory.
 * Supports adding, deleting, and updating contact fields by contactId.
 */
public class ContactService {

    private final Map<String, Contact> contacts = new HashMap<>();

    /**
     * Adds a new contact to the service. Contact IDs must be unique.
     *
     * @param contact the Contact to add
     * @throws IllegalArgumentException if contact is null or the ID already exists
     */
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }

        String id = contact.getContactId();
        if (contacts.containsKey(id)) {
            throw new IllegalArgumentException("Contact ID already exists");
        }

        contacts.put(id, contact);
    }

    /**
     * Deletes a contact by contactId.
     *
     * @param contactId the ID of the contact to delete
     * @throws IllegalArgumentException if contactId is null or does not exist
     */
    public void deleteContact(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }

        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }

        contacts.remove(contactId);
    }

    /**
     * Updates the contact's first name by contactId.
     *
     * @param contactId  the ID of the contact to update
     * @param firstName  the new first name
     * @throws IllegalArgumentException if contactId is null, does not exist, or firstName is invalid
     */
    public void updateFirstName(String contactId, String firstName) {
        Contact contact = getRequiredContact(contactId);
        contact.setFirstName(firstName);
    }

    /**
     * Updates the contact's last name by contactId.
     *
     * @param contactId the ID of the contact to update
     * @param lastName  the new last name
     * @throws IllegalArgumentException if contactId is null, does not exist, or lastName is invalid
     */
    public void updateLastName(String contactId, String lastName) {
        Contact contact = getRequiredContact(contactId);
        contact.setLastName(lastName);
    }

    /**
     * Updates the contact's phone number by contactId.
     *
     * @param contactId the ID of the contact to update
     * @param phone     the new phone number
     * @throws IllegalArgumentException if contactId is null, does not exist, or phone is invalid
     */
    public void updatePhone(String contactId, String phone) {
        Contact contact = getRequiredContact(contactId);
        contact.setPhone(phone);
    }

    /**
     * Updates the contact's address by contactId.
     *
     * @param contactId the ID of the contact to update
     * @param address   the new address
     * @throws IllegalArgumentException if contactId is null, does not exist, or address is invalid
     */
    public void updateAddress(String contactId, String address) {
        Contact contact = getRequiredContact(contactId);
        contact.setAddress(address);
    }

    /**
     * Optional convenience method: updates multiple fields.
     * Fields are only updated when non-null values are provided.
     *
     * Note: Individual update methods are preferred for requirements clarity.
     *
     * @param contactId the ID of the contact to update
     * @param firstName new first name (optional)
     * @param lastName  new last name (optional)
     * @param phone     new phone number (optional)
     * @param address   new address (optional)
     * @throws IllegalArgumentException if contactId is invalid or any provided field is invalid
     */
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        if (firstName != null) {
            updateFirstName(contactId, firstName);
        }
        if (lastName != null) {
            updateLastName(contactId, lastName);
        }
        if (phone != null) {
            updatePhone(contactId, phone);
        }
        if (address != null) {
            updateAddress(contactId, address);
        }
    }

    /**
     * Retrieves a contact by contactId (test helper).
     *
     * @param contactId the ID of the contact
     * @return the Contact if found; otherwise null
     */
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

    /**
     * Internal helper to fetch an existing contact and enforce required checks.
     *
     * @param contactId the ID of the contact
     * @return the existing Contact
     * @throws IllegalArgumentException if contactId is null or does not exist
     */
    private Contact getRequiredContact(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }

        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }

        return contact;
    }
}