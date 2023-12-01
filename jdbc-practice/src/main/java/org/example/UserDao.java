package org.example;

import java.sql.SQLException;

public class UserDao {

    public void create(final User user) throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";

        jdbcTemplate.executeUpdate(sql, preparedStatement -> {
            preparedStatement.setString(1, user.userId());
            preparedStatement.setString(2, user.password());
            preparedStatement.setString(3, user.name());
            preparedStatement.setString(4, user.email());
        });
    }

    public User findByUserId(final String userId) throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        String sql = "SELECT userId, password, name, email FROM USERS WHERE userid = ?";
        return (User) jdbcTemplate.executeQuery(
                sql,
                pstmt -> pstmt.setString(1, userId),
                resultSet -> new User(
                        resultSet.getString("userId"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getString("email"))
        );
    }

}
