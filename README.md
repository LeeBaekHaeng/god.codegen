# god.codegen
코드생성

## egovframe-development 4.0.0

- https://github.com/eGovFramework/egovframe-development
	- egovframework.dev.imp.codegen.template
		- https://github.com/eGovFramework/egovframe-development/tree/master/egovframework.dev.imp.codegen.template
			- https://github.com/eGovFramework/egovframe-development/blob/master/egovframework.dev.imp.codegen.template/src/egovframework/dev/imp/codegen/template/model/Attribute.java
			- https://github.com/eGovFramework/egovframe-development/blob/master/egovframework.dev.imp.codegen.template/src/egovframework/dev/imp/codegen/template/model/DataModelContext.java
			- https://github.com/eGovFramework/egovframe-development/blob/master/egovframework.dev.imp.codegen.template/src/egovframework/dev/imp/codegen/template/model/DbModelElement.java
			- https://github.com/eGovFramework/egovframe-development/blob/master/egovframework.dev.imp.codegen.template/src/egovframework/dev/imp/codegen/template/model/Entity.java
			- https://github.com/eGovFramework/egovframe-development/blob/master/egovframework.dev.imp.codegen.template/src/egovframework/dev/imp/codegen/template/util/NamingUtils.java
	- egovframework.dev.imp.codegen.template.templates
		- https://github.com/eGovFramework/egovframe-development/tree/master/egovframework.dev.imp.codegen.template.templates
			- https://github.com/eGovFramework/egovframe-development/tree/master/egovframework.dev.imp.codegen.template.templates/eGovFrameTemplates/crud
	- egovframework.dev.imp.templates
		- https://github.com/eGovFramework/egovframe-development/tree/master/egovframework.dev.imp.templates

## egovframe-development

- 단위테스트 https://github.com/LeeBaekHaeng/egovframe-development/tree/master/egovframework.dev.imp.templates
- 소스 https://github.com/LeeBaekHaeng/egovframe-development/tree/master/egovframework.dev.imp.codegen.template
- eGovFrameTemplates https://github.com/LeeBaekHaeng/egovframe-development/tree/master/egovframework.dev.imp.codegen.template.templates
- Velocity Context에 값 삽입 https://github.com/LeeBaekHaeng/egovframe-development/blob/master/egovframework.dev.imp.codegen.template/src/egovframework/dev/imp/codegen/template/wizards/CodeGenTableWizardPage.java

## New eGovFrame Web Project

새로운 eGovFrame 웹 프로젝트

Project name: god.codegen

.project

```xml
<nature>egovframework.dev.imp.ide.natures.egovnature</nature>
```

## Add eGovFrame Common Component > 공통 > 공통

eGovFrame 공통 구성 요소 추가

docs

## DriverManager.getConnection

```java
//		String url = "jdbc:log4jdbc:mysql://127.0.0.1:3306/com";
		String url = "jdbc:mysql://127.0.0.1:3306/com?useInformationSchema=true";
		String user = "com";
		String password = "com01";

		try (

				Connection con = DriverManager.getConnection(url, user, password);

		) {

			log.debug("con={}", con);
			log.debug("getCatalog={}", con.getCatalog());
			log.debug("getSchema={}", con.getSchema());
			log.debug("getTypeMap={}", con.getTypeMap());

		} catch (SQLException e) {
			log.error("getConnection SQLException");
		}
```

```java
DatabaseMetaData metaData = con.getMetaData();

log.debug("getDatabaseProductName={}", metaData.getDatabaseProductName());

ResultSet tables = metaData.getTables(catalog, schemaPattern, tableNamePattern, types);

ResultSet columns = metaData.getColumns(catalog, schemaPattern, tableNamePattern, columnNamePattern);

ResultSet primaryKeys = metaData.getPrimaryKeys(catalog, schema, table);
```

## 톰캣 캐시의 최대 크기를 증가

Servers > Tomcat v8.5 Server at localhost-config > context.xml

```xml
    <!-- 캐시의 최대 크기를 증가시키는 것을 고려해 보십시오. -->
    <!-- 10240 10MB 에서 102400 100MB 로 수정 -->
    <Resources cacheMaxSize="102400"></Resources>
```
