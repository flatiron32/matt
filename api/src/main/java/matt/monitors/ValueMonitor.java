package matt.monitors;

public class ValueMonitor extends AbstractMonitor {

  public static final String VALUE = "value";

  public ValueMonitor(Class klass, String name) {
    super(klass, name);
  }

  public ValueMonitor(String name) {
    super(name);
  }

  public void record(double value) {
    setAttribute(VALUE, value);
    process();
  }
}
