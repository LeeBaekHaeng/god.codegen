package egovframework.dev.imp.codegen.template.model;

/**
 * 
 * 
 * @author 이백행
 * @since 2023-08-03
 */
public class GodEntity extends DbModelElement {

    /**
     * REMARKS String => explanatory comment on the table
     */
    private String remarks;

    /**
     * information_schema.tables TABLE_COMMENT
     */
    private String tableComment;

    /**
     * GodEntity
     * 
     * @param name
     */
    public GodEntity(final String name) {
        super(name);
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(final String remarks) {
        this.remarks = remarks;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(final String tableComment) {
        this.tableComment = tableComment;
    }

}
