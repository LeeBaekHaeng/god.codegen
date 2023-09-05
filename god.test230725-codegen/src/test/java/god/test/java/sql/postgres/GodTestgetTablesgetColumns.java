package god.test.java.sql.postgres;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * GodTestgetTablesgetColumns
 * 
 * @author 이백행
 * @since 2023-09-05
 */
@NoArgsConstructor
@Slf4j
public class GodTestgetTablesgetColumns {

    /**
     * test
     * 
     * @throws SQLException
     * @throws IOException
     */
    @Test
    public void test() throws SQLException, IOException {
        log.debug("test");

        FileUtils.cleanDirectory(new File("/test/public"));

        try (Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/com", "com", "com01")) {
            final DatabaseMetaData dmd = con.getMetaData();
            try (ResultSet tables = dmd.getTables(null, "com", null, new String[] { "TABLE", "VIEW" })) {
                int i = 1;
                while (tables.next()) {
                    final String tableSchem = tables.getString("TABLE_SCHEM");
                    final String tableName = tables.getString("TABLE_NAME");
                    final String remarks = tables.getString("REMARKS");

                    try (ResultSet columns = dmd.getColumns(null, tableSchem, tableName, null)) {
                        int j = 1;
                        while (columns.next()) {
                            final String columnName = columns.getString("COLUMN_NAME");
                            final String columnsRemarks = columns.getString("REMARKS");

                            if (log.isDebugEnabled()) {
                                log.debug("j={}", j);

                                log.debug("COLUMN_NAME={}", columnName);
                                log.debug("REMARKS={}", columnsRemarks);

                                log.debug("");
                            }

                            j++;
                        }
                    }

                    String pathname = "/test/" + tableSchem + "/" + tableName + "/" + tableName + " " + remarks
                            + ".sql";

                    String data = select(tableSchem, tableName, remarks);

                    if (log.isDebugEnabled()) {
                        log.debug("i={}", i);

                        log.debug("TABLE_SCHEM={}", tableSchem);
                        log.debug("TABLE_NAME={}", tableName);
                        log.debug("REMARKS={}", remarks);

                        log.debug("pathname={}", pathname);
                        log.debug("data={}", data);

                        log.debug("");
                    }

                    FileUtils.writeStringToFile(new File(pathname), data, StandardCharsets.UTF_8);

                    i++;
                }
            }
        }

        assertEquals("", "", "");
    }

    private String select(final String tableSchem, final String tableName, final String remarks) {
        StringBuffer sb = new StringBuffer();

        sb.append("select\n");

        sb.append("    a.*\n");

        sb.append("from\n");

        sb.append("    ");
        sb.append(tableSchem);
        sb.append(".");
        sb.append(tableName);
        sb.append(" a /* ");
        sb.append(remarks);
        sb.append(" */\n");

        sb.append("where 1 = 1\n");

        sb.append(";\n");

        return sb.toString();
    }

}
