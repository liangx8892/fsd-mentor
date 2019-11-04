package com.fsd.sba.entity;

import javax.persistence.*;


@Entity
@Table(name = "TECHNOLOGY")
public class Technology {
	
	public Technology() {
		
	}
	
	public Technology(String name, String description, Double baseFee) {
		this.name = name;
		this.description = description;
		this.baseFee = baseFee;
	}

    @Id
	@Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "NAME")
    private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "BASE_FEE")
	private Double baseFee;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getBaseFee() {
		return baseFee;
	}

	public void setBaseFee(Double baseFee) {
		this.baseFee = baseFee;
	}

	@Override
	public String toString() {
		return "Technology{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", baseFee=" + baseFee +
				'}';
	}
}