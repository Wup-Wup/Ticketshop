package tickets;

public enum Ticketarten {
	
	SPORTTICKET("Sport"),TEATHERTICKET("Theater"),MUSIKTICKET("Musik");

	String Art;
	
	Ticketarten(String Art){
		this.Art=Art;
	}
}
