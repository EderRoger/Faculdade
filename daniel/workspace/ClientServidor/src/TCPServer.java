import java.net.*;
import java.io.*;

public class TCPServer implements Cloneable, Runnable {
	Thread runner = null;
	ServerSocket server = null;
	Socket data = null;
	volatile boolean shouldStop = false;

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public synchronized void startServer(int port) throws IOException {
		if (runner == null) {
			server = new ServerSocket(port);
			runner = new Thread(this);
			runner.start();
		}
	}

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public synchronized void stopServer() {
		if (server != null) {
			shouldStop = true;
			runner.interrupt();
			runner = null;
			try {
				server.close();
			} catch (IOException ioe) {
			}
			server = null;
		}
	}

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void run() {
		if (server != null) {
			while (!shouldStop) {
				try {
					Socket datasocket = server.accept();
					TCPServer newSocket = (TCPServer) clone();
					newSocket.server = null;
					newSocket.data = datasocket;
					newSocket.runner = new Thread(newSocket);
					newSocket.runner.start();
				} catch (Exception e) {
				}
			}
		} else {
			run(data);
		}
	}

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void run(Socket data) {
	}
}
