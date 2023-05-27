package com.taskBoard.Configurations.Security.JwtToken;

import com.taskBoard.ExceptionHandler.Exceptions.NotFoundException;
import com.taskBoard.Models.User;
import com.taskBoard.Modules.Users.Dao.UserDao;
import com.taskBoard.Modules.Users.Services.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.UUID;

@Data
public class JwtAuthentication implements Authentication {

    private boolean authenticated;
    private String email;
    private String id;
    private User user;

    public UUID getUUID(){
        return UUID.fromString(this.id);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.user;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }


    @Override
    public String getName() {
        return this.email;
    }
}
