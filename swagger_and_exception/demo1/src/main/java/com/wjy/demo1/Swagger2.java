package com.wjy.demo1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by apple on 2017/7/22.
 */
//1.通过这个注解来让Spring来加载该类配置
@Configuration
//2.再通过这个注解来启用Swagger2
@EnableSwagger2
public class Swagger2 {
    @Bean
    /***
     * 通过注解EnableSwagger2声明Swagger的可用性，此处会定义一个类型为Docket的bean，
     关于docket类的说明如下：
     A builder which is intended to be the primary interface into the swagger-springmvc framework.
     Provides sensible defaults and convenience methods for configuration.
     Docket的select()方法会提供给swagger-springmvc framework的一个默认构造器（ApiSelectorBuilder），
     这个构造器为配置swagger提供了一系列的默认属性和便利方法。
     */
    public Docket creatRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                //3.再通过createRestApi函数创建Docket的Bean之后，apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）。
                .apiInfo(apiInfo())
                /***
                 * select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现,
                本例采用指定扫描的包路径来定义，Swagger会扫描该包下所有Controller定义的API，
                并产生文档内容（除了被@ApiIgnore指定的请求）。
                 */
                //选择那些路径和api会生成document
                .select()
                //对所有api进行监控
                .apis(RequestHandlerSelectors.any())
                //.apis(RequestHandlerSelectors.basePackage("com.wjy.demo1"))
                //对所有路径进行监控
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
                .termsOfServiceUrl("http://blog.didispace.com/")
                .contact("程序猿DD")
                .version("1.0")
                .build();
    }
}
