package iPv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;

public class MyIp {
    

public static String getLocalIP() throws IOException {
    
    try (final DatagramSocket datagramSocket = new DatagramSocket()) {
	
	// attempt to make connection so datagram will created with current Ip
	    datagramSocket.connect(InetAddress.getByName("8.8.8.8"), 12345);
	    return datagramSocket.getLocalAddress().getHostAddress();
	 
	}
    
}

public static short getLocalIpPrefixLength() throws IOException {
    
    NetworkInterface networkInterface = NetworkInterface.getByInetAddress( InetAddress.getByName(getLocalIP())); 	 
    return networkInterface.getInterfaceAddresses().get(0).getNetworkPrefixLength();}



public static String getPublicIP() throws IOException {

    URL url = new URL("http://checkip.amazonaws.com/");
    try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
        return br.readLine();
    }
}


}
