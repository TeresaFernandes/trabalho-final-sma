public class RunMonitor {

	// -Xss20000k
	public static void main(String[] args) {
		massim.competition2011.monitor.GraphMonitor.main("-rmihost 127.0.0.1 -rmiport 1099 -savexmls".split(" "));
	}
}
