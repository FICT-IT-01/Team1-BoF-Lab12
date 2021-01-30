package com.kpi.it01.team1.lab12.models;

import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Iterator;

public class Institute {
    private String name;
    private final HashSet<Faculty> faculties;

    public Institute(String name) {
        this.name = name;
        faculties = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public HashSet<Faculty> getFaculties() {
        return faculties;
    }

    public Faculty getFacultyByName(String name) throws Exception {
        var faculty = faculties.stream().filter(f -> f.getName().equals(name)).findFirst();

        if (faculty.isEmpty()) {
            throw new Exception("Faculty not found.");
        }

        return faculty.get();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addFaculty(Faculty faculty) throws NullPointerException {
        faculties.add(faculty);
    }

    public void removeFacultyByName(String name) {
        faculties.removeIf(f -> f.getName().equals(name));
    }

    public Integer getStudentsAmount() {
        int amount = 0;

        for (Iterator it = faculties.iterator(); it.hasNext();) {
            amount += ((Faculty)it.next()).getStudents().size();
        }

        return amount;
    }

    @Nullable
    public Faculty getBiggestFaculty() {
        int maxStudents = 0;
        Faculty output = faculties.iterator().next();

        for (Iterator<Faculty> it = faculties.iterator(); it.hasNext();) {
            var f = it.next();
            if (f.getStudentsAmount() > maxStudents) {
                maxStudents = f.getStudentsAmount();
                output = f;
            }
        }

        return output;
    }

    public HashSet<Student> getStudentsWithAverageMarkInRange(Integer min, Integer max) {
        var output = new HashSet<Student>();

        for (var f : faculties) {
            output.addAll(f.getStudentsWithAverageMarkInRange(min, max));
        }

        return output;
    }

    @Override
    public String toString() {
        return "Institute{" +
                "name='" + name +
                ",\nfaculties=" + faculties +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Institute institute = (Institute) o;

        if (!name.equals(institute.name)) return false;
        return faculties.equals(institute.faculties);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + faculties.hashCode();
        return result;
    }
}
