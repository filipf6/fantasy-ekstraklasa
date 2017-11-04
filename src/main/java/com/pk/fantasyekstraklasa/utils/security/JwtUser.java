package com.pk.fantasyekstraklasa.utils.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pk.fantasyekstraklasa.persistence.model.Team;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

public class JwtUser implements UserDetails {
    private final Long id;
    private final String name;
    private final String surname;
    private final String email;
    private final String username;
    private final String password;
    private final Date createDate;
    private final Collection<? extends GrantedAuthority> authorities;
    private final boolean enabled;
    private final Date lastPasswordResetDate;
    //private final Team team;

    public JwtUser(Long id, String name, String surname, String email, String username, String password, Date createDate, Collection<? extends GrantedAuthority> authorities, boolean enabled, Date lastPasswordResetDate){//, Team team) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.createDate = createDate;
        this.authorities = authorities;
        this.enabled = enabled;
        this.lastPasswordResetDate = lastPasswordResetDate;
        //this.team = team;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
    @JsonIgnore
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreateDate() {
        return createDate;
    }

    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

//    public Team getTeam() {
//        return team;
//    }
}