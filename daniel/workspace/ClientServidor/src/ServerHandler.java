import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class ServerHandler extends TCPServer {
	public void run(Socket data) {
		try {
			// InputStream is = data.getInputStream();
			// OutputStream os = data.getOutputStream();
			// Process the data socket here.
			String clientSentence = null;
			String capitalizedSentence = "";
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(data.getInputStream()));
			;
			DataOutputStream outToClient = new DataOutputStream(data.getOutputStream());
			clientSentence = inFromClient.readLine();
			capitalizedSentence = clientSentence.toUpperCase() + '\n';
			outToClient.writeBytes(capitalizedSentence);
			
			
			
		} catch (Exception e) {
		}
	}
}
