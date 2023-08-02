package egovframework.dev.imp.codegen.template.model;

public class GodEntity extends Entity {

    /**
     * REMARKS String => explanatory comment on the table
     */
    private String remarks;

    public GodEntity(String name) {
        super(name);
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
