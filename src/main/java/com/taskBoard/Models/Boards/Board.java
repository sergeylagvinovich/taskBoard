package com.taskBoard.Models.Boards;

import com.taskBoard.Models.BaseModel;
import com.taskBoard.Models.Groups.Group;
import com.taskBoard.Models.Groups.GroupUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "boards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Board extends BaseModel {

    @Column
    protected String name;

    @ManyToOne
    protected Group group;


    @OneToMany(mappedBy = "id.board")
    private Set<BoardUser> users = new HashSet<>();

    @OneToMany(mappedBy = "board")
    protected Set<BoardColumn> columns = new HashSet<>();


}
