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
@NoArgsConstructor
@AllArgsConstructor
public class Group extends BaseModel {

    @Column
    private String name;

    @OneToMany(mappedBy = "group")
    private Set<GroupUser> users = new HashSet<>();
}
