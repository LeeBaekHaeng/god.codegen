package egovframework.com.codegen.sample2.service;

import java.util.List;

import egovframework.com.cmm.ComDefaultVO;

/**
 * @Class Name : Sample2DefaultVO.java
 * @Description : Sample2 Default VO class
 * @Modification Information
 *
 * @author 코드생성팀 이백행
 * @since 2022-04-24
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@SuppressWarnings("serial")
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

	/** ID 값읽기 */
	public List<String> getIds() {
		return this.ids;
	}

	/** ID 값설정 */
	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	/** NAME 값읽기 */
	public List<String> getNames() {
		return this.names;
	}

	/** NAME 값설정 */
	public void setNames(List<String> names) {
		this.names = names;
	}

	/** DESCRIPTION 값읽기 */
	public List<String> getDescriptions() {
		return this.descriptions;
	}

	/** DESCRIPTION 값설정 */
	public void setDescriptions(List<String> descriptions) {
		this.descriptions = descriptions;
	}

	/** USE_YN 값읽기 */
	public List<String> getUseYns() {
		return this.useYns;
	}

	/** USE_YN 값설정 */
	public void setUseYns(List<String> useYns) {
		this.useYns = useYns;
	}

	/** REG_USER 값읽기 */
	public List<String> getRegUsers() {
		return this.regUsers;
	}

	/** REG_USER 값설정 */
	public void setRegUsers(List<String> regUsers) {
		this.regUsers = regUsers;
	}

}
