package com.datingapp.authdemo.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Datingapp on 21.03.2020
 *
 * @author volkanulutas
 */
@MappedSuperclass
public abstract class BaseEntity<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private T id;

    @Column(name = "created_date")
    @Temporal(value = TemporalType.DATE)
    private Date createdDate;

    @Column(name = "last_modified_date")
    @Temporal(value = TemporalType.DATE)
    private Date lastModifiedDate;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
