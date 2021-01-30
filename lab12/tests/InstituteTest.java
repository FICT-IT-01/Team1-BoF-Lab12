package com.kpi.it01.team1.lab12.tests;

import com.kpi.it01.team1.lab12.models.Faculty;
import com.kpi.it01.team1.lab12.models.Institute;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InstituteTest {
    @Test
    void testInstituteCreation()
    {
        Institute i = new Institute("KPI");

        assertEquals("KPI", i.getName());
        assertEquals(true, i.getFaculties() != null);
    }

    @Test
    void testAddAndRemoveFaculty() {
        Institute i = new Institute("KPI");

        try {
            i.addFaculty(new Faculty("FICT"));
            i.addFaculty(new Faculty("FPM"));
            i.addFaculty(null);
        }
        catch (NullPointerException ex)
        {
            assertEquals("Faculty can`t be null.", ex.getMessage());
        }

        assertEquals(2, i.getFaculties().stream().count());

        try {
            assertEquals("FICT", i.getFacultyByName("FICT").getName());
        }
        catch (Exception ex) {
            assertEquals("Faculty not found.", ex.getMessage());
        }

        i.removeFacultyByName("FPM");

        assertEquals(1, i.getFaculties().stream().count());
    }
}