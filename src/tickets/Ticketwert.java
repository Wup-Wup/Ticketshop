package tickets;

public enum Ticketwert {
	
	STEHTICKET(40),SITZTICKET(60),VIPTICKET(100);
	
	int zusatz;
	
	Ticketwert(int zusatz){
		this.zusatz=zusatz;
	}

}
