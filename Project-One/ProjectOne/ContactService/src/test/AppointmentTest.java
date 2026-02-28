package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import appointment.Appointment;

/**
 * Unit tests for the Appointment class.
 * Verifies constructor validation rules for ID, date, and description.
 */
class AppointmentTest {

    private Date futureDate() {
        return new Date(System.currentTimeMillis() + 172800000); // +2 days
    }

    @Test
    void testValidAppointmentCreation() {
        Date futureDate = futureDate();

        Appointment appointment = new Appointment(
                "A123",
                futureDate,
                "Doctor appointment"
        );

        assertEquals("A123", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Doctor appointment", appointment.getDescription());
    }

    @Test
    void testMaxLengthDescriptionAllowed() {
        Date futureDate = futureDate();

        String desc50 = "12345678901234567890123456789012345678901234567890"; // 50 chars

        Appointment appointment = new Appointment("A123", futureDate, desc50);

        assertEquals(desc50, appointment.getDescription());
    }

    @Test
    void testNullAppointmentIdThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Appointment(null, futureDate(), "Description"));
    }

    @Test
    void testAppointmentIdTooLongThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Appointment("12345678901", futureDate(), "Description")); // 11 chars
    }

    @Test
    void testNullAppointmentDateThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Appointment("A123", null, "Description"));
    }

    @Test
    void testPastAppointmentDateThrowsException() {
        Date pastDate = new Date(System.currentTimeMillis() - 86400000); // -1 day

        assertThrows(IllegalArgumentException.class, () ->
                new Appointment("A123", pastDate, "Description"));
    }

    @Test
    void testNullDescriptionThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Appointment("A123", futureDate(), null));
    }

    @Test
    void testDescriptionTooLongThrowsException() {
        String longDescription =
                "This description is intentionally longer than fifty characters to fail";

        assertThrows(IllegalArgumentException.class, () ->
                new Appointment("A123", futureDate(), longDescription));
    }
}