package com.fsd.sba.entity;

import javax.persistence.*;


@Entity
@Table(name = "MENTOR_TECHNOLOGIES")
@IdClass(MentorTechnologyId.class)
public class MentorTechnology {

	public MentorTechnology() {

	}

	@Id
    private Long userId;

    @Id
    private Integer techId;

	@Column(name = "YEARS")
	private String years;


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

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	@Override
	public String toString() {
		return "MentorTechnology{" +
				"userId=" + userId +
				", techId=" + techId +
				", years='" + years + '\'' +
				'}';
	}
}