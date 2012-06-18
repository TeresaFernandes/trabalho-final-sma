import java.io.File;

import massim.test.InvalidConfigurationException;

public class RunServer {

	public static String conf = "2011-tournament1.xml";

	// -ea -Dcom.sun.management.jmxremote -Xss10000k -Xmx600M -DentityExpansionLimit=1000000 -DelementAttributeLimit=1000000 -Djava.rmi.server.hostname=localhost
	public static void main(String[] args) {
		try {
			massim.server.Server.main(("--conf " + conf).split(" "));
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}
}
