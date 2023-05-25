package com.taskBoard.Models.Groups.Composite;

import com.taskBoard.Models.Groups.Group;
import com.taskBoard.Models.User;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;


import java.io.Serializable;
import java.util.Objects;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class GroupUsersID implements Serializable {

    @ManyToOne
    @JoinColumn(name = "group_uuid")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "user_uuid")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupUsersID that = (GroupUsersID) o;
        return Objects.equals(group, that.group) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group, user);
    }
}
