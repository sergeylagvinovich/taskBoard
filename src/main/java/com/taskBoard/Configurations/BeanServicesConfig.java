package com.taskBoard.Configurations;

import com.taskBoard.Modules.Groups.Serices.impl.GroupServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicesConfig {

    @Bean
    public GroupServiceImpl getGroupMapperCustomService() {
        return new GroupServiceImpl();
    }

}
