package com.fsd.sba.entity;

import java.io.Serializable;
import java.util.Objects;

public class MentorTechnologyId implements Serializable {

    public MentorTechnologyId(){

    }

    public MentorTechnologyId(Long userId, Integer techId) {
        this.userId = userId;
        this.techId = techId;
    }

    private Long userId;

    private Integer techId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getTechId() {
        return techId;
    }

    public void setTechId(Integer techId) {
        this.techId = techId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MentorTechnologyId that = (MentorTechnologyId) o;
        return userId.equals(that.userId) &&
                techId.equals(that.techId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, techId);
    }
}
