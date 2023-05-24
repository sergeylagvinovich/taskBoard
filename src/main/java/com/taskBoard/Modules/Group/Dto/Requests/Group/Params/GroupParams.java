package com.taskBoard.Modules.Group.Dto.Requests.Group.Params;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import org.mapstruct.EnumMapping;

@Data
public class GroupParams {

    private GroupDetail details = GroupDetail.GROUP;


    public enum GroupDetail{
        @JsonEnumDefaultValue
        GROUP("GROUP"),
        GROUP_BOARDS("GROUP_BOARDS");

        private final String name;
        GroupDetail(String name){
            this.name = name;
        }
        @JsonValue
        public String getName(){
            return this.name;
        }

    }


}
