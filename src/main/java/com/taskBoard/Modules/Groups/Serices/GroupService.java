package com.taskBoard.Modules.Groups.Serices;

import com.taskBoard.Models.Groups.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface GroupService {

    public Page<Object[]> getGroupsByUserUUIDPaginate(UUID user_uuid, Pageable pageable);
    public List<Object[]> getGroupsByUserUUID(UUID user_uuid);
    public Group getGroupUUID(UUID group_uuid);
}
