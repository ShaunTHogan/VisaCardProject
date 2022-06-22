package com.cognixia.jump.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name")
	private String cardHolderName;
	@Column(unique=true, nullable=false)
	private int cardNumber;
	private LocalDate expirationDate;
	private boolean isDebit;
	private boolean isChip;
	private String design;
	
	public Card(Integer id, String cardHolderName, int cardNumber, LocalDate expirationDate, boolean isDebit,
			boolean isChip, String design) {
		super();
		this.id = id;
		this.cardHolderName = cardHolderName;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.isDebit = isDebit;
		this.isChip = isChip;
		this.design = design;
	}


	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	public boolean isDebit() {
		return isDebit;
	}
	public void setDebit(boolean isDebit) {
		this.isDebit = isDebit;
	}
	public boolean isChip() {
		return isChip;
	}
	public void setChip(boolean isChip) {
		this.isChip = isChip;
	}

	public String getDesign() {
		return design;
	}

	public void setDesign(String design) {
		this.design = design;
	}
	
	
}
