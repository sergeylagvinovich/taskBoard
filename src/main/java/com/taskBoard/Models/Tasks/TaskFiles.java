package com.taskBoard.Models.Tasks;

import com.taskBoard.Models.BaseModel;
import com.taskBoard.Models.Files;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "task_files")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskFiles extends BaseModel {

    @OneToMany(mappedBy = "taskFiles")
    protected Set<Files> files = new HashSet<>();

    @OneToMany(mappedBy = "files")
    protected Set<Task> tasks = new HashSet<>();

}
