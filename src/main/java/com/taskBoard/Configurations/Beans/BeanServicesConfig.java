package com.taskBoard.Configurations.Beans;

import com.taskBoard.Modules.Group.Services.impl.GroupServiceImpl;
import com.taskBoard.Modules.Group.Services.impl.GroupUserServiceImpl;
import com.taskBoard.Modules.HomeGroups.Serices.impl.HomeGroupServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicesConfig {

    @Bean
    public HomeGroupServiceImpl getHomeGroupService() {
        return new HomeGroupServiceImpl();
    }

    @Bean
    public GroupServiceImpl getGroupService() {
        return new GroupServiceImpl();
    }

    @Bean
    public GroupUserServiceImpl getGroupUserService() {
        return new GroupUserServiceImpl();
    }

}
