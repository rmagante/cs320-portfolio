package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import appointment.Appointment;
import appointment.AppointmentService;

/**
 * Unit tests for the AppointmentService class.
 * Verifies add and delete behavior and ensures IDs are unique.
 */
class AppointmentServiceTest {

    private Date futureDate() {
        return new Date(System.currentTimeMillis() + 172800000); // +2 days
    }

    @Test
    void testAddAppointmentSuccess() {
        AppointmentService service = new AppointmentService();
        Date futureDate = futureDate();

        Appointment appointment = new Appointment("A123", futureDate, "Dentist appointment");
        service.addAppointment(appointment);

        assertNotNull(service.getAppointment("A123"));
    }

    @Test
    void testAddAppointmentNullThrowsException() {
        AppointmentService service = new AppointmentService();

        assertThrows(IllegalArgumentException.class, () -> service.addAppointment((Appointment) null));
    }

    @Test
    void testAddAppointmentUsingFieldsSuccess() {
        AppointmentService service = new AppointmentService();
        Date futureDate = futureDate();

        service.addAppointment("A123", futureDate, "Dentist appointment");

        assertNotNull(service.getAppointment("A123"));
        assertEquals("Dentist appointment", service.getAppointment("A123").getDescription());
    }

    @Test
    void testAddDuplicateAppointmentThrowsException() {
        AppointmentService service = new AppointmentService();
        Date futureDate = futureDate();

        Appointment appointment1 = new Appointment("A123", futureDate, "First appointment");
        Appointment appointment2 = new Appointment("A123", futureDate, "Duplicate appointment");

        service.addAppointment(appointment1);

        assertThrows(IllegalArgumentException.class, () -> service.addAppointment(appointment2));
    }

    @Test
    void testDeleteAppointmentSuccess() {
        AppointmentService service = new AppointmentService();
        Date futureDate = futureDate();

        Appointment appointment = new Appointment("A123", futureDate, "Therapy session");
        service.addAppointment(appointment);

        service.deleteAppointment("A123");

        assertNull(service.getAppointment("A123"));
    }

    @Test
    void testDeleteNullAppointmentIdThrowsException() {
        AppointmentService service = new AppointmentService();

        assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment(null));
    }

    @Test
    void testDeleteNonexistentAppointmentThrowsException() {
        AppointmentService service = new AppointmentService();

        assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment("DOES_NOT_EXIST"));
    }
}