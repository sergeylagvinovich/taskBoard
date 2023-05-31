package com.taskBoard.Models.Boards;

import com.taskBoard.Models.BaseModel;
import com.taskBoard.Models.Groups.Group;
import com.taskBoard.Models.Groups.GroupUser;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "boards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Board extends BaseModel {

    @Column
    private String name;

    @ManyToOne
    private Group group;

    @OneToMany(mappedBy = "id.board", fetch = FetchType.LAZY)
    private Set<BoardUser> users = new HashSet<>();

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    private Set<BoardColumn> columns = new HashSet<>();


}
