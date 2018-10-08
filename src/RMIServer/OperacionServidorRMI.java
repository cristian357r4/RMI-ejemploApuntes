package RMIServer;

import RMIInterface.OperacionInterfaz;

import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class OperacionServidorRMI extends UnicastRemoteObject implements OperacionInterfaz {
  private static final long serialVersionUID = 0L;
  private final int PUERTO = 3232;

  protected OperacionServidorRMI() throws RemoteException {
  }

  public static void main(String[] args) throws Exception {
    new OperacionServidorRMI().iniciarServidor();
  }

  private void iniciarServidor() {
    try {
      String dirIP = (InetAddress.getLocalHost()).toString();
      System.out.println("Escuchado en .. " + dirIP + ":" + PUERTO);
      Registry registry = LocateRegistry.createRegistry(PUERTO);
      registry.bind("operacionservidor", (OperacionInterfaz) this);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public int calcularMayor(int num1, int num2) throws RemoteException {
    return (num1 > num2) ? num1 : num2;
  }
}
