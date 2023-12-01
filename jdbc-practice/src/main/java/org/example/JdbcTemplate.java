package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplate {

    public void executeUpdate(final String sql, final PreparedStatementSetter pss) throws SQLException {

        try (
                Connection con = ConnectionManager.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql)
        ) {
            pss.setPreparedStatement(pstmt);

            pstmt.executeUpdate();
        }
    }

    public Object executeQuery(
            final String sql,
            final PreparedStatementSetter pss,
            final RowMapper rowMapper
    ) throws SQLException {
        try (
                Connection con = ConnectionManager.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql)
        ) {
            pss.setPreparedStatement(pstmt);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rowMapper.mapRow(rs);
                }
                return null;
            }
        }
    }

}
