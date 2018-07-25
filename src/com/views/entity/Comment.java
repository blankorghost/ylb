package com.views.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Comment {
    private int cid;
    private Timestamp cdate;
    private String ccontent;
    private String cessay;
    private Integer userId;
    private String username;

    @Id
    @Column(name = "cid")
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "cdate")
    public Timestamp getCdate() {
        return cdate;
    }

    public void setCdate(Timestamp cdate) {
        this.cdate = cdate;
    }

    @Basic
    @Column(name = "ccontent")
    public String getCcontent() {
        return ccontent;
    }

    public void setCcontent(String ccontent) {
        this.ccontent = ccontent;
    }

    @Basic
    @Column(name = "cessay")
    public String getCessay() {
        return cessay;
    }

    public void setCessay(String cessay) {
        this.cessay = cessay;
    }

    @Basic
    @Column(name = "userid")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }






    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (cid != comment.cid) return false;
        if (cdate != null ? !cdate.equals(comment.cdate) : comment.cdate != null) return false;
        if (ccontent != null ? !ccontent.equals(comment.ccontent) : comment.ccontent != null) return false;
        if (cessay != null ? !cessay.equals(comment.cessay) : comment.cessay != null) return false;
        if (userId != null ? !userId.equals(comment.userId) : comment.userId != null) return false;
        if (username != null ? !username.equals(comment.username) : comment.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cid;
        result = 31 * result + (cdate != null ? cdate.hashCode() : 0);
        result = 31 * result + (ccontent != null ? ccontent.hashCode() : 0);
        result = 31 * result + (cessay != null ? cessay.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }
}
