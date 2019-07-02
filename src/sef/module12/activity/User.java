package sef.module12.activity;

import java.io.*;

public class User implements Runnable {
	
	private String name;
	
	private InputStreamReader stream;

	private PrintWriter streamOut;

	public User(String name, InputStream stream, OutputStream streamOut) {
		this.stream = new InputStreamReader(stream);
		this.name = name;
		this.streamOut = new PrintWriter(new OutputStreamWriter(streamOut), true);
	}

	@Override
	public void run() {

		this.start();

	}

	public void start() {

		try {
			BufferedReader in = new BufferedReader(this.stream);
			String line = "";

			while((line = in.readLine()) != null) {
				for(User u: Chat.CHAT.getUsers())
					u.getStreamOut().println(this.getName()+": " + line + System.lineSeparator());
				Chat.CHAT.addMessage(this, line);
				if (line.equalsIgnoreCase("exit"))
					break;
			}
			System.out.println(line);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("User disconnect");
		}
	}

	public String getName() {

		return name;
	}
	public PrintWriter getStreamOut(){
		return streamOut;
	}
}
