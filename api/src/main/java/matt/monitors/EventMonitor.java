package matt.monitors;

public class EventMonitor extends AbstractMonitor {

  public EventMonitor(Class klass, String event) {
    this(klass.getName() + "." + event);
  }

  public EventMonitor(String name) {
    super(name);
  }

  public void fire() {
    process();
  }

}
