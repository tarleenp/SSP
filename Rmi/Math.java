import java.rmi.*;
public interface Math extends Remote
{
   //declaring the method prototype 
   public int add(int n1 , int n2) throws RemoteException;

}

