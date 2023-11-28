package org.example.gradecalculator;

import java.util.List;

import org.example.gradecalculator.domain.Course;
import org.example.gradecalculator.domain.Courses;
import org.example.gradecalculator.domain.GradeCalculator;

/**
 * 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수 MVC 패턴 적용 일급 컬렉션 사용
 */
public class GradeCalculatorApplication {

    public static void main(String[] args) {
        GradeCalculator gradeCalculator = new GradeCalculator(createCourses());

        System.out.println("평균 학점 : " + gradeCalculator.calculateGrade());
    }

    private static Courses createCourses() {
        return new Courses(List.of(
                new Course("알고리즘", "A+", 3),
                new Course("자료구조", "A", 3),
                new Course("글쓰기", "B+", 2),
                new Course("객체지향프로그래밍", "B+", 3),
                new Course("공학설계", "A", 2),
                new Course("경제학개론", "C+", 3)
        ));
    }

}
