package com.views.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Message {
    private int messageId;
    private String username;
    private String message;
    private Date mdate;

    @Id
    @Column(name = "messageid")
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "mdate")
    public Date getMdate() {
        return mdate;
    }

    public void setMdate(Date mdate) {
        this.mdate = mdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message1 = (Message) o;

        if (messageId != message1.messageId) return false;
        if (username != null ? !username.equals(message1.username) : message1.username != null) return false;
        if (message != null ? !message.equals(message1.message) : message1.message != null) return false;
        if (mdate != null ? !mdate.equals(message1.mdate) : message1.mdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = messageId;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (mdate != null ? mdate.hashCode() : 0);
        return result;
    }
}
