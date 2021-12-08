import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Nimipäiväkone {
	
	
	
																	// TO DO
																	// Nimenkorjausehdotus

    public static void main(final String[] args) {
        final JFrame frame = new JFrame("Nimipäiväkone");
       
        
        
        															// Nappuloiden ja tekstikenttien optiot
        
        JButton close = new JButton("Sos lopeta");					// Ohjelman pakkosulkunappi
        close.addActionListener(e -> System.exit(0));
        close.setBounds(100,350,150,30);
        
        JButton lopeta = new JButton("lopeta");
        lopeta.addActionListener(e -> System.exit(0));
        lopeta.setBounds(175,50,95,30);
        lopeta.setVisible(false);
        
        JButton aloitusnappi = new JButton("Aloita tästä!");
        aloitusnappi.setBounds(100,100,150,30);
        aloitusnappi.setVisible(true);
        
        JButton Valinta1 = new JButton("Nimi");
        Valinta1.setBounds(75,50,95,30);
        Valinta1.setVisible(false);
        
        JButton Valinta2 = new JButton("Pvm");
        Valinta2.setBounds(175,50,95,30);
        Valinta2.setVisible(false);
        
        JLabel text = new JLabel("Haku nimellä vai päivämäärällä?");
        text.setBounds(75,5,200,30);
        text.setVisible(false);
        
        JLabel text2 = new JLabel("Syötä Nimi");
        text2.setBounds(75,5,200,30);
        text2.setVisible(false);
        
        JLabel kirjain = new JLabel("Älä syötä kirjaimia");
        kirjain.setBounds(75,100,200,30);
        kirjain.setVisible(false);
        
        JLabel pituus = new JLabel("Liian lyhyt nimi");
        pituus.setBounds(75,100,200,30);
        pituus.setVisible(false);
        
        JLabel numero = new JLabel("Älä syötä numeroita");
        numero.setBounds(75,100,200,30);
        numero.setVisible(false);
        
        JLabel piste = new JLabel("Syötä oikea päivämäärä");
        piste.setBounds(75,100,200,30);
        piste.setVisible(false);
        
        JLabel text3 = new JLabel("Syötä päivämäärä");
        text3.setBounds(75,5,200,30);
        text3.setVisible(false);
        
        JTextField field1 = new JTextField(); 
        field1.setBounds(75,50,95,30);
        field1.setVisible(false);
        
        JTextField field2 = new JTextField(); 
        field2.setBounds(75,50,95,30);
        field2.setVisible(false);
        
        JButton hae1 = new JButton("Etsi");
        hae1.setBounds(165,50,95,30);
        hae1.setVisible(false);
        
        JButton hae2 = new JButton("Etsi");
        hae2.setBounds(165,50,95,30);
        hae2.setVisible(false);
        
        JButton takaisin = new JButton("Takaisin");
        takaisin.setBounds(250,50,95,30);
        takaisin.setVisible(false);
        
        JLabel sos1 = new JLabel("Nimellä ei löytynyt päivämäärää.");
        sos1.setBounds(70,10,380,30);
        sos1.setVisible(false);
        
        JLabel sos2 = new JLabel("Päivämäärällä ei löytynyt nimipäivää.");
        sos2.setBounds(65,10,380,30);
        sos2.setVisible(false);
        
		JLabel match1 = new JLabel();									//nimien printtaus
        match1.setBounds(100,5,200,30);
        match1.setVisible(false);
        
        JButton uudestaan = new JButton("uudestaan");
        uudestaan.setBounds(75,50,95,30);
        uudestaan.setVisible(false);
        
        JLabel terve = new JLabel("Tervetuloa Nimipäiväkoneeseen!");
        terve.setBounds(75,40,300,30);
        terve.setVisible(true);
        
        
        

    	aloitusnappi.addActionListener(new ActionListener(){  			//Aloitusnapin painalluksen actionit
        public void actionPerformed(ActionEvent e){  
        		aloitusnappi.setVisible(false);
        		terve.setVisible(false);
        		Valinta1.setVisible(true);
        		Valinta2.setVisible(true);    
        		text.setVisible(true);
        	}});  
    	
    	Valinta1.addActionListener(new ActionListener(){  				//Nimen valinnan painalluksen actionit
            public void actionPerformed(ActionEvent e){
            	field1.setText("");
            	Valinta1.setVisible(false);
            	Valinta2.setVisible(false);
            	text.setVisible(false);
            	text2.setVisible(true);
            	field1.setVisible(true);
            	hae1.setVisible(true);
            	takaisin.setVisible(true);
            }}); 
    	
    	Valinta2.addActionListener(new ActionListener(){  				//PVM valinnan painalluksen actionit
            public void actionPerformed(ActionEvent e){
            	field2.setText("");
            	Valinta1.setVisible(false);
            	Valinta2.setVisible(false); 
            	text.setVisible(false);
            	text3.setVisible(true);
            	field2.setVisible(true);
            	hae2.setVisible(true);
            	takaisin.setVisible(true);
            }}); 
    	
    	takaisin.addActionListener(new ActionListener() {				//Takaisin nappula
    		public void actionPerformed(ActionEvent e){
        		Valinta1.setVisible(true);
        		Valinta2.setVisible(true);
        		text.setVisible(true);
        		text3.setVisible(false);
            	field2.setVisible(false);
            	hae2.setVisible(false);
            	text2.setVisible(false);
            	field1.setVisible(false);
            	hae1.setVisible(false);
            	takaisin.setVisible(false);
            	numero.setVisible(false);
            	pituus.setVisible(false);
            	kirjain.setVisible(false);
            	piste.setVisible(false);
    		
    		}});
    	
    	uudestaan.addActionListener(new ActionListener(){  				//Uudestaan painalluksen actionit
            public void actionPerformed(ActionEvent e){  
            	terve.setVisible(false);
            	Valinta1.setVisible(true);
            	Valinta2.setVisible(true);    
            	text.setVisible(true);
            	sos1.setVisible(false);
            	sos2.setVisible(false);
            	lopeta.setVisible(false);
            	uudestaan.setVisible(false);
            	match1.setVisible(false);
            	hae1.setVisible(false);
            	hae2.setVisible(false);
            	
            		
            }});  
    	
    	hae1.addActionListener(new ActionListener(){  					//Nimen hakeminen ja tulosten printtaus
            public void actionPerformed(ActionEvent e){
            	nimi();
            	            	
            }
			private void nimi() {										//Nimen haun metodi
				
				
				PrintWriter writer = null;
				try {
					writer = new PrintWriter("/users/eetuturakainen/documents/nerdystuff/Nimipäiväkone/väliaikaistiedosto.txt");	//Tyhjentää tiedoston aina alussa
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				}
            	writer.print("");
            	writer.close();
            	
            	String nimi = field1.getText();		// Lukee tekstikentän ja tekee siitä Stringin nimi
            	
            										// Muuttaa inputin ekan kirjaimen isoksi ja loput pieneksi
            	nimi = nimi.substring(0,1).toUpperCase() + nimi.substring(1).toLowerCase(); 
            									
            		
            	if(nimi.matches(".*\\d.*")) {		// Jos nimessä on numeroita niin error
            		numero.setVisible(true);		// Nimessä numeroita teksti avoimeksi
            		pituus.setVisible(false);		// Kaikki muut error tekstit falseksi, tässä on vain 1 error viesti mutta pvm haussa on useampi
            		nimi();							// Takaisin nimimetodiin niin että yksi errorviesti on näkyvissä
            	}
            	
            	if(nimi.length() <=3) {				// Nimen pituus liian lyhyt
            		pituus.setVisible(true);		// nimen pituuserror näkyväksi
            		numero.setVisible(false);		// kaikki muut error tekstit pois
            		nimi();							// Nimimetodi uudestaan
            	}
            	
            	
            		
            	BufferedReader reader;
            	int printtejä = 0; 			
            	try {
            		reader = new BufferedReader(new FileReader("/users/eetuturakainen/documents/nerdystuff/Nimipäiväkone/nimilista.txt")); // Nimipäivälistan osoite 
            		String linja1 = reader.readLine();															// Lue tiedostoa rivi-riviltä
            		while (linja1 != null) { 																	// toista kunnes rivit loppuu
					
            			if (linja1.contains(nimi)) {															//jos match löytyi
            				Path p = Paths.get("/users/eetuturakainen/documents/nerdystuff/Nimipäiväkone/väliaikaistiedosto.txt"); 		//Väliaikaiseen tiedostoon kaikki matchit
            				String s = linja1 + System.lineSeparator();
            				try {
            				    Files.write(p, s.getBytes(), StandardOpenOption.APPEND);	// Kirjoitetaan väliaikaistiedostoon matchin rivi tulostusta varten
            				} catch (IOException e1) {
            				    System.err.println(e1);
            				}
            				printtejä++;													// Lisätään printteihin 1 jos match löytyy
            			}
					
            			linja1 = reader.readLine(); 										// lue seuraava rivi
						}
            		reader.close(); 														// loop loppuu
            	
            		
            	} catch (IOException e1) {													// Jos ei ole nimipäivää niin tämä piti olla, en tiedä miksi
            		e1.printStackTrace();
            	} 
				
            	finally {
            		if(printtejä ==0) { 				// jos matcheja on 0 tulosta tämä
            			sos1.setVisible(true);			// Nappulat päälle ja edelliset nappulat ja mahdolliset errorviestit pois
            			text2.setVisible(false);
                    	field1.setVisible(false);
                    	hae1.setVisible(false);
                    	hae2.setVisible(false);
                    	lopeta.setVisible(true);
                    	uudestaan.setVisible(true);
                    	numero.setVisible(false);
                    	pituus.setVisible(false);
                    	takaisin.setVisible(false);
            		}
            		else {								// Jos matcheja on väh 1 niin meni läpi
            			text2.setVisible(false);		// Nappulat päälle ja edelliset nappulat ja mahdolliset errorviestit pois
            			field1.setVisible(false);
            			hae1.setVisible(false);
            			hae2.setVisible(false);
            			match1.setVisible(true);
            			lopeta.setVisible(true);
                    	uudestaan.setVisible(true);
                    	numero.setVisible(false);
                    	pituus.setVisible(false);
                    	takaisin.setVisible(false);
                    	
            			Scanner scanner = null;										// Scanneri tyhjäksi
            			try {														// Lue väliaikaistiedosto ja printtaa ne
            				scanner = new Scanner( new File("/users/eetuturakainen/documents/nerdystuff/Nimipäiväkone/väliaikaistiedosto.txt"), "UTF-8" );
            			} 
            			
            			catch (FileNotFoundException e1) {							// Taas errorjuttu, en tiedä miksi
            				e1.printStackTrace();
            			}
            			String tulostus = scanner.useDelimiter("\\A").next();		// Tulostus -tekstikenttään importataan väliaikaistiedoston nimet
            			scanner.close();
            			match1.setText(tulostus);
            		
                	
            		}
            	}
            	return;
            	
			}});
    	
    	
    	hae2.addActionListener(new ActionListener(){  				//päivämäärän hakeminen ja tulosten printtaus
            public void actionPerformed(ActionEvent e){
            	pvm();
            	            	
            }
			private void pvm() {									// PVM haun metodi
				
				PrintWriter writer = null;
				try {												// Väliaikaistiedoston sijainti
					writer = new PrintWriter("/users/eetuturakainen/documents/nerdystuff/Nimipäiväkone/väliaikaistiedosto.txt");	
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				}
            	writer.print("");									// Tyhjentää väliaikaistiedoston
            	writer.close();										// Sulkee tyhjentäjän
            	
            	
            	String pvm = field2.getText();						// Lukee tekstikentän ja tekee siitä Stringin pvm
            	
            	if (pvm.matches(".*[a-z].*")) { 					// Jos inputissa on kirjaimia, errorviesti
            		kirjain.setVisible(true);						// Pistää kirjaintekstin päälle ja sulkee muut errorviestit
            		piste.setVisible(false);
            		pvm();											// Juoksee pvm metodin uudestaan alusta sillä erotuksella että taustalla...
            	}													// on älä syötä kirjaimia viesti
            	
            	if (!pvm.contains(".")) {							// Jos syötössä ei ole pistettä, ei ole oikea päivämäärä
            		piste.setVisible(true);							// Samat jutut kuin äsken, errorit päälle ja uudestaan
            		kirjain.setVisible(false);
            		pvm();
            	}
            	
            	
            	
            	if(pvm.endsWith (".*\\d.*"))						// Jos päivämäärä ei pääty pisteeseen, lisää piste loppuun
            	{
            	  pvm = pvm.substring(0,pvm.length() - 1) + ".";
            	}
            	
            	BufferedReader reader1;								
            	int printtejä = 0;									// asetetaan printtejä arvoksi 0
            	
            	try {												// luetaan nimilistaa
            		reader1 = new BufferedReader(new FileReader("/users/eetuturakainen/documents/nerdystuff/Nimipäiväkone/nimilista.txt"));
            		String linja2 = reader1.readLine();				// luetaan rivi riviltä
				
				
            		while (linja2 != null) { 						// toista kunnes rivit loppuu
					
					
            			if (linja2.startsWith(pvm)) { 				// jos match löytyi
            				Path p = Paths.get("/users/eetuturakainen/documents/nerdystuff/Nimipäiväkone/väliaikaistiedosto.txt"); 	
            				String s = linja2 + System.lineSeparator();
            				try {
            				    Files.write(p, s.getBytes(), StandardOpenOption.APPEND);	// Kirjoitetaan väliaikaistiedostoon matchin rivi tulostusta varten
            				} catch (IOException e1) {
            				    System.err.println(e1);
            				}
            				printtejä++;							// Jokaisesta matchista printtejä +1
            			}
    					
            			linja2 = reader1.readLine();				//lue seuraava rivi
						}
            		reader1.close();								//loop loppuu
            														
            	} catch (IOException e1) {							// Jos ei ole nimipäivää niin menee tämän kautta en tiedä miksi
            		e1.printStackTrace();
            	} 
				
            	finally {
            		if(printtejä ==0) { 							// jos matcheja, eli printtejä on 0, Suorita tämä
            			sos2.setVisible(true);						// Suljetaan kaikki mahdolliset errorviestit ja avataan uudet nappulat
            			text3.setVisible(false);
                    	field2.setVisible(false);
                    	hae1.setVisible(false);
                    	hae2.setVisible(false);
                    	lopeta.setVisible(true);
                    	uudestaan.setVisible(true);
                    	kirjain.setVisible(false);
                    	piste.setVisible(false);
                    	takaisin.setVisible(false);
                    	
            		}
            		else {											// Jos tuli match niin suorita tämä
            			text3.setVisible(false);					// Vanhat nappulat ja errorviestit suljetaan ja avataan uudet
            			field2.setVisible(false);
            			hae1.setVisible(false);
            			hae2.setVisible(false);
            			match1.setVisible(true);
            			lopeta.setVisible(true);
                    	uudestaan.setVisible(true);
                    	kirjain.setVisible(false);
                    	piste.setVisible(false);
                    	takaisin.setVisible(false);
                    	
                    	
            			Scanner scanner = null;						
            			try {
            				scanner = new Scanner( new File("/users/eetuturakainen/documents/nerdystuff/Nimipäiväkone/väliaikaistiedosto.txt"), "UTF-8" );
            			} 
            			
            			catch (FileNotFoundException e1) {
            				e1.printStackTrace();				// Taas errorjuttu en tiedä miksi
            			}
            			String tulostus1 = scanner.useDelimiter("\\A").next();
            			scanner.close();
            			match1.setText(tulostus1);				// Tulostus -tekstikenttään importataan väliaikaistiedoston nimet
            		}
 
            	}
			
			}});
    	

    							// Kaikki mahdolliset nappulat tässä
    	
    	frame.add(close);		// Sulje
    	frame.add(aloitusnappi);// aloitusnappi
    	frame.add(Valinta1); 	// Nimen etsintä
    	frame.add(Valinta2); 	// Pvm etsintä
    	frame.add(hae1);		// Nimen etsintänappula
    	frame.add(hae2);		// pvm etsintänappula
    	frame.add(uudestaan);	// Uudestaan
    	frame.add(lopeta);		// Lopeta
    	frame.add(terve);		// Tervetuloa teksti
    	frame.add(kirjain);		// Sisältää kirjaimen
    	frame.add(numero);		// Sisältää numeron
    	frame.add(pituus);		// Liian lyhyt
    	frame.add(piste);		// Sisältää pisteen
    	
    	frame.add(text);		// Kumpaa haet- teksti
    	frame.add(text2);		// Syötä nimi
    	frame.add(text3);		// Syötä pvm
    	frame.add(field1);		// Nimen syöttöalue
    	frame.add(field2); 		// Pvm syöttöalue
    	frame.add(sos1);		// Ei matcheja
    	frame.add(sos2);		// -..-
    	frame.add(match1);		//Tekstijuttu
    	frame.add(takaisin);	//takasi nappi
    	
    	frame.setSize(350,400);  
    	frame.setLayout(null);  
    	frame.setVisible(true);  

    }
}
