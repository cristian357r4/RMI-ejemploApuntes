package RMIInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hola extends Remote {
    String hola(String mensaje) throws RemoteException;
}
