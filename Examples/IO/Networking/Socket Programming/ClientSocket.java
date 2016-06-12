package com.n1amr;

import java.io.*;
import java.net.Socket;
import java.util.*;

public class ClientSocket {
	public static void main(String args[]) throws IOException {
		System.out.println("--------" + ClientSocket.class + "-------");
		String SERVER_NAME = "localhost";
		int PORT = 6066;

		// Connecting
		System.out.println("CLIENT: Connecting to " + SERVER_NAME + " on port "
						+ PORT);
		Socket clientSocket = new Socket(SERVER_NAME, PORT);
		System.out.println("CLIENT: Just connected to "
						+ clientSocket.getRemoteSocketAddress());

		// Receiving
		OutputStream outToServer = clientSocket.getOutputStream();
		DataOutputStream mDataOutputStream = new DataOutputStream(outToServer);
		mDataOutputStream.writeUTF("CLIENT: Hello from "
						+ clientSocket.getLocalSocketAddress());

		// Sending
		InputStream inFromServer = clientSocket.getInputStream();
		DataInputStream mDataInputStream = new DataInputStream(inFromServer);
		System.out.println("CLIENT: Server says " + mDataInputStream.readUTF());

		clientSocket.close();

	}
}