import java.rmi.*;

public class Server {
    public static void main(String a[]) throws Exception {
        AddC obj = new AddC();
        Naming.rebind("ADD", obj);
        System.out.println("Server Started");
    }
}