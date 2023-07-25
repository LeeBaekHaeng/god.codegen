package god.codegen;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * JdbcTest
 * 
 * @author 이백행
 * @since 2023-07-25
 */
@NoArgsConstructor
@Slf4j
public class JdbcTest {

    /**
     * 
     */
    @Test
    public void test() {
        log.debug("test");

//      String url = "jdbc:log4jdbc:mysql://127.0.0.1:3306/com";
        final String url = "jdbc:mysql://127.0.0.1:3306/com?useInformationSchema=true";
        final String user = "com";
        final String password = "com01";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            final DatabaseMetaData metaData = con.getMetaData();
            debug(metaData);

            if (log.isDebugEnabled()) {
                log.debug("con={}", con);
                log.debug("getCatalog={}", con.getCatalog());
                log.debug("getSchema={}", con.getSchema());
            }

//            ResultSet tables = metaData.getTables(catalog, schemaPattern, tableNamePattern, types);
//
//            ResultSet columns = metaData.getColumns(catalog, schemaPattern, tableNamePattern, columnNamePattern);
//
//            ResultSet primaryKeys = metaData.getPrimaryKeys(catalog, schema, table);
        } catch (SQLException e) {
            log.error("getConnection SQLException");
        }

        assertEquals("", "", "");
    }

    private void debug(final DatabaseMetaData metaData) throws SQLException {
        if (log.isDebugEnabled()) {
            log.debug("getDatabaseProductName={}", metaData.getDatabaseProductName());
            log.debug("getDatabaseProductVersion={}", metaData.getDatabaseProductVersion());
        }
    }

}
