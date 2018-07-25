package com.views.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Essay {
    private int essayId;
    private Integer userId;
    private String essayname;
    private String text;
    private Timestamp time;

    @Id
    @Column(name = "essayid", nullable = false)
    public int getEssayId() {
        return essayId;
    }

    public void setEssayId(int essayId) {
        this.essayId = essayId;
    }

    @Basic
    @Column(name = "userid", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "essayname", nullable = false, length = 60)
    public String getEssayname() {
        return essayname;
    }

    public void setEssayname(String essayname) {
        this.essayname = essayname;
    }

    @Basic
    @Column(name = "text", nullable = false, length = -1)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "time", nullable = false)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Essay essay = (Essay) o;

        if (essayId != essay.essayId) return false;
        if (userId != null ? !userId.equals(essay.userId) : essay.userId != null) return false;
        if (essayname != null ? !essayname.equals(essay.essayname) : essay.essayname != null) return false;
        if (text != null ? !text.equals(essay.text) : essay.text != null) return false;
        if (time != null ? !time.equals(essay.time) : essay.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = essayId;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (essayname != null ? essayname.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
