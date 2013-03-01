package se.doverfelt.dungeonCrawl.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Server {

	/**
	 * @param args
	 */
	
	public static ArrayList<Socket> sockets = new ArrayList<Socket>();
	public static ArrayList<Integer> clientStates = new ArrayList<Integer>();
	public static ArrayList<Package> packages = new ArrayList<Package>();
	
	private static Runnable accept = new Runnable() {
		
		@Override
		public void run() {
			
		}
		
	};
	
	private static Runnable send = new Runnable() {
		
		@Override
		public void run() {
			
		}
		
	};
	
	private static Runnable recieve = new Runnable() {
		
		@Override
		public void run() {
			
		}
		
	};
	
	public static void disconnectClient(int index) {
		
		try {
			clientStates.remove(index);
			sockets.remove(index);
			packages.remove(index);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static ServerSocket server;
	private int port = 1998;

	
	public Server() throws UnknownHostException, IOException {
		server = new ServerSocket(port , 0, InetAddress.getLocalHost());
		new Thread(accept).start();
	}
	
	public void stopServer() throws IOException {
		while (sockets.size() != 0) {
			for (int i = 0; i < clientStates.size(); i++) {
				clientStates.set(i, 2);
			}
		}
		
		server.close();
		
	}
	
}
