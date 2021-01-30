package com.kpi.it01.team1.lab12.tests;

import com.kpi.it01.team1.lab12.models.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentTest {

    @Test
    void testStudentCreation() {
        Student s1 = new Student("Firstname", "Lastname", "CS1010", "+000000000", 95);
        Student s2 = new Student("Firstname", "Lastname", "CS1010");

        Student s3 = new Student("FName", "LName", "CS0001");

        assertEquals(true, s1.equals(s2));
        assertEquals(false, s1.equals(s3));
    }

    @Test
    void testGetAndSetMethods() {
        Student s1 = new Student("Firstname", "Lastname", "CS1001");

        assertEquals("Firstname", s1.getFirstname());
        assertEquals("Lastname", s1.getLastname());
        assertEquals("CS1001", s1.getStudentBookNumber());

        s1.setAverageMark(95);
        assertEquals(95, s1.getAverageMark());

        s1.setPhoneNumber("+388988983471");
        assertEquals("+388988983471", s1.getPhoneNumber());

        s1.setAverageMark(96);
        assertEquals(96, s1.getAverageMark());
    }
}