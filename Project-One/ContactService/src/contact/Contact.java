package contact;

/**
 * Represents a Contact in the mobile application.
 * A Contact has a required, unique contactId and required fields for name, phone, and address.
 * All fields are validated to meet the project requirements.
 */
public class Contact {

    /** Unique contact identifier (not updatable). */
    private final String contactId;

    /** Contact first name (required, max 10 characters). */
    private String firstName;

    /** Contact last name (required, max 10 characters). */
    private String lastName;

    /** Contact phone number (required, exactly 10 digits). */
    private String phone;

    /** Contact address (required, max 30 characters). */
    private String address;

    /**
     * Creates a Contact with required fields and validates all inputs.
     *
     * @param contactId unique contact ID (required, max 10 characters)
     * @param firstName first name (required, max 10 characters)
     * @param lastName  last name (required, max 10 characters)
     * @param phone     phone number (required, exactly 10 digits)
     * @param address   address (required, max 30 characters)
     * @throws IllegalArgumentException if any argument is null or violates length/format requirements
     */
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {

        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    /**
     * Returns the contact ID (not updatable).
     *
     * @return contactId
     */
    public String getContactId() {
        return contactId;
    }

    /**
     * Returns the contact's first name.
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the contact's last name.
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the contact's phone number.
     *
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Returns the contact's address.
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Updates the first name after validating requirements.
     *
     * @param firstName new first name (required, max 10 characters)
     * @throws IllegalArgumentException if firstName is null or longer than 10 characters
     */
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }

    /**
     * Updates the last name after validating requirements.
     *
     * @param lastName new last name (required, max 10 characters)
     * @throws IllegalArgumentException if lastName is null or longer than 10 characters
     */
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

    /**
     * Updates the phone number after validating requirements.
     *
     * @param phone new phone number (required, exactly 10 digits)
     * @throws IllegalArgumentException if phone is null, not 10 characters, or not numeric
     */
    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phone = phone;
    }

    /**
     * Updates the address after validating requirements.
     *
     * @param address new address (required, max 30 characters)
     * @throws IllegalArgumentException if address is null or longer than 30 characters
     */
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
}