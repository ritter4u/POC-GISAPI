package io.github.ritter4u.POCGISAPI.Config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Bean
    fun productApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("io.github.ritter4u.POCGISAPI.Controller"))
            .build()
            //.apiInfo(this.metaInfo())
    }

    private fun metaInfo(): ApiInfo {
        return ApiInfoBuilder()
            .title("API 문서")
            .description("테스트 API 문서입니다.")
            .version("1.0")
            .termsOfServiceUrl("http://terms.com")
            .license("Apache")
            .licenseUrl("http://license.com")
            .contact(
                Contact(
                    "Api",
                    "http://ritter4u",
                    "ritter4u@gmail.com"
                )
            )
            .build()
    }
}
