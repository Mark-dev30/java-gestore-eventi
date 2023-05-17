package evento.org.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Event {
	
	private String title;
	private LocalDate date;
	private int totalseats;
	private int seatsbooked;
	public Event(String title, LocalDate date, int totalseats) {
		try {
			setDateCondition(date);
			setTotalseatsCondition(totalseats);
			setTitle(title);
			this.seatsbooked = 0;
		} catch (Exception e) {
			System.err.println(e.getMessage());
					
		}
		
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getDate() {
		return date;
	}
	private void setDateCondition(LocalDate date) throws Exception {
		LocalDate nowdate = LocalDate.now();
		if(nowdate.isAfter(date)) throw new Exception("Devi inserire una data futura");
		setDate(date);
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	private void setTotalseatsCondition(int totalseats) throws Exception {
		if(totalseats <= 0) throw new Exception("Il numero di posti totali deve essere maggiore di 0");
		setDate(date);
		this.totalseats = totalseats;
	}
	
	public int getTotalseats() {
		return totalseats;
	}
	
	public int getSeatsbooked() {
		return seatsbooked;
	}
	public void booked(int seatbooked) {
		
		try {
			setDateCondition(this.date);
			bookedControll(seatbooked);
		} catch (Exception e) {
			
			System.err.println(e.getMessage());
		}
		
	}
	public void cancel(int seatbooked) {
		try {
			setDateCondition(this.date);
			cancelControll(seatbooked);
		} catch (Exception e) {
			
			System.err.println(e.getMessage());
		}
	}
	private void bookedControll(int seatbooked) throws Exception {
		int seat = this.seatsbooked + seatbooked;
		if(seat > this.totalseats) throw new Exception("Non ci sono posti liberi per questo numero!"
														+ "\nI posti liberi sono: " + (this.totalseats - this.seatsbooked));
		this.seatsbooked = seat;
		System.out.println("Numero posti totali: " + this.totalseats
				+ "\nNumero posti prenotati: " + this.seatsbooked
				+ "\nPosti rimanenti: " + (this.totalseats - this.seatsbooked));
	}
	private void cancelControll(int seatbooked) throws Exception {
		int seat = this.seatsbooked - seatbooked;
		if( this.seatsbooked == 0) throw new Exception("Non ci sono prenotazioni");
		this.seatsbooked = seat;
		System.out.println("Numero posti totali: " + this.totalseats
				+ "\nNumero posti prenotati: " + this.seatsbooked
				+ "\nPosti rimanenti: " + (this.totalseats - this.seatsbooked));
	}
	@Override
	public String toString() {
		
		return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ITALIAN)) + " - " + getTitle();
	}
	
}
