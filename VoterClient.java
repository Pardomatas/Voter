import java.rmi.*;
import java.util.Scanner;

public class VoterClient {
	public static void main(String args[]){
		try{
			int port = 16790;         
			String host = "localhost";
			String registryURL = "rmi://" + host + ":" + port + "/vote";
			VoterInterface vote = (VoterInterface)Naming.lookup(registryURL);
			Scanner scanner = new Scanner(System.in);
			System.out.print("What is your vote?[yes|no] : ");
			
			String myvote = scanner.nextLine();
			String message = vote.sendVote(myvote);
			System.out.println(message);
		} catch (Exception e){
			e.printStackTrace();
		} 
	}
}
