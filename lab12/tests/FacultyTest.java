package com.kpi.it01.team1.lab12.tests;

import com.kpi.it01.team1.lab12.models.Faculty;
import com.kpi.it01.team1.lab12.models.Student;
import org.junit.jupiter.api.Test;
import java.io.InvalidObjectException;

import static org.junit.jupiter.api.Assertions.*;

class FacultyTest {
    @Test
    void testCreateFaculty() {
        Faculty f = new Faculty("FICT");

        assertEquals("FICT", f.getName());
        assertEquals(true, f.getStudents() != null);
    }

    @Test
    void testAddStudents() {
        Faculty f = new Faculty("FICT");

        try {
            f.addStudent(new Student("Firstname", "Lastname", "CS1023"));
            f.addStudent(new Student("Firstname", "Lastname", "CS1023"));
            f.addStudent(null);
        }
        catch (NullPointerException nullPointerException) {
            assertEquals("Student can`t be null.", nullPointerException.getMessage());
        }
        catch (InvalidObjectException invalidObjectException) {
            assertEquals("This student is already at this list.", invalidObjectException.getMessage());
        }

        assertEquals(1, f.getStudents().stream().count());
    }

    @Test
    void testRemoveStudent() {
        Faculty f = new Faculty("FICT");

        try {
            f.addStudent(new Student("F1", "L1", "PI0001"));
            f.addStudent(new Student("F2", "L2", "PI0002"));
            f.addStudent(new Student("F3", "L3", "PI0003"));
            f.addStudent(new Student("F4", "L4", "PI0004"));
        }
        catch (NullPointerException ex) {
            fail("Received NullPointerException while input correct");
        }
        catch (InvalidObjectException ex) {
            fail("Received InvalidObjectException while input correct");
        }

        assertEquals(4, f.getStudents().stream().count(), "Incorrect students amount");

        f.removeStudentByStudentBookId("PI0001");

        var student = f.getStudents().stream().findFirst().get();
        assertEquals("PI0002", student.getStudentBookNumber());

        f.removeStudentByStudentBookId("PI0004");

        assertEquals(2, f.getStudents().stream().count());
    }
}