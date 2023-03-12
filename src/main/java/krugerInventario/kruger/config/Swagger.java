package krugerInventario.kruger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

@Configuration
@EnableSwagger2
public class Swagger {
    private static final Set<String> CONSUMES_PRODUCES= new HashSet<String>(List.of("application/json"));

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("krugerInventario.kruger"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.apiInfo())
                .consumes(CONSUMES_PRODUCES)
                .produces(CONSUMES_PRODUCES);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Kruger: API REST Inventario de vacunación de empleados",
                "API REST Inventario de Empleados Vacunados", "1.0", "",
                new Contact("Joel Broncano", "","jbroncano97@gmail.com"),
                "Licencia del API", "", Collections.emptyList());
    }
}
