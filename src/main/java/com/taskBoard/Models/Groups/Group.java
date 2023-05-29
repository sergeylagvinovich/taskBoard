package com.taskBoard.Models.Groups;

import com.taskBoard.Models.BaseModel;
import com.taskBoard.Models.Boards.Board;
import com.taskBoard.Models.User;
import jakarta.persistence.*;
import lombok.*;
import org.mapstruct.control.MappingControl;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "groups")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Group extends BaseModel {

    @Column
    protected String fullName;

    @Column
    protected String shortName;

    @Column
    private String note;

    @Column
    private String url;

    @Column(columnDefinition = "varchar(50) default 'ACTIVE'")
    @Enumerated(EnumType.STRING)
    private StatusRow statusRow = StatusRow.ACTIVE;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private Set<GroupUser> users = new HashSet<>();

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private Set<Board> boards = new HashSet<>();

    @OneToOne(mappedBy = "group", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private GroupSettings groupSettings;



}
