package matt.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import matt.Monitor;
import matt.MonitorProcessor;
import org.junit.Assert;

/**
 * @see matt.MonitorProcessor
 * Capture all the monitors processed by the MonitoringEngine and assert properties of them.
 */
public class MockMonitorProcessor implements MonitorProcessor {

  private List<Monitor> monitors = new ArrayList<>();

  /**
   * Assert that the next monitor recieved by the processor was named the passes name value.
   * The monitor is removed from the list to be reviewed.
   * @param name The name to be checked against the next monitor received.
   * @param attributes The attributes that must exist for the monitor.
   */
  public void assertEventMonitor(String name, String... attributes) {
    Assert.assertFalse("No monitor available to assert.", monitors.isEmpty());
    Monitor monitor = monitors.remove(0);
    assertEquals(name, monitor.getName());
    assertEquals(
        "Incorrect number of attributes associated with monitor (" + monitor.getName() + ")",
        attributes.length, monitor.getAttributes().size());
    for (String attribute : attributes) {
      assertNotNull(monitor.getAttributes().remove(attribute));
    }
  }

  public void assertConsumed() {
    Assert.assertTrue(monitors.isEmpty());
  }

  @Override
  public void process(Monitor monitor) {
    monitors.add(monitor);
  }
}
