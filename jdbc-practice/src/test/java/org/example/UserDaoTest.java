package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

class UserDaoTest {

    @BeforeEach
    void setUp() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("db_schema.sql"));
        DatabasePopulatorUtils.execute(populator, ConnectionManager.getDataSource());
    }

    @Test
    void 회원_생성() throws SQLException {
        // given
        UserDao userDao = new UserDao();
        userDao.create(new User("ykmxxi", "password", "name", "a@eamil.com"));

        // when
        User findUser = userDao.findByUserId("ykmxxi");

        // then
        assertThat(findUser).extracting("userId").isEqualTo("ykmxxi");
        assertThat(findUser).extracting("name").isEqualTo("name");
    }

}
