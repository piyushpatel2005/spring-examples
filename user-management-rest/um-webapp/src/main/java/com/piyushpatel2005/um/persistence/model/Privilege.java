package com.piyushpatel2005.um.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.piyushpatel2005.common.interfaces.INameableDto;
import com.piyushpatel2005.common.persistence.model.INameableEntity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Privilege implements INameableEntity, INameableDto {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "PRIV_ID")
  private Long id;

  @Column(unique = true, nullable = false)
  private String name;

  @Column(unique = false, nullable = false)
  private String description;

  @JsonIgnore
  @ManyToMany(mappedBy = "privileges", fetch = FetchType.EAGER)
  private Set<Role> roles;

  public Privilege() {
    super();
  }

  public Privilege(final String nameToSet) {
    super();
    name = nameToSet;
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(final Set<Role> roles) {
    this.roles = roles;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final Privilege other = (Privilege) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return getName();
  }
}