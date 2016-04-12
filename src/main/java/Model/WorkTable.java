package Model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

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
    private Date startData;
    @Column
    private Time startTime;
    @Column
    private Time endTime;

    public WorkTable() {
        super();
    }

    public WorkTable(Long id) {
        super(id);
    }

    public WorkTable(User user, Date date, Time time) {
        this.user = user;
        this.startData = date;
        this.startTime = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getStartData() {
        return startData;
    }

    public void setStartData(Date startData) {
        this.startData = startData;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
