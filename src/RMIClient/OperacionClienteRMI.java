package RMIClient;

import RMIInterface.Hola;
import RMIInterface.OperacionInterfaz;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class OperacionClienteRMI {
  public static void main(String []args){
    OperacionInterfaz servidorObj;
    Hola mensaje;
    String serverAdress = "192.168.0.15";
    int serverPort = 3232;
    try{
      Registry registry = LocateRegistry.getRegistry(serverAdress,serverPort);
      servidorObj= (OperacionInterfaz)(registry.lookup("operacionservidor"));
      mensaje = (Hola)(registry.lookup("mensaje"));
      System.out.println("Mayor: "+servidorObj.calcularMayor(100,500));
      System.out.println(mensaje.hola("Cristian"));

    }catch(Exception e){
      e.printStackTrace();

    }
  }
}
