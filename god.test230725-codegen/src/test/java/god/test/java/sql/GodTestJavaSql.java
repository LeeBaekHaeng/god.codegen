package god.test.java.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * GodTestJavaSql
 * 
 * @author 이백행
 * @since 2023-07-27
 */
@NoArgsConstructor
@Slf4j
public class GodTestJavaSql {

    /**
     * 연결하기
     * 
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
//      String url = "jdbc:log4jdbc:mysql://127.0.0.1:3306/com";
        final String url = "jdbc:mysql://127.0.0.1:3306/com?useInformationSchema=true";
        final String user = "com";
        final String password = "com01";

        return DriverManager.getConnection(url, user, password);
    }

    /**
     * Connection, DatabaseMetaData debug
     * 
     * @param con
     * @param databaseMetaData
     * @throws SQLException
     */
    public void debug(final Connection con, final DatabaseMetaData databaseMetaData) throws SQLException {
        if (log.isDebugEnabled()) {
            log.debug("Connection, DatabaseMetaData debug");

            // con
            log.debug("con={}", con);
            log.debug("getCatalog={}", con.getCatalog());
            log.debug("getSchema={}", con.getSchema());

            // databaseMetaData
            log.debug("databaseMetaData={}", databaseMetaData);
            log.debug("getDatabaseProductName={}", databaseMetaData.getDatabaseProductName());
            log.debug("getDatabaseProductVersion={}", databaseMetaData.getDatabaseProductVersion());
        }
    }

}
