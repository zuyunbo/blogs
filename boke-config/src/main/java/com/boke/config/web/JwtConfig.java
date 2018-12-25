package com.boke.config.web;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration

public class JwtConfig {

    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        JWTAuthenticationFilter filter = new JWTAuthenticationFilter();
        registrationBean.setFilter(filter);
        return registrationBean;
    }


}
