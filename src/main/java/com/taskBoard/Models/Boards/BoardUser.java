package com.taskBoard.Models.Boards;

import com.taskBoard.Models.BaseModel;
import com.taskBoard.Models.Boards.Composite.BoardUsersID;
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
@Table(name = "board_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardUser {

    @EmbeddedId
    protected BoardUsersID id;

    @Column
    protected BoardRole role;

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
