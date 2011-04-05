
import static org.junit.Assert.*;



import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestPrintBalance{

	@Before
	public void setUp() throws Exception {
	}
	
	
	
	
	/*
	 * For all tests you will have to enter a name at least once, possibly multiple times
	 */
	
	@Test
	public void testEnglish(){
		PrintBalance pb = new PrintBalance("english");
		assertEquals(pb.currentLocale, new Locale("en","US"));
		assertEquals(pb.greeting, "Hello World");
		assertEquals(pb.askName, "Please enter your name");
		assertEquals(pb.meet, "I am pleased to meet you");
		assertEquals(pb.asof, "As of :");
		assertEquals(pb.owe, "You owe the school");
		assertEquals(pb.bye, "Good Bye");
	}
	
	@Test public void testFrench(){
		PrintBalance pb = new PrintBalance("francais");
		assertEquals(pb.currentLocale, new Locale("fr","FR"));
		assertEquals(pb.greeting, "Bonjour tout le monde");
		assertEquals(pb.askName, "S'il vous plaît entrer votre nom");
		assertEquals(pb.meet, "je suis heureux de vous rencontrer");
		assertEquals(pb.asof, "En date du:");
		assertEquals(pb.owe, "dois l'école");
		assertEquals(pb.bye, "Good Bye");
	}
	
	@Test public void testGerman(){
		PrintBalance pb = new PrintBalance("deutsch");
		assertEquals(pb.currentLocale, new Locale("de","DE"));
		assertEquals(pb.greeting, "Hallo Welt");
		assertEquals(pb.askName, "Bitte geben Sie Ihren Namen");
		assertEquals(pb.meet, "Ich freue mich, Sie kennen zu lernen");
		assertEquals(pb.asof, "Stand:");
		assertEquals(pb.owe, "Sie die Schule verdanken");
		assertEquals(pb.bye, "Good Bye");
	}
	
	@Test public void testDate(){
		PrintBalance pb = new PrintBalance("english");
		Date today = new Date();
		DateFormat date = DateFormat.getDateInstance(DateFormat.LONG, new Locale("en", "EN"));
		assertEquals(pb.date,date.format(today).toString());
		PrintBalance pbf = new PrintBalance("francais");
		Date todayf = new Date();
		DateFormat datef = DateFormat.getDateInstance(DateFormat.LONG, new Locale("fr", "FR"));
		assertEquals(pbf.date,datef.format(today).toString());
		PrintBalance pbg = new PrintBalance("deutsch");
		Date todayg = new Date();
		DateFormat dateg = DateFormat.getDateInstance(DateFormat.LONG, new Locale("de", "DE"));
		assertEquals(pb.date,dateg.format(today).toString());
	}
	
	@Test public void testCurrency(){
		PrintBalance pbe = new PrintBalance("english");
		assertEquals(pbe.currency,NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(9876543.21));
		PrintBalance pbf = new PrintBalance("francais");
		assertEquals(pbf.currency,NumberFormat.getCurrencyInstance(new Locale("fr", "FR")).format(9876543.21));
		PrintBalance pbg = new PrintBalance("deutsch");
		assertEquals(pbg.currency,NumberFormat.getCurrencyInstance(new Locale("de", "DE")).format(9876543.21));
		
	}

	@After
	public void tearDown() throws Exception {
	}

}
