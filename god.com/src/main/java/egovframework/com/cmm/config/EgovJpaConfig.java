package egovframework.com.cmm.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import lombok.NoArgsConstructor;

/**
 * 
 * @author 이백행
 * @since 2024-02-10
 *
 */
@Configuration
@EnableJpaRepositories(basePackages = { "egovframework.com.repositories",
		"god.com.repositories" }, transactionManagerRef = "txManager")
@NoArgsConstructor
public class EgovJpaConfig {

	/**
	 * 
	 * @param dataSource
	 * @return
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(final DataSource dataSource) {
		final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactoryBean.setPackagesToScan(new String[] { "egovframework.com.entites", "god.com.entites" });
//		entityManagerFactoryBean.setPackagesToScan(
//				(String[]) Arrays.asList("egovframework.com.entites", "god.com.entites").toArray());
//		entityManagerFactoryBean
//				.setPackagesToScan(Arrays.asList("egovframework.com", "god.com").toArray(new String[0]));

		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter());
		return entityManagerFactoryBean;
	}

	/**
	 * 
	 * @return
	 */
	@Bean
	public HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
		final HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(true);
		return hibernateJpaVendorAdapter;
	}

}
