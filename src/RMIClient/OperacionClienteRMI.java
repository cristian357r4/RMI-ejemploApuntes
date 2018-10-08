package RMIClient;

import RMIInterface.OperacionInterfaz;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class OperacionClienteRMI {
  public static void main(String []args){
    OperacionInterfaz servidorObj;
    String serverAdress = "localhost";
    int serverPort = 3232;
    try{
      Registry registry = LocateRegistry.getRegistry(serverAdress,serverPort);
      servidorObj= (OperacionInterfaz)(registry.lookup("operacionservidor"));
      System.out.println("Mayor: "+servidorObj.calcularMayor(15,15));

    }catch(Exception e){
      e.printStackTrace();

    }
  }
}
