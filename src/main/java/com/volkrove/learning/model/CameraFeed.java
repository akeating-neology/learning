package com.volkrove.learning.model;

import jakarta.persistence.*;

@Entity
@Table(name="cameras")
public class CameraFeed {

    public CameraFeed(Integer id, String name, String url, Boolean active, Integer firstBehavior) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.active = active;
        this.firstBehavior = firstBehavior;
    }

    private Integer id;
    private String name;
    private String url;
    private Boolean active;
    private Integer firstBehavior;

    public CameraFeed() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "url", nullable = false)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "active", nullable = false)
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Column(name = "firstBehavior", nullable = false)
    public Integer getFirstBehavior() {
        return firstBehavior;
    }

    public void setFirstBehavior(Integer firstBehavior) {
        this.firstBehavior = firstBehavior;
    }

    @Override
    public String toString() {
        return "CameraFeed{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", active=" + active +
                ", firstBehavior=" + firstBehavior +
                '}';
    }
}
