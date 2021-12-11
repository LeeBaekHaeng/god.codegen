package egovframework.dev.imp.codegen.template.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CrudModel {

	private String rootPackage;
	private String rootPackage2;

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
	private String srcMainWebappFolder;

	private String defaultVOFolder;
	private String voFolder;
	private String mapperJavaFolder;
	private String serviceFolder;
	private String implFolder;
	private String controllerFolder;

	private String listFolder;
	private String registerFolder;

	@Builder
	public CrudModel(String rootFolder, String rootPackage, Entity entity,

			String author, String createDate,

			boolean checkDataAccess,

			boolean checkService,

			boolean checkWeb) {

		this.rootPackage = rootPackage;

		//

		this.author = author;
		this.createDate = createDate;

		this.checkDataAccess = checkDataAccess;
//		this.sqlMapFolder = sqlMapFolder;
//		this.mapperFolder = mapperFolder;
//		this.daoPackage = getImplPackage(entity.getLcName());
		this.mapperPackage = getImplPackage(entity.getLcName());
		this.voPackage = getServicePackage(entity.getLcName());

		this.checkService = checkService;
		this.servicePackage = getServicePackage(entity.getLcName());
		this.implPackage = getImplPackage(entity.getLcName());

		this.checkWeb = checkWeb;
		this.controllerPackage = getControllerPackage(entity.getLcName());
//		this.jspFolder = jspFolder;

		//

//		this.rootFolder = ".";
		this.rootFolder = rootFolder;

		this.srcMainJavaFolder = "/src/main/java";
		this.srcMainResourcesFolder = "/src/main/resources";
		this.srcTestJavaFolder = "/src/test/java/";
		this.srcTestResourcesFolder = "/src/test/resources";
		this.srcMainWebappFolder = "/src/main/webapp";

		this.defaultVOFolder = this.rootFolder + this.srcMainJavaFolder + "/" + this.voPackage.replaceAll("\\.", "/")
				+ "/" + entity.getPcName() + "DefaultVO.java";

		this.voFolder = this.rootFolder + this.srcMainJavaFolder + "/" + this.voPackage.replaceAll("\\.", "/") + "/"
				+ entity.getPcName() + "VO.java";

		this.mapperFolder = this.rootFolder + this.srcMainResourcesFolder + "/"
				+ rootPackage.replaceAll("\\.", ".mapper\\.").replaceAll("\\.", "/") + "/" + entity.getLcName() + "/"
				+ entity.getPcName() + "_SQL_mysql.xml";

		this.mapperJavaFolder = this.rootFolder + this.srcMainJavaFolder + "/"
				+ this.mapperPackage.replaceAll("\\.", "/") + "/" + entity.getPcName() + "Mapper.java";

		this.serviceFolder = this.rootFolder + this.srcMainJavaFolder + "/" + this.servicePackage.replaceAll("\\.", "/")
				+ "/" + entity.getPcName() + "Service.java";

		this.implFolder = this.rootFolder + this.srcMainJavaFolder + "/" + this.implPackage.replaceAll("\\.", "/") + "/"
				+ entity.getPcName() + "ServiceImpl.java";

		this.controllerFolder = this.rootFolder + this.srcMainJavaFolder + "/"
				+ this.controllerPackage.replaceAll("\\.", "/") + "/" + entity.getPcName() + "Controller.java";

		this.jspFolder = this.rootFolder + this.srcMainWebappFolder + "/WEB-INF/jsp/"
				+ this.rootPackage.replaceAll("\\.", "/");
		this.listFolder = this.jspFolder + "/" + entity.getLcName() + "/" + entity.getPcName() + "List.jsp";
		this.registerFolder = this.jspFolder + "/" + entity.getLcName() + "/" + entity.getPcName() + "Register.jsp";

		this.rootPackage2 = rootPackage.replaceAll("\\.", "/");
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
