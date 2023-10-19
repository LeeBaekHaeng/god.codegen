package egovframework.example.bat.database;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.hsqldb.util.DatabaseManagerSwing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


//@Repository("hsqlManager")
public class SpringContainerHsqlManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringContainerHsqlManager.class);
	
	@Autowired
	DataSource dataSource;
	
	@Bean
	public JdbcTemplate getJdbcTemplate(){
	  return new JdbcTemplate(dataSource);
	}
	
	@PostConstruct
	public void init() {

		//hsqldb
		DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:dataSource-hsql", "--user", "sa", "--password", "" });
		LOGGER.debug("SpringContainerHsqlManager Start run ---------- ");

		//derby
		//DatabaseManagerSwing.main(new String[] { "--url", "jdbc:derby:memory:dataSource", "--user", "", "--password", "" });

		//h2
		//DatabaseManagerSwing.main(new String[] { "--url", "jdbc:h2:mem:dataSource", "--user", "sa", "--password", "" });

	}

}
