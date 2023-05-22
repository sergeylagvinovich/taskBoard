package com.taskBoard.Models.Groups;

import com.taskBoard.Models.BaseModel;
import com.taskBoard.Models.Boards.Board;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "groups")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Group extends BaseModel {

    @Column
    protected String fullName;

    @Column
    protected String shortName;

    @Column
    private String note;

    @Column
    private String url;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private Set<GroupUser> users = new HashSet<>();

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private Set<Board> boards = new HashSet<>();
}
