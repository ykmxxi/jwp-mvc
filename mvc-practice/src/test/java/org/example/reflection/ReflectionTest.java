package org.example.reflection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
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
        // given
        Reflections reflections = new Reflections("org.example");
        Set<Class<?>> beans = new HashSet<>();

        // when
        beans.addAll(reflections.getTypesAnnotatedWith(Controller.class));

        // then
        logger.info("beans: {}", beans);
        assertThat(beans.contains(HomeController.class)).isTrue();
        assertThat(beans.contains(MemberController.class)).isTrue();
    }

    @DisplayName("리플렉션으로 @Service 애노테이션이 있는 모든 클래스를 찾기")
    @Test
    void 리플렉션_서비스_스캔() {
        // given
        Reflections reflections = new Reflections("org.example");
        Set<Class<?>> beans = new HashSet<>();

        // when
        beans.addAll(reflections.getTypesAnnotatedWith(Service.class));

        // then
        logger.info("beans: {}", beans);
        assertThat(beans.contains(HomeService.class)).isTrue();
    }

}
