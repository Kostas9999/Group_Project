package host;

import java.net.InetAddress;
import java.util.HashMap;


public class Host {
	
	private InetAddress address;
	

	public HashMap<Integer, String> ports ;
	private String macAddress,macVendor, hostName;

	public static int totalHosts;
	
	@Override
	public String toString() {
	    
	    String hostname = getHostName() == null?"":"\nHostname: " + getHostName();
	    String macAddress = getMacAddress() == null?"":"\nmacAddress: " + getMacAddress();
	    String macVendor = getMacVendor() == null?"":"\nmacVendor: " + getMacVendor() ;
	    
	    return "Host IP: " + address.toString().substring(1) 
		    + hostname
		    + macAddress
		    + macVendor
		    + "\nports= " + getPorts().entrySet() + "\n";
	}



	public Host(InetAddress address) {
		
		this.address = address;
	
		totalHosts++;
	}
	
	public String getMacVendor() {
	    	
	    	return macVendor;
	}



	public void setMacVendor(String macVendor) {
		this.macVendor = macVendor;
	}

	
	
	public String getHostName() {
	    
	    return hostName;
	}


	public void setHostName(String hostName) {
	    String hostnm = hostName.equals(address.toString().substring(1))? "":hostName;
	    this.hostName = hostnm;
	}




	public InetAddress getAddress() {
		return address;
	}


	public void setAddress(InetAddress address) {
		this.address = address;
	}


	public HashMap<Integer,String> getPorts() {
		return this.ports;
	}


	
	  public void setPorts(HashMap<Integer,String> ports) { this.ports = ports; }
	 


	public String getMacAddress() {
	    
	     return this.macAddress;
	}


	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}


	
	
	
	
}
