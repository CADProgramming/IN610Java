package pcdcollection;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class PCDCollectionApp {
	
	public static void main(String[] args) throws Exception {

		
		ArrayList<Artist> artists = new ArrayList<Artist>();
		String name;
		String emailOutput;
		
		try {
			Scanner scannerReader = new Scanner(new File("data.csv"));
			
			while (scannerReader.hasNextLine()) {
				
				ArrayList<Song> songs = new ArrayList<Song>();
				name = scannerReader.nextLine();
				
				for	(int s = 0; s < 3; s++) {
					songs.add(new Song(scannerReader.nextLine()));
				}
				
				Collections.sort(songs);
				artists.add(new Artist(name, songs));
			}
		} catch(IOException e) {
			System.out.println("IO Exception has occured");
		}
		
		Collections.sort(artists);
		CDCollection collection = new CDCollection(artists);
		
		emailOutput = collection.toString();
		System.out.println(emailOutput);
		System.out.println("********** COLLECTED OUTPUT 1 **********");
	
        System.out.println("**********");
        runProcess("javac -cp src src/pcdcollection/PhoneBookApp.java");
        System.out.println("**********");
        emailOutput += runProcess("java -cp src src/pcdcollection/PhoneBookApp.java");
        
        System.out.println("\n********** COLLECTED OUTPUT 2 **********\n");
        System.out.println("SENDING EMAIL . . .");
        
        sendEmail(emailOutput);
	}
	
	private static void sendEmail(String emailText) throws MessagingException {
	    
		String to = "Dale.Parsons@op.ac.nz";
		String from = "casd693@gmail.com";
		String username = "casd693";
		String password = "PASSWORD";
		
		Properties props = new Properties();
		props.setProperty("mail.smtp.ssl.enable", "true");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.transport.protocol", "smtp");     
	    props.setProperty("mail.host", "smtp.gmail.com");  
	    props.put("mail.smtp.auth", "true");  
	    props.put("mail.smtp.port", "465");  
	    props.put("mail.debug", "true");  
	    props.put("mail.smtp.socketFactory.port", "465");  
	    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
	    props.put("mail.smtp.socketFactory.fallback", "false");  
		
	    Session session = Session.getDefaultInstance(props,  
	    	    new javax.mail.Authenticator() {
	    	       protected PasswordAuthentication getPasswordAuthentication() {  
	    	       return new PasswordAuthentication(from,password);  
	    	   }  
	    	   });  
		
		try {
			Transport tr = session.getTransport("smtp");
			InternetAddress addressFrom = new InternetAddress(from); 
			
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);
			
			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));
			
			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			// Set Subject: header field
			message.setSubject("Lab 13 - Clayton Davidson");
			
			// Now set the actual message
			message.setText("Hi,\n\nHere is the output for both programs for lab 13:\n\n" + emailText + "\nThanks.\n\nClayton\n\nThis message was created and sent by the power of JAVA");
			
			tr.connect();
			message.saveChanges();      // don't forget this
			
			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
			tr.close();
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
	
	private static String printLines(String cmd, InputStream ins) throws Exception {
        String line = null;
        String allText = "";
        BufferedReader in = new BufferedReader(
            new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
        	allText += line + "\n";
        	System.out.println(line);
        }
        return allText;
	}
	
	 private static String runProcess(String command) throws Exception {
        Process pro = Runtime.getRuntime().exec(command);
        String allText = printLines(command + " stdout:", pro.getInputStream());
        printLines(command + " stderr:", pro.getErrorStream());
        pro.waitFor();
        System.out.println(command + " exitValue() " + pro.exitValue());
        return allText;
	 }
}
