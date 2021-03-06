package com.shf.spring.kube.configuration;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.shf.spring.kube.common.swagger.SwaggerHelper.builderApiInfo;
import static com.shf.spring.kube.common.swagger.SwaggerHelper.builderCommonOperationParameters;

/**
 * Description:
 * Config swagger documentation description.
 *
 * @Author: songhaifeng
 * @Date: 2019/4/30 17:45
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")
                .select()
                // exclude feign-client
                .apis(Predicates.and(Predicates.not(RequestHandlerSelectors.basePackage("com.shf.spring.kube.feign")),
                        RequestHandlerSelectors.basePackage("com.shf.spring.kube")))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(builderApiInfo("Consumer-Service","Consumer-Service REST API"))
                .globalOperationParameters(builderCommonOperationParameters());
    }

}
