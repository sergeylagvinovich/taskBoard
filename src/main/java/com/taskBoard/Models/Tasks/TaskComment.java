package com.taskBoard.Models.Tasks;

import com.taskBoard.Models.BaseModel;
import com.taskBoard.Models.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "task_comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskComment extends BaseModel {

    @ManyToOne
    protected User sender;

    @Column
    protected String message;

    @ManyToOne
    protected Task task;

}
