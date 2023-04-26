package com.taskBoard.Models;

import com.taskBoard.Models.Boards.Board;
import com.taskBoard.Models.Boards.BoardUsers;
import com.taskBoard.Models.Groups.GroupUsers;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseModel {

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String img;

    @ManyToMany
    private Set<GroupUsers> groups = new HashSet<>();

    @ManyToMany
    private Set<BoardUsers> boards = new HashSet<>();

}
