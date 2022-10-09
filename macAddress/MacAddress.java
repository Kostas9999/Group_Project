package macAddress;

import java.io.*;
import java.net.InetAddress;
import host.Host;
public class MacAddress {
    


    public static String getMacAddrHost(String host) throws IOException, InterruptedException {
        //
        boolean ok = ping3(host);
        System.out.println(ok);
   
        if (ok) {
            InetAddress address = InetAddress.getByName(host);
            String ip = address.getHostAddress();
            return run_program_with_catching_output("arp -a " + ip);
        }
        //
        return null;
        //
    }


 public static boolean ping3(String host) throws IOException, InterruptedException {
        boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");

        new ProcessBuilder("ping", isWindows ? "-n" : "-c", "1", host).start();
       // Process proc = processBuilder.start();

       // int returnVal = proc.waitFor();
        return true;
    }

    public static String run_program_with_catching_output(String param) throws IOException {
        Process p = Runtime.getRuntime().exec(param);
        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while ((line = input.readLine()) != null) {
            if (!line.trim().equals("")) {
                // keep only the process name
                line = line.substring(1);
                System.out.println(line);
                String mac = extractMacAddr(line);
                if (mac.isEmpty() == false) {
                    return mac;
                }
            }

        }
        return null;
    }

    public static String extractMacAddr(String str) {
        String arr[] = str.split("   ");
        for (String string : arr) {
            if (string.trim().length() == 17) {
                return string.trim().toUpperCase();
            }
        }
        return "";
    }

  public static  void readFile(Host host)
    {
	  if(host.getMacAddress()!= null) {
		  
		  String str = host.getMacAddress();
		  str = str.substring(0, 8).replace("-", ":") ; 
		 
		 
		 
		 // System.exit(0);
	   
        File file = new File("mac_vendor.txt");
 
        BufferedReader br = null;
	try {
	    br = new BufferedReader(new FileReader(file));
	} catch (FileNotFoundException e) { e.printStackTrace();}
 
     
        String st;

        try {
       
	    while ((st = br.readLine()) != null) {
	    	
		String s[] = st.split("\t");
		
		
	    if(s[0].equals(str)){host.setMacVendor(s[1]); }
	    }
	    
	} catch (IOException e) {e.printStackTrace();
	}
    }}
  
  
  
  
  
  
  
  
  
	/*
	 * 
	 * public static void writeFile(String[] s) { try { FileWriter myWriter = new
	 * FileWriter("filename.txt", true); BufferedWriter bw = new
	 * BufferedWriter(myWriter); bw.newLine();
	 * 
	 * String str = s[0]; str = str.substring(0, 2) + "-" + str.substring(2,
	 * str.length()); str = str.substring(0, 5) + "-" + str.substring(5,
	 * str.length());
	 * 
	 * myWriter.write("case\t\"" + str +"\" :  return \""+ s[1] +"\";\n");
	 * bw.newLine();
	 * 
	 * myWriter.close();
	 * 
	 * } catch (IOException e) {e.printStackTrace();} }
	 */
      
      
 
   
}
