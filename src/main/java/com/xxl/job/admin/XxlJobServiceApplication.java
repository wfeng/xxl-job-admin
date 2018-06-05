package com.xxl.job.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class XxlJobServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxlJobServiceApplication.class, args);
    }

    @Bean
    public ServerProperties serverProperties() {
        return new ServerProperties() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                super.customize(container);
                container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/static/500.html"));
            }
        };
    }
}
