package com.intellisensedev.urlshortener_engine.role.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ROLES")
public class Roles {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="ROLE_NAME")
    private String name;
    @Column(name = "ROLE_DESCRIPTION")
    private String description;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "USER_TYPE")
    private UserType userType;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ROLE_PERMISSION", joinColumns =
        @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"), inverseJoinColumns =
        @JoinColumn(name = "PERMISSION_ID", referencedColumnName = "ID") )
    private Collection<Permissions> permissions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Collection<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(Collection<Permissions> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", userType=" + userType +
                ", permissions=" + permissions +
                '}';
    }
}
