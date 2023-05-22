package com.taskBoard.Modules.HomeGroups.Serices;

import com.taskBoard.Modules.HomeGroups.DTO.HomeGroupsPage;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface HomeGroupService {

    public HomeGroupsPage getGroupsForUser(UUID user_uuid, Pageable pageable);
}
