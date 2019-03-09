import org.apache.xmlrpc.WebServer;

public class RPCServer {
    public static void main(String[] args) {
        try {
            System.out.println("Starting XML-RPC server...");
            int port = Integer.parseInt(args[0]);
            WebServer server = new WebServer(port);

            server.addHandler("MyServer", new RPCServer());
            server.start();

            System.out.println("Server started successfully");
            System.out.println("Server listening on port " + port);
            System.out.println("Please press CTRL+C to stop server");
        } catch (Exception e) {
            System.out.println("Server XML-RPC Exception: " + e);
        }
    }

    public int echo(int leftTerm, int rightTerm) {
        return leftTerm + rightTerm;
    }

    public int echoAsynchronous(int leftTerm, int rightTerm) throws InterruptedException {
        Thread.sleep(3000);
        return leftTerm * rightTerm;
    }
}
