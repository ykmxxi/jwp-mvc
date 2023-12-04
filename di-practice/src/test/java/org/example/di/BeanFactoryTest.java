package org.example.di;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.example.annotation.Controller;
import org.example.annotation.Service;
import org.example.controller.UserController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class BeanFactoryTest {

    private static final Logger logger = LoggerFactory.getLogger(BeanFactoryTest.class);

    private Reflections reflections;
    private BeanFactory beanFactory;

    @BeforeEach
    void setUp() {
        reflections = new Reflections("org.example");
        Set<Class<?>> preInstantiatedClazz = getTypesAnnotatedWith(Controller.class, Service.class);
        beanFactory = new BeanFactory(preInstantiatedClazz);
    }

    private Set<Class<?>> getTypesAnnotatedWith(final Class<? extends Annotation>... annotations) {
        return Arrays.stream(annotations)
                .flatMap(annotation -> reflections.getTypesAnnotatedWith(annotation)
                        .stream())
                .collect(Collectors.toSet());
    }

    @Test
    void 생성자_주입_테스트() {
        // given
        Class<UserController> requiredType = UserController.class;

        // when
        UserController userController = beanFactory.getBean(requiredType);

        // then
        assertThat(userController).isNotNull();
        logger.info("userController : [{}]", userController);
        assertThat(userController.getUserService()).isNotNull();
        logger.info("userService : [{}]", userController.getUserService());
    }

}
