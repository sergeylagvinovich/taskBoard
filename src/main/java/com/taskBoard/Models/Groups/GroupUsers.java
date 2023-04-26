package com.taskBoard.Models.Groups;

import com.taskBoard.Models.BaseModel;
import com.taskBoard.Models.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "group_users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupUsers extends BaseModel {


    @ManyToOne
    protected Group group;

    @ManyToMany(mappedBy = "groups")
    private Set<User> groupUsers = new HashSet<>();

    @Column
    protected GroupRole role;
}
