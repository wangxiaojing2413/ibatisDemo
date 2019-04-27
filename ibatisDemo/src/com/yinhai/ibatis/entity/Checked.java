package com.yinhai.ibatis.entity;

/**
 * Created by zuoyao on 2018/9/16.
 */
public class Checked {
    private Integer id;
    private String username;
    private Boolean checked;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "Checked{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", checked=" + checked +
                '}';
    }
}
