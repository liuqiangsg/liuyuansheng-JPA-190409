package com.fulian.liuyuansheng.zhouyunlian.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.data.web.config.SortHandlerMethodArgumentResolverCustomizer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * WebConfiguration
 *
 * @author liuqiang
 * @date 2019/4/13
 */
@Configuration
@EnableWebMvc
@EnableSpringDataWebSupport
public class WebConfiguration {



    //PageableHandlerMethodArgumentResolverCustomizer






    // or extend SpringDataWebConfiguration  override the pageableResolver()
    //-- or sortResolver
     @Bean
     SortHandlerMethodArgumentResolverCustomizer sortCustomizer() {
        return (s) -> s.setPropertyDelimiter(",");
     }
}
