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
 * GodTestgetSchemasgetCatalogs
 * 
 * @author 이백행
 * @since 2023-08-31
 */
@NoArgsConstructor
@Slf4j
public class GodTestgetSchemasgetCatalogs {

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
            try (ResultSet rs = dmd.getSchemas()) {
                int i = 1;
                while (rs.next()) {
                    final String tableSchem = rs.getString("TABLE_SCHEM");
                    final String tableCatalog = rs.getString("TABLE_CATALOG");

                    if (log.isDebugEnabled()) {
                        log.debug("i={}", i);

                        log.debug("TABLE_SCHEM={}", tableSchem);
                        log.debug("TABLE_CATALOG={}", tableCatalog);

                        log.debug("");
                    }

                    i++;
                }
            }

            try (ResultSet rs = dmd.getCatalogs()) {
                int i = 1;
                while (rs.next()) {
                    final String tableCat = rs.getString("TABLE_CAT");

                    if (log.isDebugEnabled()) {
                        log.debug("i={}", i);

                        log.debug("TABLE_CAT={}", tableCat);

                        log.debug("");
                    }

                    i++;
                }
            }
        }

        assertEquals("", "", "");
    }

}
