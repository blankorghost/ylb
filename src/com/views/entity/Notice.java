package com.views.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Notice {
    private int nid;
    private String ncontent;
    private Timestamp ntime;

    @Id
    @Column(name = "nid")
    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    @Basic
    @Column(name = "ncontent")
    public String getNcontent() {
        return ncontent;
    }

    public void setNcontent(String ncontent) {
        this.ncontent = ncontent;
    }

    @Basic
    @Column(name = "ntime")
    public Timestamp getNtime() {
        return ntime;
    }

    public void setNtime(Timestamp ntime) {
        this.ntime = ntime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notice notice = (Notice) o;

        if (nid != notice.nid) return false;
        if (ncontent != null ? !ncontent.equals(notice.ncontent) : notice.ncontent != null) return false;
        if (ntime != null ? !ntime.equals(notice.ntime) : notice.ntime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nid;
        result = 31 * result + (ncontent != null ? ncontent.hashCode() : 0);
        result = 31 * result + (ntime != null ? ntime.hashCode() : 0);
        return result;
    }
}
