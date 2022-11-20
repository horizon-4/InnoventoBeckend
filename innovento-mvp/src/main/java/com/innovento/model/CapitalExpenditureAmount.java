package com.innovento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "capital_expenditure_amount")
public class CapitalExpenditureAmount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false, precision = 10)
	private long id;
	private String financialResources;
	public long _2020_2021_count;
	public long _2019_2020_count;
	public long _2018_2019_count;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFinancialResources() {
		return financialResources;
	}
	public void setFinancialResources(String financialResources) {
		this.financialResources = financialResources;
	}
	public long get_2020_2021_count() {
		return _2020_2021_count;
	}
	public void set_2020_2021_count(long _2020_2021_count) {
		this._2020_2021_count = _2020_2021_count;
	}
	public long get_2019_2020_count() {
		return _2019_2020_count;
	}
	public void set_2019_2020_count(long _2019_2020_count) {
		this._2019_2020_count = _2019_2020_count;
	}
	public long get_2018_2019_count() {
		return _2018_2019_count;
	}
	public void set_2018_2019_count(long _2018_2019_count) {
		this._2018_2019_count = _2018_2019_count;
	}
	
	

}
