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
    private final String username;
    private final String password;
    private final Date createDate;
    private final Collection<? extends GrantedAuthority> authorities;
    private final boolean enabled;
    private final Date lastPasswordResetDate;
    private final Integer budget;
    private final Team team;

    public JwtUser(Long id,
                   String name,
                   String surname,
                   String username,
                   String password,
                   Date createDate,
                   Collection<? extends GrantedAuthority> authorities,
                   boolean enabled,
                   Date lastPasswordResetDate,
                   Integer budget,
                   Team team) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.createDate = createDate;
        this.authorities = authorities;
        this.enabled = enabled;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.budget = budget;
        this.team = team;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
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

    public Date getCreateDate() {
        return createDate;
    }

    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public Integer getBudget() {
        return budget;
    }

    public Team getTeam() {
        return team;
    }
}
