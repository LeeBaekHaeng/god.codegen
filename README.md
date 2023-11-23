# god.codegen

코드생성

## 목차

- [파일 업로드](#파일-업로드)
- [maven 다중 모듈 프로젝트에 대해](#maven-다중-모듈-프로젝트에-대해)

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

```xml
        <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.30</version>
            <scope>provided</scope>
        </dependency>
```

/egov.batch.db-web/src/main/resources/application.yml

```xml
logging:
  level:
    root: "error"
    com.springboot.main: "debug"
    egovframework: "debug"
    god: "debug"
    org.hibernate: "error"
```

https://docs.spring.io/spring-boot/docs/2.7.17/reference/html/features.html#features.logging.log-levels

4. Logging

https://docs.spring.io/spring-boot/docs/2.7.17/reference/html/features.html#features.logging

By default, if you use the “Starters”, Logback is used for logging. Appropriate Logback routing is also included to ensure that dependent libraries that use Java Util Logging, Commons Logging, Log4J, or SLF4J all work correctly.
- 기본적으로 "Starters"를 사용하면 Logback이 로깅에 사용됩니다. Java Util Logging, Commons Logging, Log4J 또는 SLF4J를 사용하는 종속 라이브러리가 모두 올바르게 작동하도록 적절한 로그백 라우팅도 포함되어 있습니다.

4.3. File Output

logging.file.name

my.log

4.4. File Rotation

logging.logback.rollingpolicy.file-name-pattern

https://docs.spring.io/spring-boot/docs/2.7.17/reference/html/application-properties.html#application-properties.core.logging.logback.rollingpolicy.file-name-pattern

${LOG_FILE}.%d{yyyy-MM-dd}.%i.gz

spring-boot-maven-plugin

/egov.batch.db-web/pom.xml

```xml
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
```

<finalName>egovframework.example.bat.template.db.web-webapp</finalName>

## egov.batch.sam-web

logback-spring.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration scan="true" scanPeriod="30 seconds">
    <include resource="org/springframework/boot/logging/logback/base.xml" />

    <appender name="file" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>logs/application.log</file>
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
        <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
            <fileNamePattern>logs/application.%d{yyyy-MM-dd}.%i.log</fileNamePattern>
            <maxFileSize>10MB</maxFileSize>
            <maxHistory>7</maxHistory>
        </rollingPolicy>
    </appender>

    <logger name="com.example" level="DEBUG" additivity="false">
        <appender-ref ref="file" />
    </logger>

    <root level="INFO">
        <appender-ref ref="file" />
    </root>
</configuration>
```

RollingFileAppender

https://logback.qos.ch/manual/appenders.html#RollingFileAppender

```java
LOGGER.trace("model={}", model);
LOGGER.debug("model={}", model);
LOGGER.info("model={}", model);
LOGGER.warn("model={}", model);
LOGGER.error("model={}", model);
```

## 상세 화면 파일 다운로드, 수정 화면 파일 삭제

```jsp
<c:url value="/cmm/fms/selectFileInfs.do" var="url">
	<c:param name="param_atchFileId">${egovc:encrypt(result.atchFileId)}</c:param>
</c:url>
<a href="${url}" target="/cmm/fms/selectFileInfs.do" onclick="window.open('${url}', '/cmm/fms/selectFileInfs.do', 'left=100,top=100,width=320,height=320'); return false;">파일 다운로드</a>

<c:url value="/cmm/fms/selectFileInfsForUpdate.do" var="url">
	<c:param name="param_atchFileId">${egovc:encrypt(result.atchFileId)}</c:param>
</c:url>
<a href="${url}" target="/cmm/fms/selectFileInfsForUpdate.do" onclick="window.open('${url}', '/cmm/fms/selectFileInfsForUpdate.do', 'left=200,top=200,width=320,height=320'); return false;">파일 삭제</a>
```

## 파일 업로드

[표준프레임워크 실행환경 4.1](https://www.egovframe.go.kr/wiki/doku.php?id=egovframework:rte4.1)
- [File Upload/Download](https://www.egovframe.go.kr/wiki/doku.php?id=egovframework:rte2:fdl:file_upload_download)
    - [file_upload](https://www.egovframe.go.kr/wiki/doku.php?id=egovframework:rte2:fdl:file_upload)
    - [file_download](https://www.egovframe.go.kr/wiki/doku.php?id=egovframework:rte2:fdl:file_download)
[표준프레임워크 공통컴포넌트 4.1 가이드](https://www.egovframe.go.kr/wiki/doku.php?id=egovframework:com:v4.1:init)
    - [공통컴포넌트별 가이드(Index)](https://www.egovframe.go.kr/wiki/doku.php?id=egovframework:com:v4.1:init_guide)
        - [파일업로드(공통컴포넌트 1.0 매뉴얼 참조)](https://www.egovframe.go.kr/wiki/doku.php?id=egovframework:%ED%8C%8C%EC%9D%BC%EC%97%85%EB%A1%9C%EB%93%9C)

파일 업로드 경로(경로 설정은 반드시 절대경로를 사용해야함, 경로 뒤에 /를 붙여 주어야함.)
- /god.com-all/src/main/resources/egovframework/egovProps/globals.properties
```
# 파일 업로드 경로(경로 설정은 반드시 절대경로를 사용해야함, 경로 뒤에 /를 붙여 주어야함.)
Globals.fileStorePath =  C:/egovframework/upload/

# 파일 업로드 경로 테스트
Globals.fileStorePath.test=/egovframework/upload_test/

# 파일 업로드 경로 aaa
Globals.fileStorePath.aaa=/egovframework/upload_aaa/

# 파일 업로드 경로 aab
Globals.fileStorePath.aab=/egovframework/upload_aab/
```

파일 조회, 삭제, 다운로드 처리를 위한 컨트롤러 클래스
- /god.com-all/src/main/java/egovframework/com/cmm/web/EgovFileMngController.java

파일 업로드 추가
- /god.com-all/src/main/java/egovframework/com/cmm/web/EgovFileUploadController.java
    - /cmm/fms/uploadFile.do
- /god.com-all/src/main/webapp/WEB-INF/jsp/egovframework/com/cmm/fms/EgovFileUpload.jsp

파일 업로드 URL
- http://localhost:8080/egovframework-all-in-one/cmm/fms/uploadFile.do
- http://localhost:8080/egovframework-all-in-one/cmm/fms/uploadFile.do?param_atchFileId=oO3rGEfD8twsMG5pYVeQOvXRVZDYkZMlAF88rDkQ48k%3D
- FILE_000000000000071
- oO3rGEfD8twsMG5pYVeQOvXRVZDYkZMlAF88rDkQ48k%3D

## maven 다중 모듈 프로젝트에 대해

maven war plugin attachclasses
- https://maven.apache.org/plugins/maven-war-plugin/war-mojo.html
- <classifier>classes</classifier>

```xml
<dependency>
  <groupId>myGroup</groupId>
  <artifactId>myArtifact</artifactId>
  <version>myVersion</myVersion>
  <classifier>classes</classifier>
</dependency>
```

- https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=seban21&logNo=220735237546
- 다중 웹 모듈 간 자원 공유하기

```xml
    <build>
        <finalName>basem</finalName>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-war-plugin</artifactId>
                <version>2.1.1</version>
                <configuration>
                    <attachClasses>true</attachClasses>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

core
```xml
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-war-plugin</artifactId>
                    <version>3.3.2</version>
                    <configuration>
                        <failOnMissingWebXml>false</failOnMissingWebXml>
                        <attachClasses>true</attachClasses>
                    </configuration>
                </plugin>
```

mvn clean install
- core-1.0.0.war
- core-1.0.0-classes.jar

parent
```xml
        <dependency>
            <groupId>god</groupId>
            <artifactId>core</artifactId>
            <version>1.0.0</version>
            <type>war</type>
        </dependency>
        <dependency>
            <groupId>god</groupId>
            <artifactId>core</artifactId>
            <version>1.0.0</version>
            <classifier>classes</classifier>
            <scope>provided</scope>
        </dependency>
```

```xml
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-war-plugin</artifactId>
                    <version>3.3.2</version>
                    <configuration>
                        <failOnMissingWebXml>false</failOnMissingWebXml>
                        <overlays>
                            <overlay />
                            <overlay>
                                <groupId>god</groupId>
                                <artifactId>core</artifactId>
                            </overlay>
                        </overlays>
                    </configuration>
                </plugin>
```
