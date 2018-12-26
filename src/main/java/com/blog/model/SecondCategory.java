package com.blog.model;

public class SecondCategory {
    private Integer secCategoryId;

    private String secCategoryName;

    private String secCreateTime;

    private Integer categoryId;

    public Integer getSecCategoryId() {
        return secCategoryId;
    }

    public void setSecCategoryId(Integer secCategoryId) {
        this.secCategoryId = secCategoryId;
    }

    public String getSecCategoryName() {
        return secCategoryName;
    }

    public void setSecCategoryName(String secCategoryName) {
        this.secCategoryName = secCategoryName == null ? null : secCategoryName.trim();
    }

    public String getSecCreateTime() {
        return secCreateTime;
    }

    public void setSecCreateTime(String secCreateTime) {
        this.secCreateTime = secCreateTime == null ? null : secCreateTime.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}