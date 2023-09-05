package god.test.java.sql.postgres;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * GodTestgetTableTypes
 * 
 * @author 이백행
 * @since 2023-09-04
 */
@NoArgsConstructor
@Slf4j
public class GodTestgetTableTypes {

    /**
     * test
     * 
     * @throws SQLException
     * @throws IOException
     */
    @Test
    public void test() throws SQLException, IOException {
        log.debug("test");

        try (Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/com", "com", "com01")) {
            final DatabaseMetaData dmd = con.getMetaData();

            try (ResultSet rs = dmd.getTableTypes()) {
                int i = 1;
                while (rs.next()) {
                    final String tableType = rs.getString("TABLE_TYPE");

                    if (log.isDebugEnabled()) {
                        log.debug("i={}", i);

                        log.debug("TABLE_TYPE={}", tableType);

                        log.debug("");
                    }

                    i++;
                }
            }

        }

        assertEquals("", "", "");
    }

}
