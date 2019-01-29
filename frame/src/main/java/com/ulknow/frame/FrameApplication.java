package com.ulknow.frame;

import com.ulknow.frame.util.MyMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(basePackages = {"com.ulknow.frame.dao"}, markerInterface = MyMapper.class)
public class FrameApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FrameApplication.class, args);
    }

    /**
     * tomcat中独立部署，相当于以前的web.xml
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FrameApplication.class);
    }
}

