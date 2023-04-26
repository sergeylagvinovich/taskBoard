package com.taskBoard.Models.Boards;

import com.taskBoard.Models.BaseModel;
import com.taskBoard.Models.Boards.Board;
import com.taskBoard.Models.Tasks.Task;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Table(name = "board_columns")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardColumn extends BaseModel {

    @Column
    protected String name;

    @Column
    protected Integer procedure;

    @ManyToOne
    protected Board board;

    @OneToMany(mappedBy = "boardColumn")
    protected Set<Task> tasks = new HashSet<>();
}
