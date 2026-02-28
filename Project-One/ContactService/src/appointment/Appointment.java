package appointment;

import java.util.Date;

/**
 * Represents an Appointment in the mobile application.
 * An Appointment has a required, unique appointmentId, a required appointment date
 * that cannot be in the past, and a required description.
 */
public class Appointment {

    /** Unique appointment identifier (not updatable). */
    private final String appointmentId;

    /** Appointment date (required, cannot be in the past). */
    private final Date appointmentDate;

    /** Appointment description (required, max 50 characters). */
    private final String description;

    /**
     * Creates an Appointment with required fields and validates all inputs.
     *
     * @param appointmentId   unique appointment ID (required, max 10 characters)
     * @param appointmentDate appointment date (required, cannot be in the past)
     * @param description     description (required, max 50 characters)
     * @throws IllegalArgumentException if any argument is null or violates requirements
     */
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }

        this.appointmentId = appointmentId;
        // Defensive copy because Date is mutable
        this.appointmentDate = new Date(appointmentDate.getTime());
        this.description = description;
    }

    /**
     * Returns the appointment ID (not updatable).
     *
     * @return appointmentId
     */
    public String getAppointmentId() {
        return appointmentId;
    }

    /**
     * Returns the appointment date.
     *
     * @return a copy of the appointment date to preserve immutability
     */
    public Date getAppointmentDate() {
        return new Date(appointmentDate.getTime());
    }

    /**
     * Returns the appointment description.
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }
}