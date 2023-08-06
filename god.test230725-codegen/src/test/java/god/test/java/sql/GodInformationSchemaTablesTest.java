package god.test.java.sql;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.egovframe.rte.psl.dataaccess.util.CamelUtil;
import org.junit.Test;

import egovframework.dev.imp.codegen.template.model.DataModelContext;
import egovframework.dev.imp.codegen.template.model.Entity;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 정보 스키마 TABLES 테이블
 * 
 * Information Schema TABLES Table
 * 
 * https://mariadb.com/kb/en/information-schema-tables-table/
 * 
 * @author 이백행
 * @since 2023-08-03
 */
@NoArgsConstructor
@Slf4j
public class GodInformationSchemaTablesTest {

    /**
     * GodTestJavaSql
     */
    private final GodTestJavaSql godTestJavaSql = new GodTestJavaSql();

    /**
     * test
     */
    @Test
    public void test() {
        log.debug("test");

        final StringBuffer sb = new StringBuffer(1600);
// @formatter:off
        sb.append("SELECT\n")
//          .append("    a.*\n")
          .append("    a.table_catalog,\n")
          .append("    a.table_schema,\n")
          .append("    a.table_name,\n")
          .append("    a.table_type,\n")
          .append("    a.engine,\n")
          .append("    a.version,\n")
          .append("    a.row_format,\n")
          .append("    a.table_rows,\n")
          .append("    a.avg_row_length,\n")
          .append("    a.data_length,\n")
          .append("    a.max_data_length,\n")
          .append("    a.index_length,\n")
          .append("    a.data_free,\n")
          .append("    a.auto_increment,\n")
          .append("    a.create_time,\n")
          .append("    a.update_time,\n")
          .append("    a.check_time,\n")
          .append("    a.table_collation,\n")
          .append("    a.checksum,\n")
          .append("    a.create_options,\n")
          .append("    a.table_comment\n")
          .append("FROM information_schema.tables a\n")
          .append("WHERE 1 = 1\n")
          .append("    AND a.table_schema = ?\n")
          .append("ORDER BY a.TABLE_NAME\n");
// @formatter:on
        final String sql = sb.toString();
        log.debug("sql={}", sql);

        try (Connection con = godTestJavaSql.getConnection()) {
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, "com");
                try (ResultSet rs = pstmt.executeQuery()) {
                    final ResultSetMetaData resultSetMetaData = rs.getMetaData();
                    resultSetMetaData(resultSetMetaData);
                    debug(rs);
                } catch (SQLException e) {
//                    e.printStackTrace();
                    log.error("SQLException executeQuery");
                }
            } catch (SQLException e) {
//                e.printStackTrace();
                log.error("SQLException prepareStatement");
            }
        } catch (SQLException e) {
//            e.printStackTrace();
            log.error("SQLException getConnection");
        }

        assertEquals("", "", "");
    }

    private void resultSetMetaData(final ResultSetMetaData resultSetMetaData) throws SQLException {
        final int columnCount = resultSetMetaData.getColumnCount();
        log.debug("columnCount={}", columnCount);

        final StringBuffer sb = new StringBuffer(1600);
        final StringBuffer sb2 = new StringBuffer(1600);
        final StringBuffer sb3 = new StringBuffer(1600);

        for (int column = 1; column < columnCount; column++) {
            final String columnLabel = resultSetMetaData.getColumnLabel(column);
//            final String columnLabel = resultSetMetaData.getColumnName(column);
//            final String columnLabel = resultSetMetaData.getSchemaName(column);
            final String columnLabelCcName = CamelUtil.convert2CamelCase(columnLabel);
            final String columnLabelLcName = getColumnLabelLcName(columnLabel);

            final int columnType = resultSetMetaData.getColumnType(column);
            final String columnTypeName = resultSetMetaData.getColumnTypeName(column);

            if (columnType == 4 || columnType == 5 || columnType == -5) {
//                sb.append("final int " + columnLabelCcName + " = rs.getInt(\"" + columnLabel + "\");\n");
                sb.append("final long " + columnLabelCcName + " = rs.getLong(\"" + columnLabel + "\");\n");
            } else {
                sb.append("final String " + columnLabelCcName + " = rs.getString(\"" + columnLabel + "\");\n");
            }

            sb2.append("log.debug(\"" + columnLabel + "={}\", " + columnLabelCcName + ");\n");

            sb3.append("          .append(\"    a.");
            sb3.append(columnLabelLcName);
            sb3.append(",\\n\")\n");

            if (log.isDebugEnabled()) {
                log.debug("column={}", column);

                log.debug("columnLabel={}", columnLabel);
                log.debug("columnType={}", columnType);
                log.debug("columnTypeName={}", columnTypeName);
                log.debug("");
            }
        }

        if (log.isDebugEnabled()) {
            log.debug(sb.toString());
            log.debug(sb2.toString());
            log.debug(sb3.toString());
        }
    }

    private String getColumnLabelLcName(final String columnLabel) {
        return columnLabel.toLowerCase(Locale.getDefault());
    }

    private void debug(final ResultSet rs) throws SQLException {
        final List<DataModelContext> models = new ArrayList<>();

        int i = 1;
        while (rs.next()) {
//            final String tableCatalog = rs.getString("TABLE_CATALOG");
            final String tableSchema = rs.getString("TABLE_SCHEMA");
            final String tableName = rs.getString("TABLE_NAME");
//            final String tableType = rs.getString("TABLE_TYPE");
//            final String engine = rs.getString("ENGINE");
//            final long version = rs.getLong("VERSION");
//            final String rowFormat = rs.getString("ROW_FORMAT");
//            final long tableRows = rs.getLong("TABLE_ROWS");
//            final long avgRowLength = rs.getLong("AVG_ROW_LENGTH");
//            final long dataLength = rs.getLong("DATA_LENGTH");
//            final long maxDataLength = rs.getLong("MAX_DATA_LENGTH");
//            final long indexLength = rs.getLong("INDEX_LENGTH");
//            final long dataFree = rs.getLong("DATA_FREE");
//            final long autoIncrement = rs.getLong("AUTO_INCREMENT");
//            final String createTime = rs.getString("CREATE_TIME");
//            final String updateTime = rs.getString("UPDATE_TIME");
//            final String checkTime = rs.getString("CHECK_TIME");
//            final String tableCollation = rs.getString("TABLE_COLLATION");
//            final long checksum = rs.getLong("CHECKSUM");
//            final String createOptions = rs.getString("CREATE_OPTIONS");
            final String tableComment = rs.getString("TABLE_COMMENT");
//            final long maxIndexLength = rs.getLong("MAX_INDEX_LENGTH");

            final Entity entity = new Entity(tableName);
            setEntity(tableComment, entity);
            final DataModelContext model = new DataModelContext();
            model.setEntity(entity);
            models.add(model);

            if (log.isDebugEnabled()) {
                log.debug("i={}", i);

//                log.debug("TABLE_CATALOG={}", tableCatalog);
                log.debug("TABLE_SCHEMA={}", tableSchema);
                log.debug("TABLE_NAME={}", tableName);
//                log.debug("TABLE_TYPE={}", tableType);
//                log.debug("ENGINE={}", engine);
//                log.debug("VERSION={}", version);
//                log.debug("ROW_FORMAT={}", rowFormat);
//                log.debug("TABLE_ROWS={}", tableRows);
//                log.debug("AVG_ROW_LENGTH={}", avgRowLength);
//                log.debug("DATA_LENGTH={}", dataLength);
//                log.debug("MAX_DATA_LENGTH={}", maxDataLength);
//                log.debug("INDEX_LENGTH={}", indexLength);
//                log.debug("DATA_FREE={}", dataFree);
//                log.debug("AUTO_INCREMENT={}", autoIncrement);
//                log.debug("CREATE_TIME={}", createTime);
//                log.debug("UPDATE_TIME={}", updateTime);
//                log.debug("CHECK_TIME={}", checkTime);
//                log.debug("TABLE_COLLATION={}", tableCollation);
//                log.debug("CHECKSUM={}", checksum);
//                log.debug("CREATE_OPTIONS={}", createOptions);
                log.debug("TABLE_COMMENT={}", tableComment);
//                log.debug("MAX_INDEX_LENGTH={}", maxIndexLength);
                log.debug("");
            }

            i++;
        }

        log.debug("models={}", models);
        i = 1;
        for (final DataModelContext model : models) {
            if (log.isDebugEnabled()) {
                log.debug("i={}", i);
                log.debug("model={}", model);
                final Entity entity = model.getEntity();
                debug(entity);
                log.debug("");
            }

            i++;
        }
    }

    private void setEntity(final String tableComment, final Entity entity) {
        entity.setRemarks(tableComment);
        entity.setTableComment(tableComment);
    }

    private void debug(final Entity entity) {
        if (log.isDebugEnabled()) {
            log.debug("entity={}", entity);

            log.debug("getName={}", entity.getName());
            log.debug("getUcName={}", entity.getUcName());
            log.debug("getLcName={}", entity.getLcName());
            log.debug("getCcName={}", entity.getCcName());
            log.debug("getPcName={}", entity.getPcName());

            log.debug("getRemarks={}", entity.getRemarks());

            log.debug("getTableComment={}", entity.getTableComment());
        }
    }

}
