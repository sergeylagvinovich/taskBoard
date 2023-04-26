package com.taskBoard.Models.Boards;

import com.taskBoard.Models.BaseModel;
import com.taskBoard.Models.Groups.Group;
import com.taskBoard.Models.Groups.GroupRole;
import com.taskBoard.Models.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "board_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardUsers extends BaseModel {


    @ManyToOne
    protected Board board;

    @ManyToMany(mappedBy = "boards")
    private Set<User> boardUsers = new HashSet<>();

    @Column
    protected BoardRole role;
}
