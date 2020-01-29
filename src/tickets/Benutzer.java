package tickets;

import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Benutzer {
	
	static int uzaehler=0;
	static int pzaehler=0;

	public static void register(String Username, String Password) {
		FileWriter un;
		FileWriter ps;

		try {
			un = new FileWriter("C:\\Users\\Alex\\Documents\\Ticketshop\\Username.txt", true);
			un.write(Username + "\n");
			un.close();

			ps = new FileWriter("C:\\Users\\Alex\\Documents\\Ticketshop\\Passwort.txt", true);
			ps.write(Password + "\n");
			ps.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean checkUsn(String Username) {
		uzaehler=0;
		try {
			File us = new File("C:\\Users\\Alex\\Documents\\Ticketshop\\Username.txt");
			Scanner usn = new Scanner(us);
			while (usn.hasNextLine()) {
				uzaehler++;
				String datau = usn.nextLine();
				if (datau.equals(Username)) {
					usn.close();
					return true;
				}
			}
			usn.close();
		} catch (FileNotFoundException fe) {
			System.out.println("File not found");
		}	
		return false;
	}
	
	public static boolean checkPsw(String Password) {
		pzaehler=0;
		try {
			File ps = new File("C:\\Users\\Alex\\Documents\\Ticketshop\\Passwort.txt");
			Scanner psw = new Scanner(ps);
			while (psw.hasNextLine()) {
				pzaehler++;
				String data = psw.nextLine();
				if (data.equals(Password)) {
					psw.close();
					return true;
				}
			}
			psw.close();
		} catch (FileNotFoundException fe) {
			System.out.println("File not found");
		}
		return false;
	}
}