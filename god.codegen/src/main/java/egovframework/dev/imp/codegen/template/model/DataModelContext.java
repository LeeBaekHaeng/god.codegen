/*
 * Copyright 2008-2009 MOSPA(Ministry of Security and Public Administration).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.dev.imp.codegen.template.model;

import java.util.List;

/**
 * 
 * 데이터베이스 Context 클래스
 * <p>
 * <b>NOTE:</b> 데이터베이스 정보 및 테이블, 컬럼 정보를 담기위한 클래스
 * 
 * @author 개발환경 개발팀 이흥주
 * @since 2009.08.03
 * @version 1.0
 * @see
 *
 *      <pre>
 *  == 개정이력(Modification Information) ==
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.08.03  이흥주          최초 생성
 *
 *      </pre>
 */
public class DataModelContext {

	/** 데이터베이스 벤더 */
	private String vender;
	/** 데이터베이스 제품 명 */
	private String databaseProductName;
	/** 엔티티(테이블) 정보 */
	private Entity entity;
	/** 어트리뷰트(컬럼) 정보 */
	private List<Attribute> attributes;
	/** 기본키 컬럼 정보 */
	private List<Attribute> primaryKeys;

	/**
	 * 데이타베이스 제품명
	 * 
	 * @return
	 */
	public String getDatabaseProductName() {
		return databaseProductName;
	}

	/**
	 * 데이타베이스 제품명 세팅하기
	 * 
	 * @param databaseProductName
	 */
	public void setDatabaseProductName(String databaseProductName) {
		this.databaseProductName = databaseProductName;
	}

	/**
	 * 벤더 정보 가져오기
	 * 
	 * @return
	 */
	public String getVender() {
		return vender;
	}

	/**
	 * 벤더 정보 세팅하기
	 * 
	 * @param vender
	 */
	public void setVender(String vender) {
		this.vender = vender;
	}

	/**
	 * 기본키 목록 가져오기
	 * 
	 * @return
	 */
	public List<Attribute> getPrimaryKeys() {
		return primaryKeys;
	}

	/**
	 * 기본키 목록 세팅하기
	 * 
	 * @param primaryKeys
	 */
	public void setPrimaryKeys(List<Attribute> primaryKeys) {
		this.primaryKeys = primaryKeys;
	}

	/**
	 * 엔티티 가져오기
	 * 
	 * @return
	 */
	public Entity getEntity() {
		return entity;
	}

	/**
	 * 엔티티 세팅하기
	 * 
	 * @param entity
	 */
	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	/**
	 * 속성 목록 가져오기
	 * 
	 * @return
	 */
	public List<Attribute> getAttributes() {
		return attributes;
	}

	/**
	 * 속성 목록 세팅하기
	 * 
	 * @param attributes
	 */
	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	//

	public static final String VENDER_HSQLDB = "HSQLDB";
	public static final String VENDER_Oracle = "Oracle";
	public static final String VENDER_MySql = "MySql";

	private static final String PACKAGE_SERVICE_IMPL = "service.impl";
	private static final String PACKAGE_SERVICE = "service";
	private static final String PACKAGE_WEB = "web";

	//

	private String author;
	private String createDate;

	private String prefixPackage;

	private String voPackage;

	private String mapperPackage;

	private String daoPackage;

	private String servicePackage;

	private String implPackage;

	private String controllerPackage;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getPrefixPackage() {
		return prefixPackage;
	}

	public void setPrefixPackage(String prefixPackage) {
		this.prefixPackage = prefixPackage;
	}

	public String getVoPackage() {
		return voPackage;
	}

	public void setVoPackage(String voPackage) {
//		this.voPackage = voPackage;
		this.voPackage = this.prefixPackage + "." + voPackage + "." + PACKAGE_SERVICE;
	}

	public String getMapperPackage() {
		return mapperPackage;
	}

	public void setMapperPackage(String mapperPackage) {
//		this.mapperPackage = mapperPackage;
		this.mapperPackage = this.prefixPackage + "." + mapperPackage + "." + PACKAGE_SERVICE_IMPL;
	}

	public String getDaoPackage() {
		return daoPackage;
	}

	public void setDaoPackage(String daoPackage) {
//		this.daoPackage = daoPackage;
		this.daoPackage = this.prefixPackage + "." + daoPackage + "." + PACKAGE_SERVICE_IMPL;
	}

	public String getServicePackage() {
		return servicePackage;
	}

	public void setServicePackage(String servicePackage) {
//		this.servicePackage = servicePackage;
		this.servicePackage = this.prefixPackage + "." + servicePackage + "." + PACKAGE_SERVICE;
	}

	public String getImplPackage() {
		return implPackage;
	}

	public void setImplPackage(String implPackage) {
		this.implPackage = this.prefixPackage + "." + implPackage + "." + PACKAGE_SERVICE_IMPL;
	}

	public String getControllerPackage() {
		return controllerPackage;
	}

	public void setControllerPackage(String controllerPackage) {
//		this.controllerPackage = controllerPackage;
		this.controllerPackage = this.prefixPackage + "." + controllerPackage + "." + PACKAGE_WEB;
	}

}
