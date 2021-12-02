# god.codegen
코드생성

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
