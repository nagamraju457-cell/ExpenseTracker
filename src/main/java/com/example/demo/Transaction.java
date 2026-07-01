package com.example.demo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String category;
	private String description;
	private Double amount;
	private LocalDate date;
	@Enumerated(EnumType.STRING)
	private TransactionType type;
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(Long id, String category, String description, Double amount, LocalDate date,
			TransactionType type) {
		super();
		this.id = id;
		this.category = category;
		this.description = description;
		this.amount = amount;
		this.date = date;
		this.type = type;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public TransactionType getType() {
		return type;
	}
	public void setType(TransactionType type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", category=" + category + ", description=" + description + ", amount="
				+ amount + ", date=" + date + ", type=" + type.toString() + "]";
	}
	
	

}
