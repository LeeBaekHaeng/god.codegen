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

/**
 * 
 * 퐅더 정보 클래스
 * <p>
 * <b>NOTE:</b> 폴더 정보를 담기위한 모델 클래스
 * 
 * @author 이백횅
 * @since 2022.04.21
 * @version 1.0
 * @see
 *
 *      <pre>
 *  == 개정이력(Modification Information) ==
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2022.04.21  이백행          최초 생성
 *
 *      </pre>
 */
public class Folder {

	public Folder(String egovPackageName1, String egovPackageName2, String egovPackageName3, String entityPcName) {
		String smj = (egovPackageName1 + "." + egovPackageName2 + "." + egovPackageName3).replaceAll("\\.", "/");
		String smr = (egovPackageName1.replaceFirst("\\.", ".mapper.") + "." + egovPackageName2 + "."
				+ egovPackageName3).replaceAll("\\.", "/") + "/";
		String sqlmap = (egovPackageName1.replaceFirst("\\.", ".sqlmap.") + "." + egovPackageName2 + "."
				+ egovPackageName3).replaceAll("\\.", "/") + "/";

		String srcMainJava = "src/main/java/";
		String srcMainResources = "src/main/resources/";
		String srcMainWebapp = "src/main/webapp/";

		String service = srcMainJava + smj + "/service/";
		String serviceImpl = srcMainJava + smj + "/service/impl/";
		String web = srcMainJava + smj + "/web/";

		// DataAccess
		// TODO 이백행 mysql
		sqlMapFolder = srcMainResources + sqlmap + entityPcName + "_SQL_mysql.xml";
		mapperFolder = srcMainResources + smr + entityPcName + "_SQL_mysql.xml"; // TODO 이백행 mysql
		daoPackageFolder = serviceImpl + entityPcName + "DAO.java";
		mapperPackageFolder = serviceImpl + entityPcName + "Mapper.java";
		voPackageFolder = service + entityPcName + "VO.java";

		// Service
		servicePackageFolder = service + entityPcName + "Service.java";
		implPackageFolder = serviceImpl + entityPcName + "ServiceImpl.java";

		// Web
		controllerPackageFolder = web + entityPcName + "Controller.java";
		jspFolder = srcMainWebapp + "WEB-INF/jsp/";

		defaultVOFolder = service + entityPcName + "DefaultVO.java";

		jspListFolder = jspFolder + smj + "/" + entityPcName + "List.jsp";
		jspListFolder2 = smj + "/" + entityPcName + "List";
		jspRegistFolder = jspFolder + smj + "/" + entityPcName + "Regist.jsp";
		jspRegistFolder2 = smj + "/" + entityPcName + "Regist";
		jspDetailFolder = jspFolder + smj + "/" + entityPcName + "Detail.jsp";
		jspDetailFolder2 = smj + "/" + entityPcName + "Detail";
	}

	// DataAccess
	private String sqlMapFolder;
	private String mapperFolder;

	private String daoPackageFolder;
	private String mapperPackageFolder;
	private String voPackageFolder;

	// Service
	private String servicePackageFolder;
	private String implPackageFolder;

	// Web
	private String controllerPackageFolder;
	private String jspFolder;

	private String defaultVOFolder;

	private String jspListFolder;
	private String jspListFolder2;
	private String jspRegistFolder;
	private String jspRegistFolder2;
	private String jspDetailFolder;
	private String jspDetailFolder2;
//	private String jspUpdtFolder;
//	private String jspPopupFolder;
//	private String jspSearchFolder;

	public String getSqlMapFolder() {
		return sqlMapFolder;
	}

	public void setSqlMapFolder(String sqlMapFolder) {
		this.sqlMapFolder = sqlMapFolder;
	}

	public String getMapperFolder() {
		return mapperFolder;
	}

	public void setMapperFolder(String mapperFolder) {
		this.mapperFolder = mapperFolder;
	}

	public String getDaoPackageFolder() {
		return daoPackageFolder;
	}

	public void setDaoPackageFolder(String daoPackageFolder) {
		this.daoPackageFolder = daoPackageFolder;
	}

	public String getMapperPackageFolder() {
		return mapperPackageFolder;
	}

	public void setMapperPackageFolder(String mapperPackageFolder) {
		this.mapperPackageFolder = mapperPackageFolder;
	}

	public String getVoPackageFolder() {
		return voPackageFolder;
	}

	public void setVoPackageFolder(String voPackageFolder) {
		this.voPackageFolder = voPackageFolder;
	}

	public String getServicePackageFolder() {
		return servicePackageFolder;
	}

	public void setServicePackageFolder(String servicePackageFolder) {
		this.servicePackageFolder = servicePackageFolder;
	}

	public String getImplPackageFolder() {
		return implPackageFolder;
	}

	public void setImplPackageFolder(String implPackageFolder) {
		this.implPackageFolder = implPackageFolder;
	}

	public String getControllerPackageFolder() {
		return controllerPackageFolder;
	}

	public void setControllerPackageFolder(String controllerPackageFolder) {
		this.controllerPackageFolder = controllerPackageFolder;
	}

	public String getJspFolder() {
		return jspFolder;
	}

	public void setJspFolder(String jspFolder) {
		this.jspFolder = jspFolder;
	}

	public String getDefaultVOFolder() {
		return defaultVOFolder;
	}

	public void setDefaultVOFolder(String defaultVOFolder) {
		this.defaultVOFolder = defaultVOFolder;
	}

	public String getJspListFolder() {
		return jspListFolder;
	}

	public void setJspListFolder(String jspListFolder) {
		this.jspListFolder = jspListFolder;
	}

	public String getJspRegistFolder() {
		return jspRegistFolder;
	}

	public void setJspRegistFolder(String jspRegistFolder) {
		this.jspRegistFolder = jspRegistFolder;
	}

	public String getJspListFolder2() {
		return jspListFolder2;
	}

	public void setJspListFolder2(String jspListFolder2) {
		this.jspListFolder2 = jspListFolder2;
	}

	public String getJspRegistFolder2() {
		return jspRegistFolder2;
	}

	public void setJspRegistFolder2(String jspRegistFolder2) {
		this.jspRegistFolder2 = jspRegistFolder2;
	}

	public String getJspDetailFolder() {
		return jspDetailFolder;
	}

	public void setJspDetailFolder(String jspDetailFolder) {
		this.jspDetailFolder = jspDetailFolder;
	}

	public String getJspDetailFolder2() {
		return jspDetailFolder2;
	}

	public void setJspDetailFolder2(String jspDetailFolder2) {
		this.jspDetailFolder2 = jspDetailFolder2;
	}

}
