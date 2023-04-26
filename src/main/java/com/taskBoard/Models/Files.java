package com.taskBoard.Models;

import com.taskBoard.Models.Tasks.TaskFiles;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "files")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Files extends BaseModel{

    @Column
    protected String filePath;

    @Column
    protected String fileName;

    @ManyToOne
    protected TaskFiles taskFiles;


}
