package org.example.gradecalculator.domain;

import java.util.Arrays;

public enum Score {

    A_PLUS("A+", 4.5),
    A("A", 4.0),
    B_PLUS("B+", 3.5),
    B("B", 3.0),
    C_PLUS("C+", 2.5),
    C("C", 2.0),
    D_PLUS("D+", 1.5),
    D("D", 1.0),
    F("F", 0.0);

    private final String grade;
    private final double score;

    Score(final String grade, final double score) {
        this.grade = grade;
        this.score = score;
    }

    public static boolean isValidGrade(final String grade) {
        return Arrays.stream(Score.values())
                .anyMatch(score -> score.grade.equals(grade));
    }

    public static double findScore(final String grade) {
        return Arrays.stream(Score.values())
                .filter(score -> score.grade.equals(grade))
                .findFirst()
                .map(score -> score.score)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 학점입니다."));
    }

}
