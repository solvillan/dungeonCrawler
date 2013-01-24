package se.doverfelt.dungeonCrawl.client;

//Remember: Link to guide!
//http://edn.embarcadero.com/article/31995

import java.net.*;
import java.io.*;

import org.newdawn.slick.util.Log;

public class ClientSocket {
	
	private static InetAddress address;
	private static Socket connection;
	private static ObjectOutputStream out;
	private static ObjectInputStream in;
	
	public ClientSocket(String host) {
		
		int port = 1998;
		
	    Log.info("Client socket initialized");
	    
	    try {
	    	
	    	Log.info("Attempting connection to: " + host);
	    	
	    	address = InetAddress.getByName(host);
	    	
	    	connection = new Socket(address, port);
	    	
	    	Log.info("Connected to: " + connection.getInetAddress().getHostName());
	    	
	    	out = new ObjectOutputStream(connection.getOutputStream());
	    	out.flush();
	    	
	    	in = new ObjectInputStream(connection.getInputStream());
	    	
	    	Log.info("Streams setup");
	    	
	    } catch (EOFException e) {
	    	e.printStackTrace();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
		
	}
	
	public static InetAddress getAddress() {
		return address;
	}
	
	public static Socket getConnection() {
		return connection;
	}
	
	public static ObjectOutputStream getOutput() {
		return out;
	}
	
	public static ObjectInputStream getInput() {
		return in;
	}
	
}
