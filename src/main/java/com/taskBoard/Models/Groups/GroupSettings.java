package com.taskBoard.Models.Groups;

import com.taskBoard.Models.BaseModel;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Data
@Table(name ="group_setting")
public class GroupSettings extends BaseModel {

    @OneToOne(cascade = CascadeType.MERGE)
    private Group group;

    @Column
    private String emailMask;

    @Column(columnDefinition = "boolean default false")
    private Boolean participantCanCreateBoard = false;

    @Column(columnDefinition = "boolean default false")
    private Boolean participantCanDeleteBoard = false;

    @Column(columnDefinition = "boolean default false")
    private Boolean participantCanAddUser = false;

    @Column(columnDefinition = "boolean default false")
    private Boolean participantCanEdit = false;

    public enum ActionType{
        CREATE_BOARD,
        DELETE_BOARD,
        ADD_USER_IN_GROUP,
        EDIT_GROUP,
    }


}
