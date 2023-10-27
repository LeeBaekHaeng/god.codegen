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

## spring.profiles.active

```
-Dspring.profiles.active=mysql,security
```

```
-Dspring.profiles.active=mysqlHikariCP,security
```

```
-Dspring.profiles.active=mysqlHikariCP,security
-Dcatalina.base="C:\GOD.CODEGEN\eGovFrameDev-4.1.0-64bit\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0" -Dcatalina.home="C:\GOD.CODEGEN\eGovCI-4.0.0_64bit\bin\apache-tomcat-8.5.73-jenkins" -Dwtp.deploy="C:\GOD.CODEGEN\eGovFrameDev-4.1.0-64bit\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps" -Djava.endorsed.dirs="C:\GOD.CODEGEN\eGovCI-4.0.0_64bit\bin\apache-tomcat-8.5.73-jenkins\endorsed"
```

## HikariCP

https://github.com/brettwooldridge/HikariCP#rocket-initialization

/god.com-all/src/main/resources/egovframework/spring/com/context-datasource.xml

```xml
    <beans profile="mysqlHikariCP">
        <bean id="dataSource" class="com.zaxxer.hikari.HikariDataSource" destroy-method="close">
            <property name="driverClassName" value="${Globals.mysql.DriverClassName}" />
            <property name="jdbcUrl" value="${Globals.mysql.Url}" />
            <property name="username" value="${Globals.mysql.UserName}" />
            <property name="password" value="#{egovEnvCryptoService.getPassword()}" />
        </bean>
    </beans>
```

```xml
    <!-- MySQL -->
    <beans profile="mysql">
        <bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource" destroy-method="close">
            <property name="driverClassName" value="${Globals.mysql.DriverClassName}" />
            <property name="url" value="${Globals.mysql.Url}" />
            <property name="username" value="${Globals.mysql.UserName}" />
            <!-- 암호화(Crypto) 관련 서비스 https://www.egovframe.go.kr/wiki/doku.php?id=egovframework:rte2:fdl:crypto_simplify_v3_8 참조 -->
            <property name="password" value="#{egovEnvCryptoService.getPassword()}" />
        </bean>
    </beans>
    <beans profile="mysqlHikariCP">
        <bean id="dataSource" class="com.zaxxer.hikari.HikariDataSource" destroy-method="close">
            <property name="driverClassName" value="${Globals.mysql.DriverClassName}" />
            <property name="jdbcUrl" value="${Globals.mysql.Url}" />
            <property name="username" value="${Globals.mysql.UserName}" />
            <property name="password" value="#{egovEnvCryptoService.getPassword()}" />
        </bean>
    </beans>
```

## log4jdbc 를 Log4jdbc-log4j2 로 수정

log4jdbc
- https://mvnrepository.com/artifact/com.googlecode.log4jdbc/log4jdbc/1.2
- https://code.google.com/archive/p/log4jdbc/

```xml
<!-- https://mvnrepository.com/artifact/com.googlecode.log4jdbc/log4jdbc -->
<dependency>
    <groupId>com.googlecode.log4jdbc</groupId>
    <artifactId>log4jdbc</artifactId>
    <version>1.2</version>
</dependency>

```

Log4jdbc-log4j2
- https://mvnrepository.com/artifact/org.bgee.log4jdbc-log4j2/log4jdbc-log4j2-jdbc4.1/1.16
- https://mvnrepository.com/search?q=log4jdbc-log4j2
- https://log4jdbc.brunorozendo.com/
- https://code.google.com/archive/p/log4jdbc-log4j2/

```xml
<!-- https://mvnrepository.com/artifact/org.bgee.log4jdbc-log4j2/log4jdbc-log4j2-jdbc4.1 -->
<dependency>
    <groupId>org.bgee.log4jdbc-log4j2</groupId>
    <artifactId>log4jdbc-log4j2-jdbc4.1</artifactId>
    <version>1.16</version>
</dependency>
```

### log4jdbc:

3. Modification of your source code
- 3. 소스 코드 수정

3.1. Change your JDBC URL
- 3.1. JDBC URL 변경

Prepend jdbc:log4 to the normal JDBC URL that you are using. For example, if your normal JDBC URL is:
- 사용 중인 일반 JDBC URL 앞에 jdbc:log4를 추가합니다. 예를 들어 정상적인 JDBC URL이 다음과 같은 경우:
```xml
jdbc:derby://localhost:1527//db-derby-10.2.2.0-bin/databases/MyDatabase
```

then you would change it to:
- 그런 다음 다음과 같이 변경합니다.
```
jdbc:log4jdbc:derby://localhost:1527//db-derby-10.2.2.0-bin/databases/MyDatabase
```

### net.sf.log4jdbc.sql.jdbcapi.DriverSpy

Configure a DataSource
- 데이터 소스 구성

Option 1: configure Driver class name and JDBC URL
- 옵션 1: 드라이버 클래스 이름 및 JDBC URL 구성

You can either configure your DataSource to use the log4jdbc-log4j2 driver (net.sf.log4jdbc.sql.jdbcapi.DriverSpy), and to use the modified JDBC URL (prepending jdbc:log4 to the normal JDBC URL).
- log4jdbc-log4j2 드라이버(net.sf.log4jdbc.sql.jdbcapi.DriverSpy)를 사용하고 수정된 JDBC URL(일반 JDBC URL 앞에 jdbc:log4 추가)을 사용하도록 DataSource를 구성할 수 있습니다.

## 배치

- eGovFrame Boot Batch Template Project

```
god.test-batch-file-scheduler
god.test-batch-file-cli
god.test-batch-file-web
god.test-batch-db-scheduler
god.test-batch-db-cli
god.test-batch-db-web
```

groupId, artifactId, name
```
egov.batch.sam-scheduler
egov.batch.sam-commandline
egov.batch.sam-web
egov.batch.db-scheduler
egov.batch.db-commandline
egov.batch.db-web
```

finalName
```
egovframework.example.bat.template.sam.scheduler
egovframework.example.bat.template.sam.commandline
egovframework.example.bat.template.sam.web
egovframework.example.bat.template.db.scheduler
egovframework.example.bat.template.db.commandline
egovframework.example.bat.template.db.web-webapp
```

egov.batch.db-web 임포트
- Import
  - Maven
    - Existing Maven Projects

egov.batch.db-web 실행
- Boot Dashboard
  - local
    - egov.batch.db-web

egov.batch.db-web URL
- 포트: Tomcat started on port(s): 9300 (http) with context path ''
- URL: http://localhost:9300/

@Repository("hsqlManager") 주석
- /egov.batch.db-web/src/main/java/egovframework/example/bat/database/SpringContainerHsqlManager.java
```java
//@Repository("hsqlManager")
```

context:component-scan god 추가
- /egov.batch.db-web/src/main/resources/egovframework/batch/context-servlet.xml
```xml
<context:component-scan base-package="egovframework,god">
```

/egov.batch.db-web/src/main/java/com/springboot/main/EgovBootApplication.java

@EnableBatchProcessing

https://docs.spring.io/spring-batch/docs/4.3.9/reference/html/job.html#javaConfig

AppConfig
