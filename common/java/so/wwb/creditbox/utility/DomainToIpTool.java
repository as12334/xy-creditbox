package so.wwb.creditbox.utility;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by ronnie on 18-6-13.
 */
public class DomainToIpTool {

    public  static  String getDomainToIp(String domain) {
        String ip=null;
        InetAddress[] addresses = new InetAddress[0];
        try {
            addresses = InetAddress.getAllByName(domain);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        InetAddress address = null;
        try {
            address = InetAddress.getByName(domain);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        for(int i=0; i < addresses.length; i++) {
            ip=address.getHostAddress();
        }
        return ip;
    }
}

