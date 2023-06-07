package com.volkrove.learning.model;


import jakarta.persistence.*;

@Entity
@Table(name="ocr_behaviors")
public class OcrBehavior {

    public OcrBehavior(Integer id, Integer xCord, Integer yCord, Integer height, Integer width, String sanityRegex, Integer sampleRate, Integer nextBehavior) {
        this.id = id;
        this.xCord = xCord;
        this.yCord = yCord;
        this.height = height;
        this.width = width;
        this.sanityRegex = sanityRegex;
        this.sampleRate = sampleRate;
        this.nextBehavior = nextBehavior;
    }


    private Integer id;
    private Integer xCord;
    private Integer yCord;
    private Integer height;
    private Integer width;
    private String sanityRegex;

    private Integer sampleRate;

    private Integer nextBehavior;

    public OcrBehavior() {

    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="behavior_id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="x_cord", nullable = false)
    public Integer getxCord() {
        return xCord;
    }

    @Column(name="y_cord", nullable = false)
    public void setxCord(Integer xCord) {
        this.xCord = xCord;
    }

    public Integer getyCord() {
        return yCord;
    }

    public void setyCord(Integer yCord) {
        this.yCord = yCord;
    }

    @Column(name="height", nullable = false)
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Column(name="width", nullable = false)
    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Column(name="sanity_regex", nullable = false)
    public String getSanityRegex() {
        return sanityRegex;
    }

    public void setSanityRegex(String sanityRegex) {
        this.sanityRegex = sanityRegex;
    }

    @Column(name="sample_rate", nullable = false)
    public Integer getSampleRate() {
        return sampleRate;
    }

    public void setSampleRate(Integer sampleRate) {
        this.sampleRate = sampleRate;
    }

    @Column(name="next_behavior", nullable = false)
    public Integer getNextBehavior() {
        return nextBehavior;
    }

    public void setNextBehavior(Integer nextBehavior) {
        this.nextBehavior = nextBehavior;
    }

    @Override
    public String toString() {
        return "OcrBehavior{" +
                "id=" + id +
                ", xCord=" + xCord +
                ", yCord=" + yCord +
                ", height=" + height +
                ", width=" + width +
                ", sanityRegex='" + sanityRegex + '\'' +
                ", sampleRate=" + sampleRate +
                ", nextBehavior=" + nextBehavior +
                '}';
    }
}
