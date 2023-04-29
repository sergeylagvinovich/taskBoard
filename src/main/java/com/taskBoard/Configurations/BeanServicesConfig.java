package com.taskBoard.Configurations;

import com.taskBoard.Modules.TaskBoard.src.Mappings.CustomMapping.impl.GroupMapperCustomImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicesConfig {

    @Bean
    public GroupMapperCustomImpl getGroupMapperCustomService() {
        return new GroupMapperCustomImpl ();
    }

}
