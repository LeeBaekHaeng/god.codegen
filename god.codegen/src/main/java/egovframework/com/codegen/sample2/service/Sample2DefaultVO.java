package egovframework.com.codegen.sample2.service;

import java.util.List;

import egovframework.com.cmm.ComDefaultVO;

/**
 * @Class Name : Sample2DefaultVO.java
 * @Description : Sample2 DefaultVO class
 * @Modification Information
 *
 * @author 코드생성팀 이백행
 * @since 2022-04-24
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Sample2DefaultVO extends ComDefaultVO {

    /** ID */
    private List<String> ids;
    
    /** NAME */
    private List<String> names;
    
    /** DESCRIPTION */
    private List<String> descriptions;
    
    /** USE_YN */
    private List<String> useYns;
    
    /** REG_USER */
    private List<String> regUsers;
    
    public List<String> getIds() {
        return this.ids;
    }
    
    public void setIds(List<String> ids) {
        this.ids = ids;
    }
    
    public List<String> getNames() {
        return this.names;
    }
    
    public void setNames(List<String> names) {
        this.names = names;
    }
    
    public List<String> getDescriptions() {
        return this.descriptions;
    }
    
    public void setDescriptions(List<String> descriptions) {
        this.descriptions = descriptions;
    }
    
    public List<String> getUseYns() {
        return this.useYns;
    }
    
    public void setUseYns(List<String> useYns) {
        this.useYns = useYns;
    }
    
    public List<String> getRegUsers() {
        return this.regUsers;
    }
    
    public void setRegUsers(List<String> regUsers) {
        this.regUsers = regUsers;
    }
    
}
