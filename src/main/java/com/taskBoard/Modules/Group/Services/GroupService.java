package com.taskBoard.Modules.Group.Services;

import com.taskBoard.Modules.Group.Dto.BoardDto;
import com.taskBoard.Modules.Group.Dto.GroupDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public interface GroupService {

    public GroupDto getGroup(UUID group_uuid);
    public List<BoardDto> getGroupBoards(UUID group_uuid);

    public Boolean save(UUID group_uuid, GroupDto newValues);
    public Boolean delete(UUID group_uuid);


}
