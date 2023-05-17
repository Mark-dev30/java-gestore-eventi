package org.java.object;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import evento.org.java.Event;

public class Concert extends Event{
	private LocalTime hour = LocalTime.now();
	private BigDecimal price;
	
	public Concert(String title, LocalDate date, int totalseats, LocalTime hour, BigDecimal price) {
		super(title, date, totalseats);
		this.hour = hour;
		this.price = price;
		
	}

	public LocalTime getHour() {
		return hour;
	}

	public void setHour(LocalTime hour) {
		this.hour = hour;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	private String getStringDateHour() {
		String date = getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ITALIAN));
		String hour = this.hour.toString();
		return  "Data: " + date + " Ora: "+ hour;
	}
	
	private String getStringPrice() {
		String price = this.price.toString();
		return "Prezzo: " + price;
	}
	@Override
	public String toString() {
		
		return getStringDateHour() + " - " + "Titolo: " +  getTitle() + getStringPrice();
	}
	
}
