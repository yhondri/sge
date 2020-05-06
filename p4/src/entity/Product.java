package entity;

import java.util.Date;

public class Product {
    private int id;
    private boolean defaultCode;
    private boolean active;
    private String barcode;
    private double volume;
    private double weight;
    private Date messageLastPost;
    private Date activityDateDeadline;
    private int createUID;
    private Date createDate;
    private int writeUID;
    private Date writeDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getDefaultCode() {
        return defaultCode;
    }

    public void setDefaultCode(boolean defaultCode) {
        this.defaultCode = defaultCode;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Date getMessageLastPost() {
        return messageLastPost;
    }

    public void setMessageLastPost(Date messageLastPost) {
        this.messageLastPost = messageLastPost;
    }

    public Date getActivityDateDeadline() {
        return activityDateDeadline;
    }

    public void setActivityDateDeadline(Date activityDateDeadline) {
        this.activityDateDeadline = activityDateDeadline;
    }

    public int getCreateUID() {
        return createUID;
    }

    public void setCreateUID(int createUID) {
        this.createUID = createUID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getWriteUID() {
        return writeUID;
    }

    public void setWriteUID(int writeUID) {
        this.writeUID = writeUID;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }
}
