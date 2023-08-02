package god.test.java.sql;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 컬럼 VO
 * 
 * @author 이백행
 * @since 2023-08-02
 */
@AllArgsConstructor
@Builder
@Data
public class ColumnsVO {

    /**
     * TABLE_CAT
     */
    private String tableCat;

    /**
     * TABLE_SCHEM
     */
    private String tableSchem;

    /**
     * TABLE_NAME
     */
    private String tableName;

    /**
     * COLUMN_NAME
     */
    private String columnName;

    /**
     * DATA_TYPE
     */
    private int dataType;

    /**
     * TYPE_NAME
     */
    private String typeName;

    /**
     * COLUMN_SIZE
     */
    private int columnSize;

    /**
     * BUFFER_LENGTH
     */
    private int bufferLength;

    /**
     * DECIMAL_DIGITS
     */
    private int decimalDigits;

    /**
     * NUM_PREC_RADIX
     */
    private int numPrecRadix;

    /**
     * NULLABLE
     */
    private int nullable;

    /**
     * REMARKS
     */
    private String remarks;

    /**
     * COLUMN_DEF
     */
    private String columnDef;

    /**
     * SQL_DATA_TYPE
     */
    private int sqlDataType;

    /**
     * SQL_DATETIME_SUB
     */
    private int sqlDatetimeSub;

    /**
     * CHAR_OCTET_LENGTH
     */
    private int charOctetLength;

    /**
     * ORDINAL_POSITION
     */
    private int ordinalPosition;

    /**
     * IS_NULLABLE
     */
    private String sisNullable;

    /**
     * SCOPE_CATALOG
     */
    private String scopeCatalog;

    /**
     * SCOPE_SCHEMA
     */
    private String scopeSchema;

    /**
     * SCOPE_TABLE
     */
    private String scopeTable;

    /**
     * SOURCE_DATA_TYPE
     */
    private int sourceDataType;

    /**
     * IS_AUTOINCREMENT
     */
    private String sisAutoincrement;

}
