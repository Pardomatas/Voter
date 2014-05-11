import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.net.*;

public class VoterServer{
  public static void main(String args[]){
    try{     
      int port = 16790; 
      String host = "localhost";
      VoteImpl exportedObj = new VoteImpl();
      startRegistry(port);
      String registryURL = "rmi://" + host + ":" + port + "/vote";
      LocateRegistry.getRegistry(port);
      Naming.rebind(registryURL, exportedObj);
      System.out.println("Voter Server ready.");
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  private static void startRegistry(int port)throws RemoteException{
    try{
      Registry registry = LocateRegistry.getRegistry(port);
      registry.list( ); // This call will throw an exception if the registry does not already running
    }catch (RemoteException e){ 
      // No valid registry at that port is running.
      System.out.println ("RMI registry cannot be located at port " + port);
      Registry registry = LocateRegistry.createRegistry(port);
      System.out.println("RMI registry created at port " + port);
    }
  }
}