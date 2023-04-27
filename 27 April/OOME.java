import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;

public class OOME {
	public static void main(String[] args) {
		RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
		String jvmName = runtimeBean.getName();
		
		System.out.println("JVM name = " + jvmName);
		
		long pid = Long.valueOf(jvmName.split("@")[0]);
		System.out.println("JVM PID = " + pid);
		
		ThreadMXBean bean = ManagementFactory.getThreadMXBean();
		int peakThreadCount = bean.getPeakThreadCount();
		
		System.out.println("Peak Thread Count = " + peakThreadCount);
		System.out.println("Total memory = " + Runtime.getRuntime().totalMemory() + " bytes");
		System.out.println("Free memory = " + Runtime.getRuntime().freeMemory() + " bytes");		
		System.out.println("Used Memory = " + (Runtime.getRuntime().totalMemory() -Runtime.getRuntime().freeMemory()) + " bytes");
		System.out.println("Max memory = " + Runtime.getRuntime().maxMemory() + " bytes");
		
		List<Object> items = new ArrayList<>(1);
		try {
			while(true) {
				items.add(new Object());
			}
		} catch (OutOfMemoryError e) {
			
			e.printStackTrace();
		}
		//assert items.size() >0;
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
