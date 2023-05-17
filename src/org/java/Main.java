package org.java;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import org.java.object.Concert;

import evento.org.java.Event;
import evento.org.java.ProgramEvent;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProgramEvent program = new ProgramEvent("Nuovo Programma");
		System.out.println("Quanti eventi vuoi inserire?");
		int response = sc.nextInt();
		for(int i=0; i<response; i++) {
			newEvent(program);
			
		}
		LocalDate date = LocalDate.of(2023,10,10);
		program.getDataList(date);
		program.getOrderList();
		program.getsizeList();
		sc.close();
			
				
			
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Inserisci il titolo");
//		String title = sc.nextLine();
//		System.out.println("Inserisci numero posti");
//		int totalseats = sc.nextInt();
//		sc.nextLine();
//		System.out.println("Inserisci data 'yyyy-mm-dd'");
//		LocalDate date = LocalDate.parse(sc.nextLine());
//		
//		Event ev = new Event(title,date,totalseats);
//		Event ev5 = new Event("prova5",date,4);
//		booked(ev);
//		cancel(ev);
//		sc.close();
//		LocalTime time = LocalTime.parse("15:00");
//		BigDecimal bd = new BigDecimal(20.5);
//		Concert cn = new Concert("Concerto 1", ev.getDate(), ev.getTotalseats(), time,bd);
//		System.out.println("---------------");
//		System.out.println(cn);
//		ProgramEvent program = new ProgramEvent("Nuovo Programma");
//		program.addEvent(ev);
//		program.addEvent(ev5);
//		program.getOrderList();
		
}
	public static void newEvent(ProgramEvent program) {
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
			program.addEvent(ev);
	}
	
	public static void booked(Event ev) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Quanti posti vuoi prenotare?");
		int num = sc.nextInt(); 
		ev.booked(num);
		
			
		
		
	}
	public static void cancel(Event ev) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Quanti posti vuoi disdire?");
		int num = sc.nextInt();
		ev.cancel(num);
		
	}
	

}
