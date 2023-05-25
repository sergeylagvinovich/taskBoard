package com.taskBoard.Models;

import com.taskBoard.Models.Boards.BoardUser;
import com.taskBoard.Models.Groups.GroupUser;
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
@Builder
public class User extends BaseModel {

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String img;

    @Column
    private String password;

    @OneToMany(mappedBy = "id.user", fetch = FetchType.LAZY)
    private Set<GroupUser> groups = new HashSet<>();

    @OneToMany(mappedBy = "id.user", fetch = FetchType.LAZY)
    private Set<BoardUser> boards = new HashSet<>();

}
