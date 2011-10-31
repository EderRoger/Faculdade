public class MyServer {
	public static void main(String args[]) throws Exception {
		TCPServer serv = new ServerHandler();
		serv.startServer(300);
	}
}
