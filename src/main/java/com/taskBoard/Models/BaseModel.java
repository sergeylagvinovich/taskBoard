package com.taskBoard.Models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Timestamp;
import java.util.UUID;
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseModel {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    protected UUID UUID;

    @Column
    @CreationTimestamp
    protected Timestamp createdAt;

    @Column
    @UpdateTimestamp
    protected Timestamp updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="updated_user_uuid", referencedColumnName="uuid")
    protected User updated_user;

    @Override
    public boolean equals(Object obj) {
        BaseModel baseObj = (BaseModel) obj;
        return baseObj.UUID.equals(this.UUID);
    }

}
