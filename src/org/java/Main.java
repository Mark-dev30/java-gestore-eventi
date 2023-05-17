package org.java;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import org.java.object.Concert;

import evento.org.java.Event;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci il titolo");
		String title = sc.nextLine();
		System.out.println("Inserisci numero posti");
		int totalseats = sc.nextInt();
		sc.nextLine();
		System.out.println("Inserisci data 'yyyy-mm-dd'");
		LocalDate date = LocalDate.parse(sc.nextLine());
		Event ev = new Event(title,date,totalseats);
		booked(ev);
		cancel(ev);
		sc.close();
		LocalTime time = LocalTime.parse("15:00");
		BigDecimal bd = new BigDecimal(20.5);
		Concert cn = new Concert(ev.getTitle(), ev.getDate(), ev.getTotalseats(), time,bd);
		System.out.println("---------------");
		System.out.println(cn);
		
		
	}
	
	public static void booked(Event ev) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Vuoi prenotare?");
			String response = sc.nextLine();
			if(response.equals("no")) { 
				return;
			}
			System.out.println("Quanti posti vuoi prenotare?");
			int num = Integer.valueOf(sc.nextLine()); //Ho inserito una stringa e poi convertito in intero per il bug che salta un input
			ev.booked(num);
		}
		
	}
	public static void cancel(Event ev) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Vuoi disdire?");
			String response = sc.nextLine();
			if(response.equals("no")) { 
				return;
			}
			System.out.println("Quanti posti vuoi disdire?");
			int num = Integer.valueOf(sc.nextLine()); //Ho inserito una stringa e poi convertito in intero per il bug che salta un input
			ev.cancel(num);
		}
		
	}
	

}
