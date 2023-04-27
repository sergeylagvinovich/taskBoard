package com.taskBoard.Models.Boards.Composite;

import com.taskBoard.Models.Boards.Board;
import com.taskBoard.Models.Groups.Group;
import com.taskBoard.Models.User;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class BoardUsersID implements Serializable {

    @ManyToOne(optional = false)
    @JoinColumn(name = "board_uuid")
    private Board board;


    @ManyToOne(optional = false)
    @JoinColumn(name = "user_uuid")
    private User user;
}
