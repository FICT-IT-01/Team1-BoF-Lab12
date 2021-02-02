package com.kpi.it01.team1.lab12.models;

public class Student {
    private final String id;
    private String firstname;
    private String lastname;
    private String studentBookNumber;
    private String phoneNumber;
    private float averageMark;

    public Student(String firstname, String lastname, String studentBookNumber, String phoneNumber, float averageMark) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.studentBookNumber = studentBookNumber;
        this.phoneNumber = phoneNumber;
        this.averageMark = averageMark;

        this.id = Integer.toString(hashCode());
    }

    public Student(String firstname, String lastname, String studentBookNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.studentBookNumber = studentBookNumber;

        this.id = Integer.toString(hashCode());
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getStudentBookNumber() {
        return studentBookNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public float getAverageMark() {
        return averageMark;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setStudentBookNumber(String studentBookNumber) {
        this.studentBookNumber = studentBookNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAverageMark(float averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (!id.equals(student.id)) return false;
        if (!firstname.equals(student.firstname)) return false;
        if (!lastname.equals(student.lastname)) return false;
        return studentBookNumber.equals(student.studentBookNumber);
    }

    @Override
    public int hashCode() {
        int result = 31 * firstname.hashCode();
        result = 31 * result + lastname.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "\t\t\t" + firstname + ' ' + lastname + '(' + id + ", " +
                studentBookNumber + "): " + averageMark + ", " + (phoneNumber.length() != 0 ? phoneNumber : "----");
    }
}
