package com.nc.model;

import org.joda.time.DateTime;

import javax.persistence.*;


/**
 * Created by Гога on 11.04.2016.
 */
@Entity
@Table(name = "worktable")
public class WorkTable extends Model {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column
    private DateTime startTime = null;
    @Column
    private DateTime endTime = null;
    @Column
    private DateTime workTime = null;

    public WorkTable() {
        super();
    }

    public WorkTable(Long id) {
        super(id);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }

    public void setWorkTime(DateTime workTime) {
        this.workTime = workTime;
    }

    public DateTime getWorkTime() {
        return workTime;
    }
}
