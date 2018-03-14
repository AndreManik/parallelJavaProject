package ru.parallelProject.parallel.model;

import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

public class User extends NamedEntity {
    private String email;
    private String password;
    private boolean enabled = true;
    private Date registred = new Date();
    private Set<Role> authorities;

    public User(String name, String email, String password, Role role, Role... roles) {
        super(name);
        this.email = email;
        this.password = password;
        this.enabled = true;
        this.authorities = EnumSet.of(role, roles);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Collection<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Role role) {
        this.authorities.add(role);
    }

    public Date getRegistred() {
        return registred;
    }

    public void setRegistred(Date registred) {
        this.registred = registred;
    }

    @Override
    public String toString() {
        return "User{" +
                    "name='" + name + '\'' +
                    "email='" + email + '\'' +
                    ", password='" + password + '\'' +
                    ", enabled=" + enabled +
                    ", registred=" + registred +
                    ", authorities=" + authorities +
                '}';
    }
}
