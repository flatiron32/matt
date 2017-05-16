package matt.monitors;

import java.util.HashMap;
import java.util.Map;
import matt.Monitor;
import matt.MonitoringEngine;

public abstract class AbstractMonitor implements Monitor {

  private final Map<String, Object> attributes = new HashMap<>();
  private final String name;

  AbstractMonitor(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  public Map<String, Object> getAttributes() {
    return attributes;
  }

  public void setAttribute(String key, Object value) {
    attributes.put(key, value);
  }

  void process() {
    MonitoringEngine.getInstance().process(this);
  }
}
