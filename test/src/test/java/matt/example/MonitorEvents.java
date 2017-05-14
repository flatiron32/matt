package matt.example;

import matt.EventMonitor;

public class MonitorEvents {

  public void doEventful() {
    new EventMonitor(getClass(), "event").fire();
  }
}
