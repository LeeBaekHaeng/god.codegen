package egovframework.dev.imp.codegen.template.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CrudModel {

	private String rootPackage;

	//

	private String author;
	private String createDate;

	private boolean checkDataAccess;
	private String sqlMapFolder;
	private String mapperFolder;
	private String daoPackage;
	private String mapperPackage;
	private String voPackage;

	private boolean checkService;
	private String servicePackage;
	private String implPackage;

	private boolean checkWeb;
	private String controllerPackage;
	private String jspFolder;

	@Builder
	public CrudModel(String rootPackage, Entity entity,

			String author, String createDate,

			boolean checkDataAccess, String sqlMapFolder, String mapperFolder, String daoPackage, String mapperPackage,
			String voPackage,

			boolean checkService, String servicePackage, String implPackage,

			boolean checkWeb, String controllerPackage, String jspFolder) {

		this.rootPackage = rootPackage;

		//

		this.author = author;
		this.createDate = createDate;

		this.checkDataAccess = checkDataAccess;
		this.sqlMapFolder = sqlMapFolder;
		this.mapperFolder = mapperFolder;
		this.daoPackage = getImplPackage(entity.getLcName());
		this.mapperPackage = getImplPackage(entity.getLcName());
		this.voPackage = getServicePackage(entity.getLcName());

		this.checkService = checkService;
		this.servicePackage = getServicePackage(entity.getLcName());
		this.implPackage = getImplPackage(entity.getLcName());

		this.checkWeb = checkWeb;
		this.controllerPackage = getControllerPackage(entity.getLcName());
		this.jspFolder = jspFolder;
	}

	private String getImplPackage(String implPackage) {
		return this.rootPackage + "." + implPackage + ".service.impl";
	}

	private String getServicePackage(String servicePackage) {
		return this.rootPackage + "." + servicePackage + ".service";
	}

	private String getControllerPackage(String controllerPackage) {
		return this.rootPackage + "." + controllerPackage + ".web";
	}

}
