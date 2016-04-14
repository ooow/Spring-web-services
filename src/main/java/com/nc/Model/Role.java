package com.nc.model;

import javax.persistence.*;

/**
 * Created by Гога on 11.04.2016.
 */

@Entity
@Table(name = "roles", uniqueConstraints = @UniqueConstraint(columnNames = "title"))
public class Role extends Model {
    @Column
    private String title;

    public Role() {
        super();
    }

    public Role(Long id) {
        super(id);
    }

    public Role(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "    title: " + title + "\n";
    }
}
