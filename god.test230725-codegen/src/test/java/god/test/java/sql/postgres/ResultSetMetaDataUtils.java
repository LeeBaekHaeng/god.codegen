package god.test.java.sql.postgres;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.egovframe.rte.psl.dataaccess.util.CamelUtil;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * GodTestResultSetMetaDatagetIndexInfo
 * 
 * @author 이백행
 * @since 2023-09-05
 */
@NoArgsConstructor
@Slf4j
public class ResultSetMetaDataUtils {

    public static void debug(final ResultSetMetaData resultSetMetaData) throws SQLException {
        final int columnCount = resultSetMetaData.getColumnCount();
        log.debug("columnCount={}", columnCount);

        final StringBuffer sb = new StringBuffer(1600);
        final StringBuffer sb2 = new StringBuffer(1600);

        for (int column = 1; column < columnCount; column++) {
            if (log.isDebugEnabled()) {
                log.debug("column={}", column);

                final String columnLabel = resultSetMetaData.getColumnLabel(column);
//                final String columnLabel = resultSetMetaData.getColumnName(column);
//                final String columnLabel = resultSetMetaData.getSchemaName(column);
                final String columnLabelCcName = CamelUtil.convert2CamelCase(columnLabel);

                final int columnType = resultSetMetaData.getColumnType(column);
                final String columnTypeName = resultSetMetaData.getColumnTypeName(column);

                log.debug("columnLabel={}", columnLabel);
                log.debug("columnType={}", columnType);
                log.debug("columnTypeName={}", columnTypeName);
                log.debug("");

                sb.append("final String " + columnLabelCcName + " = rs.getString(\"" + columnLabel + "\");\n");

                sb2.append("log.debug(\"" + columnLabel + "={}\", " + columnLabelCcName + ");\n");
            }
        }

        if (log.isDebugEnabled()) {
            log.debug(sb.toString());
            log.debug(sb2.toString());
        }
    }

}
