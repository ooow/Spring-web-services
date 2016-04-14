package com.nc.model;

import org.joda.time.Duration;

import javax.persistence.*;

import org.joda.time.DateTime;

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

    public String getWorkTime() {
        Duration duration = new Duration(endTime, startTime);
        System.out.println(duration.getStandardDays());
        System.out.println(duration.getStandardHours());
        System.out.println(duration.getStandardMinutes());
        return "" + duration.getStandardHours() + duration.getStandardMinutes();
    }
}
