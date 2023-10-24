package client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("je suis un client pas encore connecté");
			Socket s = new Socket("192.168.56.1", 1234);
			System.out.println("je suis connecté au serveur");

			int op1, op2;
			String operation;

			OutputStream os = s.getOutputStream();
			InputStream is = s.getInputStream();

			Scanner sc = new Scanner(System.in);
			System.out.print("ecrire 1er op");
			op1 = sc.nextInt();
			System.out.print("ecrire 2eme op");
			op2 = sc.nextInt();
			do {
				System.out.print("donner l'operation (+,-,*,/): ");
				operation = sc.nextLine();
			} while (!operation.equals("+") && !operation.equals("-") && !operation.equals("*")
					&& !operation.equals("/"));

			PrintWriter pw = new PrintWriter(os, true);
			pw.println(op1);
			pw.println(op2);
			pw.println(operation);

			System.out.print(op1 + " " + operation + " " + op2 + "= "
					+ new BufferedReader(new InputStreamReader(is)).readLine());

			System.out.println("déconnection client");
			s.close();

		} catch (Exception e) {
			e.printStackTrace();/* exception si n'y a pas un serveur ou le serveur n'est pas activé */
		}

	}

}
