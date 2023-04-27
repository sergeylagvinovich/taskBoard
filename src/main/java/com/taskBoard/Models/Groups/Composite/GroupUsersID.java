package com.taskBoard.Models.Groups.Composite;

import com.taskBoard.Models.Groups.Group;
import com.taskBoard.Models.User;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;


@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class GroupUsersID implements Serializable {

    @ManyToOne(optional = false)
    @JoinColumn(name = "group_uuid")
    private Group group;

    @ManyToOne(optional = false)
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
