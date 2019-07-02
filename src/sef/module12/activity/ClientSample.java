package sef.module12.activity;


import java.io.BufferedReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

public class ClientSample {

	public static void main(String arg[]){
		
		
		try {
			//Instantiate an instance of the Socket class and pass the network address and the port of the server the application.
			Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader( new InputStreamReader(socket.getInputStream()));
			Scanner i = new Scanner(System.in);



			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					this.start();
				}
				public void start(){
					try {
						while (true)
						System.out.println(in.readLine());
					}
					catch (IOException e){
						e.printStackTrace();
					}

				}
			});
			thread.start();

			String line="";

			while (true){
				line=i.nextLine();
				out.println(line);
				if(line.equalsIgnoreCase("exit"))
					break;
			}

			/*Thread threadIn = new Thread(new Runnable() {
				@Override
				public void run() {
					this.start();
				}

				public void start() {

					while (true) {
						line = i.nextLine();
						out.println(line);
						if (line.equalsIgnoreCase("exit"))
							break;
					}
				}
			});
			threadIn.start();*/
				//System.out.println(line);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {

		}
	}
}
