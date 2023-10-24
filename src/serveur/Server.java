package serveur;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("je suis un serveur");
			ServerSocket ss = new ServerSocket(1234);
			System.out.println("j attend un client ...");
			Socket s = ss.accept(); /* stocker la réponse du serveur socket */
			System.out.println("un client est connecté");
			int op1, op2;
			String oper;
			int res = 0;

			OutputStream os = s.getOutputStream();
			InputStream is = s.getInputStream();

			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			op1 = Integer.parseInt(br.readLine());
			op2 = Integer.parseInt(br.readLine());
			oper = br.readLine();

			switch (oper) {
			case "+":
				res = op1 + op2;
				break;
			case "-":
				res = op1 - op2;
				break;
			case "*":
				res = op1 * op2;
				break;
			case "/":
				res = op1 / op2;
				break;
			}

			PrintWriter pw = new PrintWriter(os, true);
			pw.println(res);

			System.out.println("déconnection serveur");
			s.close();
			ss.close();
		} catch (Exception e) {
			e.printStackTrace();/* exception si n'y a pas des clients connectés */
		}
	}

}