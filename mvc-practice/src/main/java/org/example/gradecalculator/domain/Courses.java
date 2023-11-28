package org.example.gradecalculator.domain;

import java.util.List;

public class Courses {

    private final List<Course> courses;

    public Courses(final List<Course> courses) {
        this.courses = courses;
    }

    public double calculateTotalScore() {
        return courses.stream()
                .mapToDouble(Course::calculateScore)
                .sum();
    }

    public int calculateTotalCredit() {
        return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }

}
