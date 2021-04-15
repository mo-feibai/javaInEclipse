package intertProgramming;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String[] args) {
		InetAddress address = null;
		InetAddress address1 = null;
		InetAddress address2 = null;
		InetAddress localhost = null;
		try {
			address = InetAddress.getByName("localhost");
			address1 = InetAddress.getByName("www.baidu.com");
			address2 = InetAddress.getByName("www.apple.com");
			localhost = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {

			e.printStackTrace();
		}
		System.out.println(address);
		System.out.println(address1.getHostName());
		System.out.println(address1.getHostAddress());
		try {
			System.out.println(address2.isReachable(1000));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println(localhost);
	}
}
