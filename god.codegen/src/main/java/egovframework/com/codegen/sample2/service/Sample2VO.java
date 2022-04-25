package egovframework.com.codegen.sample2.service;

/**
 * @Class Name : Sample2VO.java
 * @Description : Sample2 VO class
 * @Modification Information
 *
 * @author 코드생성팀 이백행
 * @since 2022-04-24
 * @version 1.0
 * @see
 * 
 *      Copyright (C) All right reserved.
 */
@SuppressWarnings("serial")
public class Sample2VO extends Sample2DefaultVO {

	/** ID */
	private String id;

	/** NAME */
	private String name;

	/** DESCRIPTION */
	private String description;

	/** USE_YN */
	private String useYn;

	/** REG_USER */
	private String regUser;

	/** ID 값읽기 */
	public String getId() {
		return this.id;
	}

	/** ID 값설정 */
	public void setId(String id) {
		this.id = id;
	}

	/** NAME 값읽기 */
	public String getName() {
		return this.name;
	}

	/** NAME 값설정 */
	public void setName(String name) {
		this.name = name;
	}

	/** DESCRIPTION 값읽기 */
	public String getDescription() {
		return this.description;
	}

	/** DESCRIPTION 값설정 */
	public void setDescription(String description) {
		this.description = description;
	}

	/** USE_YN 값읽기 */
	public String getUseYn() {
		return this.useYn;
	}

	/** USE_YN 값설정 */
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	/** REG_USER 값읽기 */
	public String getRegUser() {
		return this.regUser;
	}

	/** REG_USER 값설정 */
	public void setRegUser(String regUser) {
		this.regUser = regUser;
	}

}
