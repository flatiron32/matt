package matt;

import java.util.HashSet;
import java.util.Set;

public final class MonitoringEngine {

  private static MonitoringEngine instance = new MonitoringEngine();
  private Set<MonitorProcessor> processors = new HashSet<>();

  private MonitoringEngine() {}

  public static MonitoringEngine getInstance() {
    return instance;
  }

  public void addProcessor(MonitorProcessor monitorProcessor) {
    processors.add(monitorProcessor);
  }

  /**
   * Called by monitors when they are ready to be processed, passing itself. The monitor will be
   * processed by all the MonitorProcessors assigned to the MonitoringEngine.
   *
   * @param monitor The monitor to be processed.
   */
  public void process(EventMonitor monitor) {
    for (MonitorProcessor processor: processors) {
      processor.process(monitor);
    }
  }
}
