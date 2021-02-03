package com.kpi.it01.team1.lab12;

import com.kpi.it01.team1.lab12.models.Faculty;
import com.kpi.it01.team1.lab12.models.Institute;
import com.kpi.it01.team1.lab12.models.Student;

import java.io.InvalidObjectException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Institute kpi = new Institute("National Technical University of Ukraine “Igor Sikorsky Kyiv Polytechnic Institute”");

        kpi.addFaculty(new Faculty("FICT"));
        kpi.addFaculty(new Faculty("FPM"));
        kpi.addFaculty(new Faculty("FTI"));
        kpi.addFaculty(new Faculty("FMM"));
        kpi.addFaculty(new Faculty("FMF"));
        kpi.addFaculty(new Faculty("FEL"));
        kpi.addFaculty(new Faculty("FEA"));

        for (var f : kpi.getFaculties())
        {
            for (int i = 0; i < ThreadLocalRandom.current().nextInt(10, 100); ++i)
            {
                try {
                    var studentBookNumber = Integer.valueOf(ThreadLocalRandom.current().nextInt(1, 9999)).toString();

                    f.addStudent(new Student(UUID.randomUUID().toString().substring(0, 7),
                                    UUID.randomUUID().toString().substring(0, 7),
                            f.getName().substring(0, 2) +
                                    ("0000" + studentBookNumber).substring(studentBookNumber.length()),
                            "",
                            ThreadLocalRandom.current().nextFloat() * 100));
                }
                catch (NullPointerException | InvalidObjectException ex) {
                }
            }
        }

        System.out.println(kpi);

        System.out.println("Students at KPI: " + kpi.getStudentsAmount());
        System.out.println("Greatest amount of students at " + kpi.getBiggestFaculty().getName());
        System.out.println("Students with average mark from 95 to 100:");

        for (var entry : kpi.getStudentsWithAverageMarkInRange(95, 100).entrySet()) {
            for (var student : entry.getValue()) {
                System.out.println("\t" + entry.getKey().getName() + ": " + student);
            }
        }
    }
}
