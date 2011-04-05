import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * TODO A simple class that needs to be localized
 * 
 * @author mohan. Created Mar 27, 2010.
 */
public class PrintBalance {

	/**
	 * Simple Java Method that is crying out to be localized.
	 * 
	 * @param args
	 */
	public static Locale currentLocale = null;
	private static Locale eng = new Locale("en", "US");
	private static Locale frnch = new Locale("fr", "FR");
	private static Locale germ = new Locale("de", "DE");
	public static String greeting;
	public static String askName;
	public static String meet;
	public static String asof;
	public static String owe;
	public static String bye;
	public static String date;
	public static String currency;
	
	
	public PrintBalance(String current){
		if (current.toLowerCase().equals("english"))
			currentLocale = eng;
		else if (current.toLowerCase().equals("deutsch"))
			currentLocale = germ;
		else if (current.toLowerCase().equals("francais"))
			currentLocale = frnch;
		else
			currentLocale=null;
		String x[] = {"a","b"};
		this.main(x);
	}
	
	
	
	public static void main(String args[]) {
		ResourceBundle messages;
		NumberFormat owed;
		Scanner scanInput = new Scanner(System.in);
		
		
		while (currentLocale == null) {
			System.out.println("Language? Sprache? Langue?");
			String current = scanInput.nextLine();
			if (current.toLowerCase().equals("english"))
				currentLocale = eng;
			else if (current.toLowerCase().equals("deutsch"))
				currentLocale = germ;
			else if (current.toLowerCase().equals("francais"))
				currentLocale = frnch;
			else
				System.out.println("Try again");
		}
		
		//Scanner scanInput = new Scanner(System.in);
		DateFormat todayFormat = DateFormat.getDateInstance(DateFormat.LONG,
				currentLocale);
		Date today = new Date();
		owed = NumberFormat.getCurrencyInstance(currentLocale);
		messages = ResourceBundle.getBundle("MessageBundle", currentLocale);
		// Greeting

		System.out.println(messages.getString("greeting"));
		greeting = messages.getString("greeting");

		// Get User's Name
		System.out.println(messages.getString("name"));
		askName = messages.getString("name");

		String name = scanInput.nextLine();
		System.out.println(messages.getString("meet") + " " + name);
		meet = messages.getString("meet");

		// print today's date, balance and bid goodbye
		System.out.println(messages.getString("asOf") + " "
				+ todayFormat.format(today).toString());
		asof = messages.getString("asOf");
		date = todayFormat.format(today).toString();

		System.out.println(messages.getString("owe") + " "
				+ owed.format(9876543.21).toString());
		owe = messages.getString("owe");
		currency = owed.format(9876543.21);

		System.out.println(messages.getString("bye"));
		bye = messages.getString("bye");
	}
}
