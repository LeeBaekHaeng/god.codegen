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
 * 패키지 정보 클래스
 * <p>
 * <b>NOTE:</b> 패키지 정보를 담기위한 모델 클래스
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
public class EgovPackage {

	public EgovPackage(String topLevelPackage, String name2, String name3) {
		String name = topLevelPackage + "." + name2 + "." + name3;

		String service = ".service";
		String serviceImpl = ".service.impl";
		String web = ".web";

		daoPackage = name + serviceImpl;
		mapperPackage = name + serviceImpl;
		voPackage = name + service;
		servicePackage = name + service;
		implPackage = name + serviceImpl;
		controllerPackage = name + web;
	}

	private String daoPackage;
	private String mapperPackage;
	private String voPackage;
	private String servicePackage;
	private String implPackage;
	private String controllerPackage;

	public String getDaoPackage() {
		return daoPackage;
	}

	public void setDaoPackage(String daoPackage) {
		this.daoPackage = daoPackage;
	}

	public String getMapperPackage() {
		return mapperPackage;
	}

	public void setMapperPackage(String mapperPackage) {
		this.mapperPackage = mapperPackage;
	}

	public String getVoPackage() {
		return voPackage;
	}

	public void setVoPackage(String voPackage) {
		this.voPackage = voPackage;
	}

	public String getServicePackage() {
		return servicePackage;
	}

	public void setServicePackage(String servicePackage) {
		this.servicePackage = servicePackage;
	}

	public String getImplPackage() {
		return implPackage;
	}

	public void setImplPackage(String implPackage) {
		this.implPackage = implPackage;
	}

	public String getControllerPackage() {
		return controllerPackage;
	}

	public void setControllerPackage(String controllerPackage) {
		this.controllerPackage = controllerPackage;
	}

}
