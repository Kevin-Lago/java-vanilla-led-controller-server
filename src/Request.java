import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Request {
    private Method method;
    private Map<String, String> headers;
    private Color color;

    public Request() {

    }

    public Request(Socket socket) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            OutputStream out = new BufferedOutputStream(socket.getOutputStream());
            PrintStream pout = new PrintStream(out);
            String line = in.readLine();

            if (line != null) {
                String[] s = line.split("/");
                this.method = Method.valueOf(s[0].trim());

                while((line = in.readLine()) != null) {
                    s = line.split(":", 2);

                    if (s.length == 2) {
                        addHeader(s);
                        System.out.println(s[0] + " header added with value: " + s[1]);
                    } else {
                        System.out.println("Finished adding headers");
                        break;
                    }
                }

                if (this.method == Method.POST) {
                    while((line = in.readLine()) != null) {
                        this.color = new Color(line.split(","));
                    }
                }
            }

            System.out.println();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public enum Method {
        GET,
        POST
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public void addHeader(String[] s) {
        if (headers == null) headers = new HashMap<>();
        this.headers.put(s[0], s[1]);
    }
}
