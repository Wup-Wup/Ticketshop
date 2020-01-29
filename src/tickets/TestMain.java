package tickets;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain {

	static Scanner sc = new Scanner(System.in);
	static int kosten;
	static int stelle =0;
	static boolean einkauf= false;

	public static void main(String[] args) {

		Ticket[] tickets = new Ticket[3];
		Ticketwert[] wert = new Ticketwert[3];
		ArrayList<String> warenkorb = new ArrayList<String>();

		tickets[0] = new Ticket(80, Ticketarten.MUSIKTICKET);
		tickets[1] = new Ticket(50, Ticketarten.SPORTTICKET);
		tickets[2] = new Ticket(150, Ticketarten.TEATHERTICKET);
		
		wert[0] = (Ticketwert.STEHTICKET);
		wert[1] = (Ticketwert.SITZTICKET);
		wert[2] = (Ticketwert.VIPTICKET);
		
		System.out.println("Drücken Sie 1 um sich mit einem bereits existieren Account anzumelden, oder drücken Sie 2 um einen neuen Accoun zu erstellen");
		int log= sc.nextInt();
		while(log < 1 || log > 2) {
			System.out.println("Bitte 1 oder 2 eingeben");
			log = sc.nextInt();
		}
		
		if(log==1) {
			System.out.println("Benzutername:");
			String ben=sc.next();
			System.out.println("Passwort:");
			String psw=sc.next();
			if(Benutzer.checkUsn(ben)&&Benutzer.checkPsw(psw)&&Benutzer.pzaehler==Benutzer.uzaehler) {
				System.out.println("Sie sind nun als "+ben+" eingeloggt.");
			}
			while(!Benutzer.checkUsn(ben)||!Benutzer.checkPsw(psw)||Benutzer.pzaehler!=Benutzer.uzaehler){
				System.out.println("Passwort und Benutzer stimmen nicht überein. Bitte versuchen Sie es erneut.");
				System.out.println("Benzutername:");
				ben=sc.next();
				System.out.println("Passwort:");
				psw=sc.next();
			}
		}
		
		if(log==2) {
			System.out.println("Bitte geben Sie ihren gewünschten Benzuternamen ein:");
			String name=sc.next();
			System.out.println("Nun geben Sie ihr Passwort ein:");
			String psw=sc.next();
			Benutzer.register(name, psw);
		}
		
		
		//Welches Ticket
		do {
		System.out.println("Welches Ticket möchten Sie kaufen?");
		for (int i = 0; i < tickets.length; i++) {
			System.out.println("Mit " + (i+1) + " kaufen sie ein " + tickets[i].Art.Art);
		}
		int auswahl = sc.nextInt();
		while(auswahl < 1 || auswahl > tickets.length) {
			System.out.println("Bitte geben Sie ein gültiges Ticket ein.");
			auswahl = sc.nextInt();
		}
		
		//Stehticket usw.
		System.out.println("Welche Art von Ticket möchten Sie kaufen?");
		for (int i = 0; i < tickets.length; i++) {
			System.out.println("Mit " + (i+1) + " kaufen sie ein " + wert[i] + " für "+(tickets[auswahl-1].preis+wert[i].zusatz) +"€.");
		}
		int steh = sc.nextInt();
		while(steh < 1 || steh > wert.length) {
			System.out.println("Bitte geben Sie ein gültiges Ticket ein.");
			steh = sc.nextInt();
		}
		
		//Warenkorb
		warenkorb.add(tickets[auswahl-1].Art.Art+"Ticket ("+wert[auswahl-1]+")");
		kosten=kosten+tickets[auswahl-1].preis+wert[auswahl-1].zusatz;
		
		System.out.println("Das "+(tickets[auswahl-1].Art.Art+" wurde ihren Einkaufswagen hinzugefügt.\n"));
		System.out.println("Ihr derzeitiger Einkauswagen beinhaltet zu einem Preis von "+kosten+"€:");
		for(int i=0;i<warenkorb.size();i++) {
			System.out.println("•"+warenkorb.get(i));
		}
		
		//Abschluss oder Wiederholung
		System.out.println("\nUm den Einkauf fortzusetzten drücken Sie 1, um den Einkauf zu beenden drücken sie 2");
		int bestatigen = sc.nextInt();
		while(bestatigen < 1 || bestatigen > 2) {
			System.out.println("Bitte geben Sie 1 zum Fortsetzten oder 2 zum Beenden ein.");
			bestatigen = sc.nextInt();
		}
		
		if(bestatigen==1) {
			einkauf=true;
		}else {
			einkauf=false;
		}
		}while(einkauf);
	}
}