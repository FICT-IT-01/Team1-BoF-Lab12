package com.kpi.it01.team1.lab12.models;

import java.io.InvalidObjectException;
import java.util.HashSet;

public class Faculty {
    private String name;
    private final HashSet<Student> students;

    public Faculty(String name) {
        this.name = name;
        students = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<Student> getStudents() {
        return students;
    }

    public Student getStudentByStudentBookId(String bookId) throws Exception {
        var student = students.stream().filter(s -> s.getStudentBookNumber().equals(bookId)).findFirst();

        if (student.isEmpty()) {
            throw new Exception("Student now found.");
        }

        return student.get();
    }

    public void addStudent(Student student) throws NullPointerException, InvalidObjectException {
        if (students.contains(student)) {
            throw new InvalidObjectException("This student is already at this list.");
        }

        students.add(student);
    }

    public void removeStudentByStudentBookId(String bookId) {
        students.removeIf(s -> s.getStudentBookNumber().equals(bookId));
    }

    public HashSet<Student> getStudentsWithAverageMarkInRange(Integer min, Integer max) {
        var output = new HashSet<Student>();

        for (var student : students) {
            if (student.getAverageMark() >= min && student.getAverageMark() <= max) {
                output.add(student);
            }
        }

        return output;
    }

    public Integer getStudentsAmount() {
        return this.students.size();
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();

        students.forEach(s -> sb.append(s.toString()).append(",\n"));

        return "\n\tFaculty{" +
                "name=" + name +
                ", \n\tstudents(" + students.size() + "):\n" +
                sb.toString() +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Faculty faculty = (Faculty) o;

        if (!name.equals(faculty.name)) return false;
        return students.equals(faculty.students);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + students.hashCode();
        return result;
    }
}