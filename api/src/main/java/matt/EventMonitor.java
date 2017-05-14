package matt;

public class EventMonitor implements Monitor {

  private final String name;

  public EventMonitor(Class klass, String event) {
    this(klass.getName() + "." + event);
  }

  public EventMonitor(String name) {
    this.name = name;
  }

  public void fire() {
    MonitoringEngine.getInstance().process(this);
  }

  @Override
  public String getName() {
    return name;
  }
}
