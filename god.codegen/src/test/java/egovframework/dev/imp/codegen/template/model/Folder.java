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

	public Folder(String name, String pcName) {
		String srcMainJava = "src/main/java/";
		String srcMainResources = "src/main/resources/";

		String service = ".service";
		String serviceImpl = ".service.impl";
		String web = ".web";

//		mapperFolder = srcMainJava + name.replaceAll("\\.", "/") + serviceImpl.replaceAll("\\.", "/");
		serviceFolder = srcMainJava + name.replaceAll("\\.", "/") + service.replaceAll("\\.", "/");
		implFolder = srcMainJava + name.replaceAll("\\.", "/") + serviceImpl.replaceAll("\\.", "/");
		controllerFolder = srcMainJava + name.replaceAll("\\.", "/") + web.replaceAll("\\.", "/");

		defaultVOFolder = serviceFolder + "/" + pcName + "DefaultVO.java";
		voFolder = serviceFolder + "/" + pcName + "VO.java";
		daoFolder = implFolder + "/" + pcName + "DAO.java";
		serviceFolder = serviceFolder + "/" + pcName + "Service.java";
	}

	private String daoFolder;
	private String mapperFolder;
	private String serviceFolder;
	private String implFolder;
	private String controllerFolder;

	private String defaultVOFolder;
	private String voFolder;

	public String getDaoFolder() {
		return daoFolder;
	}

	public void setDaoFolder(String daoFolder) {
		this.daoFolder = daoFolder;
	}

	public String getVoFolder() {
		return voFolder;
	}

	public void setVoFolder(String voFolder) {
		this.voFolder = voFolder;
	}

	public String getMapperFolder() {
		return mapperFolder;
	}

	public void setMapperFolder(String mapperFolder) {
		this.mapperFolder = mapperFolder;
	}

	public String getServiceFolder() {
		return serviceFolder;
	}

	public void setServiceFolder(String serviceFolder) {
		this.serviceFolder = serviceFolder;
	}

	public String getImplFolder() {
		return implFolder;
	}

	public void setImplFolder(String implFolder) {
		this.implFolder = implFolder;
	}

	public String getControllerFolder() {
		return controllerFolder;
	}

	public void setControllerFolder(String controllerFolder) {
		this.controllerFolder = controllerFolder;
	}

	public String getDefaultVOFolder() {
		return defaultVOFolder;
	}

	public void setDefaultVOFolder(String defaultVOFolder) {
		this.defaultVOFolder = defaultVOFolder;
	}

}
