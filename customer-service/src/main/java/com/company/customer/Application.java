package com.company.customer;

import com.company.customer.persistence.PersistenceServiceImpl;
import com.company.customer.service.CustomerService;
import com.company.customer.service.CustomerServiceImpl;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import com.company.customer.persistence.PersistenceService;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CustomerService customerService() {
		return new CustomerServiceImpl();
	}

	@Bean
	public PersistenceService persistenceService() {
		return new PersistenceServiceImpl();
	}

	@Bean
	public Docket api() throws IOException, XmlPullParserException {
		MavenXpp3Reader reader = new MavenXpp3Reader();
//		Model model = reader.read(new FileReader("pom.xml"));
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.company.customer.api"))
				.paths(PathSelectors.any())
				.build().apiInfo(new ApiInfo("Customer Api Documentation", "Documentation automatically generated", getClass().getPackage().getImplementationVersion(), null, new Contact("company Team", "www.company.com", "company@gmail.com"), null, null));
	}

}
