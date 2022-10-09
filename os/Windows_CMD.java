package os;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import host.Host;

public class Windows_CMD {

    public static String run_CMD(String param)  {
	
	String line = "";
        Process p = null;
	try {
	    p = Runtime.getRuntime().exec(param);
	    
	 
	    
	} catch (IOException e) {
	    
	   System.out.println("Error in executing CMD command " + e); 
	}    
        
    
        try (Scanner input = new Scanner(p.getInputStream(), "IBM850");){
            
            input.useDelimiter("\n");
       	   
            while ( input.hasNext()) { line += input.next()+"\t"; }
       	    return line;
       	    
       	    //sc.close();
            /*
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream())); 
	    while ( input.readLine() != null) { line += input.readLine()+"\n"; }
	    input.close();
	    */
	} catch ( NullPointerException e) {
	    
	   System.err.println("Error reading CMD Output \n" + e); 
	}       
        
        return line;
    }
    
    
    
    // extract mac from "arp -a ip"
    public static void getMacByIp(Host host)  {

	String arp_A = "arp -a " + host.getAddress().toString().substring(1);
	
        String arr[] = null;
	arr = run_CMD(arp_A).split("   ");
        for (String string : arr) {
        
   
            if (string.trim().length() == 17) {
        	    String  s = string.trim().toUpperCase();
        	   // System.out.println(s);
                host.setMacAddress(s); 
                break;
            }            
            
            }
        }
    
    
    //ping -a -n 1  192.168.0.8
    public static void getHostName(Host host) 
    {
	String hostAddress = host.getAddress().toString().substring(1);
	String hostname = "ping -a -n 1 " + hostAddress;
	
        String arr[] = null;
	arr = run_CMD(hostname).split(" ");
       // if(arr[1].equals(hostAddress)) {host.setHostName(null); }
	if(!arr[1].equals(hostAddress)) {host.setHostName(arr[1].toString());}
    }
    
    
    }