package com.taskBoard.Models.Tasks;

import com.taskBoard.Models.BaseModel;
import com.taskBoard.Models.Boards.BoardColumn;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task extends BaseModel {

    @Column
    protected Integer procedure;

    @Column
    protected String name;

    @Column
    protected String note;

    @ManyToOne
    protected BoardColumn boardColumn;

    @ManyToOne
    protected TaskFiles files;

    @OneToMany(mappedBy = "task")
    protected Set<TaskComment> taskComments = new HashSet<>();

}
