package org.example.gradecalculator.domain;

public class Course {

    private final String subject;
    private final String grade;
    private final int credit; // 수강 학점

    public Course(final String subject, final String grade, final int credit) {
        validate(grade);
        this.subject = subject;
        this.grade = grade;
        this.credit = credit;
    }

    private void validate(final String grade) {
        if (!Score.isValidGrade(grade)) {
            throw new IllegalArgumentException("잘못된 학점입니다.");
        }
    }

    public double calculateScore() {
        return credit * Score.findScore(grade);
    }

    public int getCredit() {
        return credit;
    }

}
