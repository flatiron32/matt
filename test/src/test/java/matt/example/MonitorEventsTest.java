package matt.example;

import matt.MonitoringEngine;
import matt.test.MockMonitorProcessor;
import org.junit.Test;

public class MonitorEventsTest {

  @Test public void eventProcessed() {
    MockMonitorProcessor mockMonitorProcessor = new MockMonitorProcessor();
    MonitoringEngine.getInstance().addProcessor(mockMonitorProcessor);

    MonitorEvents monitoredObject = new MonitorEvents();
    monitoredObject.doEventful();

    mockMonitorProcessor.assertEventMonitor("matt.example.MonitorEvents.event");
    mockMonitorProcessor.assertConsumed();
  }
}
