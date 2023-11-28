package org.example.gradecalculator.domain;

public class GradeCalculator {

    private final Courses courses;

    public GradeCalculator(final Courses courses) {
        this.courses = courses;
    }

    public double calculateGrade() {
        return courses.calculateTotalScore() / courses.calculateTotalCredit();
    }

}
