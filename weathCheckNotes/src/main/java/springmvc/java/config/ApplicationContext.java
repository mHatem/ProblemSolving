package springmvc.java.config;


import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springmvc.java.service.NotesService;
import springmvc.java.service.UserService;
import springmvc.java.serviceImpl.NotesServiceImpl;
import springmvc.java.serviceImpl.UserServiceImpl;

@EnableJpaRepositories(basePackages={"springmvc.java.dao"})
@EnableTransactionManagement
@Configuration
public class ApplicationContext {

	@Autowired
	private Environment enviroment;
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(enviroment.getProperty("jdbc.driverClass"));
		dataSource.setUrl(enviroment.getProperty("jdbc.url"));
		dataSource.setUsername(enviroment.getProperty("jdbc.username"));
		dataSource.setPassword(enviroment.getProperty("jdbc.password"));
		
		return dataSource;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
		return jpaTransactionManager;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter(){
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		
		jpaVendorAdapter.setDatabase(Database.MYSQL);
		jpaVendorAdapter.setShowSql(true);
		
		return jpaVendorAdapter;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
		entityManagerFactory.setPackagesToScan("springmvc.java.domain");
		
		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		entityManagerFactory.setJpaProperties(jpaProperties);
		
		return entityManagerFactory;
	}
	
	@Bean
	public UserService userService () {		
		return new UserServiceImpl();		
	}

	@Bean
	public NotesService notesService () {		
		return new NotesServiceImpl();		
	}
	
}
