package entity;

import java.util.Date;

public class Product {
    private int id;
    private String defaultCode;
    private boolean active;
    private int productTmplId;
    private String barcode;
    private int volume;
    private int weight;
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

    public String getDefaultCode() {
        return defaultCode;
    }

    public void setDefaultCode(String defaultCode) {
        this.defaultCode = defaultCode;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getProductTmplId() {
        return productTmplId;
    }

    public void setProductTmplId(int productTmplId) {
        this.productTmplId = productTmplId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
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
