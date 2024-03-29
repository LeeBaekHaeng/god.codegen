package god.codegen;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

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
     * test
     */
    @Test
    public void test() {
        log.debug("test");

//      String url = "jdbc:log4jdbc:mysql://127.0.0.1:3306/com";
        final String url = "jdbc:mysql://127.0.0.1:3306/com?useInformationSchema=true";
        final String user = "com";
        final String password = "com01";

//        final String catalog = null;
        final String catalog = "com";

        final String schemaPattern = null;
//        final String schemaPattern = "%%";

        final String tableNamePattern = null;
//        final String tableNamePattern = "%%";
//        final String tableNamePattern = "%com%";
//        final String tableNamePattern = "comtcadministcode"; // 행정코드
//        final String tableNamePattern = "COMTCADMINISTCODE";

        final String[] types = null;
//        final String[] types = { "TABLE", "VIEW" };

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            final DatabaseMetaData databaseMetaData = con.getMetaData();
            debug(con, databaseMetaData);
            debug(databaseMetaData, catalog, schemaPattern, tableNamePattern, types);
        } catch (SQLException e) {
//            e.printStackTrace();
            log.error("SQLException getConnection");
        }

        assertEquals("", "", "");
    }

    private void debug(final Connection con, final DatabaseMetaData databaseMetaData) throws SQLException {
        if (log.isDebugEnabled()) {
            // con
            log.debug("con={}", con);
            log.debug("catalog={}", con.getCatalog());
            log.debug("schemaPattern={}", con.getSchema());

            // metaData
            log.debug("databaseMetaData={}", databaseMetaData);
            log.debug("getDatabaseProductName={}", databaseMetaData.getDatabaseProductName());
            log.debug("getDatabaseProductVersion={}", databaseMetaData.getDatabaseProductVersion());
        }
    }

    private void debug(final DatabaseMetaData databaseMetaData, final String catalog, final String schemaPattern,
            final String tableNamePattern, final String... types) throws SQLException {
        if (log.isDebugEnabled()) {
            log.debug("catalog={}", catalog);
            log.debug("schemaPattern={}", schemaPattern);
            log.debug("tableNamePattern={}", tableNamePattern);
            log.debug("types={}", Arrays.toString(types));
        }
        try (ResultSet tables = databaseMetaData.getTables(catalog, schemaPattern, tableNamePattern, types)) {
            tables(tables);
        } catch (SQLException e) {
//            e.printStackTrace();
            log.error("SQLException getTables");
        }
    }

    private void tables(final ResultSet rs) throws SQLException {
        int i = 1;
        while (rs.next()) {
            final String tableCat = rs.getString("TABLE_CAT");
            final String tableSchem = rs.getString("TABLE_SCHEM");
            final String tableName = rs.getString("TABLE_NAME");
            final String tableType = rs.getString("TABLE_TYPE");
            final String remarks = rs.getString("REMARKS");
            final String typeCat = rs.getString("TYPE_CAT");
            final String typeSchem = rs.getString("TYPE_SCHEM");
            final String typeName = rs.getString("TYPE_NAME");
            final String selfReferencingColName = rs.getString("SELF_REFERENCING_COL_NAME");

            if (log.isDebugEnabled()) {
                log.debug("i={}", i);

                log.debug("TABLE_CAT={}", tableCat);
                log.debug("TABLE_SCHEM={}", tableSchem);
                log.debug("TABLE_NAME={}", tableName);
                log.debug("TABLE_TYPE={}", tableType);
                log.debug("REMARKS={}", remarks);
                log.debug("TYPE_CAT={}", typeCat);
                log.debug("TYPE_SCHEM={}", typeSchem);
                log.debug("TYPE_NAME={}", typeName);
                log.debug("SELF_REFERENCING_COL_NAME={}", selfReferencingColName);
                log.debug("");
            }

            i++;
        }
    }

}
