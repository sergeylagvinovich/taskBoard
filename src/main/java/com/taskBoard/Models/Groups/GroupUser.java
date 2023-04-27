package com.taskBoard.Models.Groups;

import com.taskBoard.Models.Groups.Composite.GroupUsersID;
import com.taskBoard.Models.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "group_users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupUser {

    @EmbeddedId
    private GroupUsersID id = new GroupUsersID();

    @Column
    protected GroupRole role;

    @Column
    @CreationTimestamp
    protected Timestamp createdAt;

    @Column
    @UpdateTimestamp
    protected Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name="updated_user_uuid", referencedColumnName="uuid")
    protected User updated_user;
}
