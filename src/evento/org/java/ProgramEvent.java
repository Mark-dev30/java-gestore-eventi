package evento.org.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProgramEvent {
	private String title;
	List<Event> events = new ArrayList<>();
	public ProgramEvent(String title) {
		setTitle(title);
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void addEvent(Event event) {
		this.events.add(event);
	}
	
	public void getDataList(LocalDate date) {
		
		for(Event val : this.events) {
			if(date.equals(val.getDate())) System.out.println(val);
			
		}
		
	}
	public void getsizeList() {
		System.out.println("Numero eventi:" + this.events.size());
	}
	public void getClearList() {
		this.events.clear();
	}
	public void getOrderList() {
		Set<Event> myList = new HashSet<>();
		for(int i = 0; i<events.size(); i++) {
			myList.add(events.get(i));
		}
		
		for(Event val : myList) {
			System.out.println("\n" + val.getDate() + "-" + val.getTitle());
		}
	}
	
}
