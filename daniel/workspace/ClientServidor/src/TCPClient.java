import java.io.*;
import java.net.*;

public class TCPClient {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO code application logic here
		String sentence;
		String modifiedSentence;

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		Socket clientSocket = new Socket("127.0.0.1", 6789);
		DataOutputStream outServer = new DataOutputStream(clientSocket.getOutputStream());

		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		sentence = inFromUser.readLine();
		outServer.writeBytes(sentence + '\n');
		modifiedSentence = inFromServer.readLine();
		System.out.println("Do Servidor: " + modifiedSentence);
		Runtime.getRuntime().exec("cmd.exe /c start ping www.google.com");
		clientSocket.close();

	}
}
