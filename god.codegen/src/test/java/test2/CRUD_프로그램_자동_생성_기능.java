package test2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import egovframework.dev.imp.codegen.template.model.Attribute;
import egovframework.dev.imp.codegen.template.model.DataModelContext;
import egovframework.dev.imp.codegen.template.model.EgovPackage;
import egovframework.dev.imp.codegen.template.model.Entity;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import operation.CrudCodeGen;

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
     * author
     */
    private String author = "이백행";

    /**
     * crud-com-4.1.0
     */
    private String eGovFrameTemplates = "eGovFrameTemplates/crud-com-4.1.0/";

    /**
     * models
     */
    private List<DataModelContext> dataModels = new ArrayList<>();

    /**
     * crudCodeGen
     */
    private CrudCodeGen crudCodeGen = new CrudCodeGen();

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
            try (ResultSet tables = dmd.getTables(null, "com", "comtcadministcode", new String[] { "TABLE", "VIEW" })) {
                while (tables.next()) {
                    final String tableSchem = tables.getString("TABLE_SCHEM");

                    final DataModelContext dataModel = new DataModelContext();

                    dataModel.setAuthor(author);

                    final Entity entity = new Entity(tables.getString("TABLE_NAME"));
                    entity.setTableName(entity.getName());
                    entity.setRemarks(tables.getString("REMARKS"));
                    dataModel.setEntity(entity);

                    try (ResultSet columns = dmd.getColumns(null, tableSchem, entity.getName(), null)) {
                        final List<Attribute> attributes = new ArrayList<>();
                        while (columns.next()) {
                            final Attribute attribute = new Attribute(columns.getString("COLUMN_NAME"));
                            attribute.setRemarks(columns.getString("REMARKS"));
                            attributes.add(attribute);
                        }
                        dataModel.setAttributes(attributes);
                    }

                    try (ResultSet columns = dmd.getPrimaryKeys(null, tableSchem, entity.getName())) {
                        final List<Attribute> primaryKeys = new ArrayList<>();
                        while (columns.next()) {
                            final String columnName = columns.getString("COLUMN_NAME");
                            for (final Attribute attribute : dataModel.getAttributes()) {
                                if (columnName.equals(attribute.getName())) {
                                    attribute.setPrimaryKey(true);

                                    primaryKeys.add(attribute);
                                }
                            }
                        }
                        dataModel.setPrimaryKeys(primaryKeys);
                    }

                    dataModel.setEgovPackage(new EgovPackage(null, null, null));

                    dataModels.add(dataModel);
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
        for (final DataModelContext dataModel : dataModels) {
            sql(dataModel);

            if (log.isDebugEnabled()) {
                log.debug("i={}", i);

                log.debug("getEntity");
                log.debug("getName={}", dataModel.getEntity().getName());
                log.debug("getRemarks={}", dataModel.getEntity().getRemarks());
                log.debug("");

                log.debug("getAttributes");
                int j = 1;
                for (final Attribute attribute : dataModel.getAttributes()) {
                    log.debug("j={}", j);

                    log.debug("getName={}", attribute.getName());
                    log.debug("getRemarks={}", attribute.getRemarks());

                    log.debug("");

                    j++;
                }

                log.debug("getPrimaryKeys");
                int k = 1;
                for (final Attribute attribute : dataModel.getPrimaryKeys()) {
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

    private void sql(final DataModelContext dataModel) {
//        final String templateFile = eGovFrameTemplates + "resource/pkg/sql.vm";
        final String templateFile = eGovFrameTemplates + "resource/pkg/sql2.vm";
        final String pathname = "/test/" + dataModel.getEntity().getName() + "/" + dataModel.getEntity().getName() + " "
                + dataModel.getEntity().getRemarks() + ".sql";
        writeStringToFile(dataModel, templateFile, pathname);
    }

    private void writeStringToFile(final DataModelContext dataModel, final String templateFile, final String pathname) {
        String data = null;

        try {
            data = crudCodeGen.generate(dataModel, templateFile);
        } catch (Exception e) {
//            e.printStackTrace();
            log.error("Exception generate");
            fail("Exception generate");
        }

        try {
            FileUtils.writeStringToFile(new File(pathname), data, StandardCharsets.UTF_8);
        } catch (IOException e) {
//            e.printStackTrace();
            log.error("IOException writeStringToFile");
            fail("IOException writeStringToFile");
        }
    }

}
