package deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * @author Lars Mortensen
 */
class DeadLockDetector implements Runnable {

  private ThreadMXBean tmxb = ManagementFactory.getThreadMXBean();
  private boolean doRun = true;
  
  public void stop() {
    this.doRun = false;
  }
  
  @Override
  public void run() {
    while (doRun) {
      long[] threadIds = tmxb.findDeadlockedThreads();
        for (long threadId : threadIds) {
            System.out.println(threadId);
        }
    }
  }
}