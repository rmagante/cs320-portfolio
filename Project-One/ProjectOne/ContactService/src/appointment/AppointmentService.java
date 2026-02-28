package appointment;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Service class for managing Appointment objects in-memory.
 * Supports adding appointments (unique IDs) and deleting appointments by appointmentId.
 */
public class AppointmentService {

    private final Map<String, Appointment> appointments = new HashMap<>();

    /**
     * Adds an appointment to the service. Appointment IDs must be unique.
     *
     * @param appointment the Appointment to add
     * @throws IllegalArgumentException if appointment is null or the ID already exists
     */
    public void addAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null");
        }

        String id = appointment.getAppointmentId();
        if (appointments.containsKey(id)) {
            throw new IllegalArgumentException("Appointment ID already exists");
        }

        appointments.put(id, appointment);
    }

    /**
     * Convenience method to create and add an appointment using raw fields.
     *
     * @param appointmentId   unique appointment ID (required, max 10 characters)
     * @param appointmentDate appointment date (required, cannot be in the past)
     * @param description     description (required, max 50 characters)
     * @throws IllegalArgumentException if any argument violates Appointment requirements
     */
    public void addAppointment(String appointmentId, Date appointmentDate, String description) {
        Appointment appointment = new Appointment(appointmentId, appointmentDate, description);
        addAppointment(appointment);
    }

    /**
     * Deletes an appointment by appointmentId.
     *
     * @param appointmentId the ID of the appointment to delete
     * @throws IllegalArgumentException if appointmentId is null or does not exist
     */
    public void deleteAppointment(String appointmentId) {
        if (appointmentId == null) {
            throw new IllegalArgumentException("Appointment ID cannot be null");
        }
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID does not exist");
        }

        appointments.remove(appointmentId);
    }

    /**
     * Retrieves an appointment by appointmentId.
     * Used primarily for testing.
     *
     * @param appointmentId the ID of the appointment
     * @return the Appointment if found; otherwise null
     */
    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}