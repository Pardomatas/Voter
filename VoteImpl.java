import java.rmi.*;
import java.rmi.server.*;

public class VoteImpl extends UnicastRemoteObject
     implements VoterInterface {
  
	int yes = 0;
	int no = 0;

public VoteImpl() throws RemoteException {
      super( );
   }
  
   public String sendVote(String vote) throws RemoteException {
	   
	   if(vote.equals("yes")){
		   yes++;
	   }else if(vote.equals("no")){
		   no++;
	   }
	   
	   return "Yes = " + yes + "; No = " + no;
   }
}