
public class MultiThread {
    public static void main(String[] args) {
		// get Java MXBean
	ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

		ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
		
		for (ThreadInfo threadInfo : threadInfos) {
			System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
		}
	}
}