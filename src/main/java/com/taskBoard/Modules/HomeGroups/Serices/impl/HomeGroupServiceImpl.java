package com.taskBoard.Modules.HomeGroups.Serices.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.taskBoard.Configurations.Responces.ResponseAPIDto;
import com.taskBoard.Dao.GroupDao;
import com.taskBoard.Dto.PageDto;
import com.taskBoard.Modules.HomeGroups.DTO.HomeGroupsDto;
import com.taskBoard.Modules.HomeGroups.DTO.HomeGroupsPage;
import com.taskBoard.Modules.HomeGroups.Exceptions.HomeGroupException;
import com.taskBoard.Modules.HomeGroups.Exceptions.TestException;
import com.taskBoard.Modules.HomeGroups.Serices.HomeGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class HomeGroupServiceImpl implements HomeGroupService {
    @Autowired
    GroupDao groupDao;

    @Override
    public HomeGroupsPage getGroupsForUser(UUID user_uuid, Pageable pageable) {

        Page<Object[]> groups = groupDao.getGroups(user_uuid,pageable);
        PageDto page = PageDto.builder()
                .size(groups.getSize())
                .page(groups.getPageable().getPageNumber())
                .total(groups.getTotalPages()).build();
        List<HomeGroupsDto> homeGroupsDtos = new ArrayList<>();
        List<Object[]> content = groups.getContent();

        for (int i = 0; i < content.size(); i++) {
            try {
                homeGroupsDtos.add(new HomeGroupsDto(content.get(i)));
            } catch (JsonProcessingException e) {
                throw new HomeGroupException("Возникла проблема с полученим данных");
            }
        }
        return HomeGroupsPage.builder().page(page).groups(homeGroupsDtos).build();

    }


}
