package matt;

public class TransactionMonitor extends AbstractMonitor {

  public static final String START_TIME = "START_TIME";
  public static final String STOP_TIME = "STOP_TIME";

  public TransactionMonitor(Class klass, String methodName) {
    super(klass.getName() + "." + methodName);
    setAttribute(START_TIME, System.currentTimeMillis());
  }

  public void done() {
    setAttribute(STOP_TIME, System.currentTimeMillis());
    process();
  }
}
