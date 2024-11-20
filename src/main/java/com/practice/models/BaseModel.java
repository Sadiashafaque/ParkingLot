package com.practice.models;

import java.util.Date;

public class BaseModel {
    private long id;
    private Date createdAt;
    private Date lastupdatedAt;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getLastupdatedAt() {
        return lastupdatedAt;
    }
    public void setLastupdatedAt(Date lastupdatedAt) {
        this.lastupdatedAt = lastupdatedAt;
    }

}
