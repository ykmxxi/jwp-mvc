package org.example.reflection;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.example.reflection.annotation.Controller;
import org.example.reflection.annotation.Service;
import org.example.reflection.controller.HomeController;
import org.example.reflection.controller.MemberController;
import org.example.reflection.service.HomeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ReflectionTest {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @DisplayName("리플렉션으로 @Controller 애노테이션이 있는 모든 클래스를 찾기")
    @Test
    void 리플렉션_컨트롤러_스캔() {
        Set<Class<?>> beans = getTypesAnnotationWith(List.of(Controller.class));

        logger.info("beans: {}", beans);
        assertThat(beans.contains(HomeController.class)).isTrue();
        assertThat(beans.contains(MemberController.class)).isTrue();
    }

    @DisplayName("리플렉션으로 @Service 애노테이션이 있는 모든 클래스를 찾기")
    @Test
    void 리플렉션_서비스_스캔() {
        Set<Class<?>> beans = getTypesAnnotationWith(List.of(Service.class));

        logger.info("beans: {}", beans);
        assertThat(beans.contains(HomeService.class)).isTrue();
    }

    private Set<Class<?>> getTypesAnnotationWith(final List<Class<? extends Annotation>> targets) {
        Reflections reflections = new Reflections("org.example");
        Set<Class<?>> beans = new HashSet<>();
        targets.forEach(target -> beans.addAll(reflections.getTypesAnnotatedWith(target)));
        return beans;
    }

    @DisplayName("리플렉션으로 클래스 정보 얻기: 힙 영역에 로드되어 있는 클래스 타입 객체를 가져옴")
    @Test
    void 리플렉션_클래스_정보_스캔() {
        // given
        Class<User> clazz = User.class;

        // when
        List<String> fieldNames = Arrays.stream(clazz.getDeclaredFields())
                .map(Field::getName)
                .toList();

        // then
        assertThat(fieldNames).contains("userId", "name");
    }

}
