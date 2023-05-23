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
import org.springframework.boot.context.properties.bind.DefaultValue;

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

    @ManyToOne
    @MapsId("user")
    private User user;

    @ManyToOne
    @MapsId("group")
    private Group group;

    @Column
    @Enumerated(EnumType.STRING)
    protected GroupRole role;

    @Column
    @Enumerated(EnumType.STRING)
    protected GroupUserStatus status;

    @Column
    protected Timestamp createdAt;

    @Column
    @UpdateTimestamp
    protected Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name="updated_user_uuid", referencedColumnName="uuid")
    protected User updated_user;
}
