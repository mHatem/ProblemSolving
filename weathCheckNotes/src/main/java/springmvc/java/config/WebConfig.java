package springmvc.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 
 * @author MHatem
 * Configuration  Class
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages=("springmvc.java"))
@Import({ApplicationContext.class})
@PropertySource("classpath:application.properties")
public class WebConfig extends WebMvcConfigurerAdapter {
	
	//more custom rules/beans
	
	
	public void addViewControllers(ViewControllerRegistry registry) {
		//index mapping 
		// / - > index.jsp
		registry.addViewController("/").setViewName("index");
		
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	public static PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigure(){
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		  InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		  //strings to views
		  //success from a controller - > prefix/success/suffix
		  //success from a controller - > /WEB-INF/pages/success.jsp
		  resolver.setPrefix("/WEB-INF/pages/");
		  resolver.setSuffix(".jsp");		  
		  return resolver;		  		
	}
	

}
