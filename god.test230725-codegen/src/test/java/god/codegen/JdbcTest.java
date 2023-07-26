package god.codegen;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

            final String catalog = con.getCatalog();
            final String schemaPattern = con.getSchema();
            final String tableNamePattern = "%%";
//            final String tableNamePattern = "%com%";
//            final String tableNamePattern = "comtcadministcode";
//            final String tableNamePattern = "COMTCADMINISTCODE";
            final String[] types = null;

            if (log.isDebugEnabled()) {
                log.debug("con={}", con);
                log.debug("catalog={}", catalog);
                log.debug("schemaPattern={}", schemaPattern);
            }

            voidTables(metaData, catalog, schemaPattern, tableNamePattern, types);

//            ResultSet columns = metaData.getColumns(catalog, schemaPattern, tableNamePattern, columnNamePattern);
//
//            ResultSet primaryKeys = metaData.getPrimaryKeys(catalog, schema, table);
        } catch (SQLException e) {
            log.error("SQLException getConnection");
        }

        assertEquals("", "", "");
    }

    private void debug(final DatabaseMetaData metaData) throws SQLException {
        if (log.isDebugEnabled()) {
            log.debug("getDatabaseProductName={}", metaData.getDatabaseProductName());
            log.debug("getDatabaseProductVersion={}", metaData.getDatabaseProductVersion());
        }
    }

    private void voidTables(final DatabaseMetaData metaData, final String catalog, final String schemaPattern,
            final String tableNamePattern, final String... types) {
        try (ResultSet tables = metaData.getTables(catalog, schemaPattern, tableNamePattern, types)) {
            while (tables.next()) {
                if (log.isDebugEnabled()) {
                    log.debug("TABLE_NAME={}", tables.getString("TABLE_NAME"));
                }
            }
        } catch (SQLException e) {
            log.error("SQLException getTables");
        }
    }

}
