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

	//

	private String rootFolder;

	private String srcMainJavaFolder;
	private String srcMainResourcesFolder;
	private String srcTestJavaFolder;
	private String srcTestResourcesFolder;

	private String defaultVOFolder;
	private String voFolder;

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

		//

		this.rootFolder = ".";

		this.srcMainJavaFolder = "/src/main/java";
		this.srcMainResourcesFolder = "/src/main/resources/";
		this.srcTestJavaFolder = "/src/test/java/";
		this.srcTestResourcesFolder = "/src/test/resources/";

		this.defaultVOFolder = this.rootFolder + this.srcMainJavaFolder + "/" + this.voPackage.replaceAll("\\.", "/")
				+ "/" + entity.getPcName() + "DefaultVO.java";

		this.voFolder = this.rootFolder + this.srcMainJavaFolder + "/" + this.voPackage.replaceAll("\\.", "/") + "/"
				+ entity.getPcName() + "VO.java";

		this.mapperFolder = this.rootFolder + this.srcMainResourcesFolder + "/"
				+ rootPackage.replaceAll("\\.", ".mapper\\.").replaceAll("\\.", "/") + "/" + entity.getLcName() + "/"
				+ entity.getPcName() + "_SQL_maria.xml";
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
