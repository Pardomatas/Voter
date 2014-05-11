import java.rmi.Remote;

public interface VoterInterface extends Remote {
	public String sendVote(String vote) throws java.rmi.RemoteException;
}