package com.n1amr;

import java.net.*;
import java.io.*;

public class GreetingServer extends Thread {
	private static ServerSocket serverSocket;

	public static void main(String[] args) throws IOException {
		int PORT = 6066;

		serverSocket = new ServerSocket(PORT);
		serverSocket.setSoTimeout(60000);

		Thread mThread = new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						//Connecting
						System.out
										.println("SERVER: Waiting for client on port "
														+ serverSocket.getLocalPort() + "...");
						Socket server = serverSocket.accept();
						System.out.println("SERVER: Just connected to "
										+ server.getRemoteSocketAddress());

						//Receiving
						DataInputStream in = new DataInputStream(server
										.getInputStream());
						System.out.println("SERVER: " + in.readUTF());

						//Sending
						DataOutputStream out = new DataOutputStream(server
										.getOutputStream());
						out.writeUTF("SERVER: Thank you for connecting to "
										+ server.getLocalSocketAddress() + "\nGoodbye!");

						server.close();
					} catch (SocketTimeoutException s) {
						System.out.println("SERVER: Socket timed out!");
						break;
					} catch (IOException e) {
						e.printStackTrace();
						break;
					}
				}
			}

		});
		mThread.start();
	}
}