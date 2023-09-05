package test2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import egovframework.dev.imp.codegen.template.model.Attribute;
import egovframework.dev.imp.codegen.template.model.DataModelContext;
import egovframework.dev.imp.codegen.template.model.Entity;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * CRUD 프로그램 자동 생성 기능
 * 
 * @author 이백행
 * @since 2023-09-05
 */
@NoArgsConstructor
@Slf4j
public class CRUD_프로그램_자동_생성_기능 {

    /**
     * models
     */
    private List<DataModelContext> models = new ArrayList<>();

    /**
     * test
     * 
     * @throws SQLException
     */
    @Test
    public void test() {
        log.debug("test");

        setModel();

        generate();

        assertEquals("", "", "");
    }

    private void setModel() {
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/com", "com", "com01")) {
            final DatabaseMetaData dmd = con.getMetaData();
            try (ResultSet tables = dmd.getTables(null, "com", null, new String[] { "TABLE", "VIEW" })) {
                while (tables.next()) {
                    final String tableSchem = tables.getString("TABLE_SCHEM");

                    final DataModelContext model = new DataModelContext();

                    final Entity entity = new Entity(tables.getString("TABLE_NAME"));
                    entity.setRemarks(tables.getString("REMARKS"));
                    model.setEntity(entity);

                    try (ResultSet columns = dmd.getColumns(null, tableSchem, entity.getName(), null)) {
                        final List<Attribute> attributes = new ArrayList<>();
                        while (columns.next()) {
                            final Attribute attribute = new Attribute(columns.getString("COLUMN_NAME"));
                            attribute.setRemarks(columns.getString("REMARKS"));
                            attributes.add(attribute);
                        }
                        model.setAttributes(attributes);
                    }

                    try (ResultSet columns = dmd.getPrimaryKeys(null, tableSchem, entity.getName())) {
                        final List<Attribute> primaryKeys = new ArrayList<>();
                        while (columns.next()) {
                            final String columnName = columns.getString("COLUMN_NAME");
                            for (final Attribute attribute : model.getAttributes()) {
                                if (columnName.equals(attribute.getName())) {
                                    attribute.setPrimaryKey(true);

                                    primaryKeys.add(attribute);
                                }
                            }
                        }
                        model.setPrimaryKeys(primaryKeys);
                    }

                    models.add(model);
                }
            }
        } catch (SQLException e) {
//            e.printStackTrace();
            log.error("SQLException");
            fail("SQLException");
        }
    }

    private void generate() {
        int i = 1;
        for (final DataModelContext model : models) {
            if (log.isDebugEnabled()) {
                log.debug("i={}", i);

                log.debug("getEntity");
                log.debug("getName={}", model.getEntity().getName());
                log.debug("getRemarks={}", model.getEntity().getRemarks());
                log.debug("");

                log.debug("getAttributes");
                int j = 1;
                for (final Attribute attribute : model.getAttributes()) {
                    log.debug("j={}", j);

                    log.debug("getName={}", attribute.getName());
                    log.debug("getRemarks={}", attribute.getRemarks());

                    log.debug("");

                    j++;
                }

                log.debug("getPrimaryKeys");
                int k = 1;
                for (final Attribute attribute : model.getPrimaryKeys()) {
                    log.debug("k={}", k);

                    log.debug("getName={}", attribute.getName());
                    log.debug("getRemarks={}", attribute.getRemarks());

                    log.debug("");

                    k++;
                }

                log.debug("");
            }

            i++;
        }
    }

}
