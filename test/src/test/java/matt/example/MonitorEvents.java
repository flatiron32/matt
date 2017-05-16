package matt.example;

import matt.monitors.EventMonitor;

public class MonitorEvents {

  public void doEventful() {
    new EventMonitor(getClass(), "event").fire();
  }
}
