package RMIInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OperacionInterfaz extends Remote {
  public int calcularMayor(int a, int b) throws RemoteException;
}
