package god.codegen;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import org.junit.Test;

import egovframework.dev.imp.codegen.template.model.DataModelContext;
import egovframework.dev.imp.codegen.template.model.Entity;
import egovframework.dev.imp.codegen.template.model.GodEntity;
import god.test.java.sql.GodTestJavaSql;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 테이블 가져와서 set DataModelContext
 * 
 * @author 이백행
 * @since 2023-08-02
 */
@NoArgsConstructor
@Slf4j
public class GodTestGetTablesToDataModelContext {

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

//        final String catalog = null;
        final String catalog = "com";

        final String schemaPattern = null;
//        final String schemaPattern = "%%";

        final String tableNamePattern = null;
//        final String tableNamePattern = "%%";
//        final String tableNamePattern = "%com%";
//        final String tableNamePattern = "comtcadministcode"; // 행정코드
//        final String tableNamePattern = "COMTCADMINISTCODE"; // 행정코드

        final String[] types = null;
//        final String[] types = { "TABLE", "VIEW" };

        try (Connection con = godTestJavaSql.getConnection()) {
            final DatabaseMetaData databaseMetaData = con.getMetaData();
            godTestJavaSql.debug(con, databaseMetaData);
            tables(databaseMetaData, catalog, schemaPattern, tableNamePattern, types);
        } catch (SQLException e) {
//            e.printStackTrace();
            log.error("SQLException getConnection");
        }

        assertEquals("", "", "");
    }

    private void tables(final DatabaseMetaData databaseMetaData, final String catalog, final String schemaPattern,
            final String tableNamePattern, final String[] types) throws SQLException {
        if (log.isDebugEnabled()) {
            log.debug("catalog={}", catalog);
            log.debug("schemaPattern={}", schemaPattern);
            log.debug("tableNamePattern={}", tableNamePattern);
            log.debug("types={}", Arrays.toString(types));
        }
        try (ResultSet rs = databaseMetaData.getTables(catalog, schemaPattern, tableNamePattern, types)) {
            tables(rs);
        } catch (SQLException e) {
//            e.printStackTrace();
            log.error("SQLException getTables");
        }
    }

    private void tables(final ResultSet rs) throws SQLException {
        DataModelContext model = new DataModelContext();

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

            Entity entity = new Entity(tableName);
            entity.setRemarks(remarks);
            model.setEntity(entity);

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

                log.debug("entity={}", entity);
                log.debug("getName={}", entity.getName());
                log.debug("getUcName={}", entity.getUcName());
                log.debug("getLcName={}", entity.getLcName());
                log.debug("getCcName={}", entity.getCcName());
                log.debug("getPcName={}", entity.getPcName());

                log.debug("getRemarks={}", entity.getRemarks());
                log.debug("");

                log.debug("getEntity={}", model.getEntity());
                log.debug("getName={}", model.getEntity().getName());
                log.debug("getUcName={}", model.getEntity().getUcName());
                log.debug("getLcName={}", model.getEntity().getLcName());
                log.debug("getCcName={}", model.getEntity().getCcName());
                log.debug("getPcName={}", model.getEntity().getPcName());

                log.debug("getRemarks={}", ((GodEntity) model.getEntity()).getRemarks());
                log.debug("");
            }

            i++;
        }
    }

}
