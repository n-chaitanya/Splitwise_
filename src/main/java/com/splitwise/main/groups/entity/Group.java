package com.splitwise.main.groups.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "grp")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gid;

    private String gname;

    // Constructors
    public Group() {

    }

    public Group(String gname) {
        this.gname = gname;
    }

    // Getters and setters
    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    // Other methods
    @Override
    public String toString() {
        return "Group{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(gid, group.gid) &&
                Objects.equals(gname, group.gname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gid, gname);
    }


}
