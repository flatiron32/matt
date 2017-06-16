package matt.processors;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static uk.org.lidalia.slf4jtest.LoggingEvent.info;

import matt.Monitor;
import matt.monitors.AbstractMonitor;
import org.junit.After;
import org.junit.Test;
import uk.org.lidalia.slf4jtest.TestLogger;
import uk.org.lidalia.slf4jtest.TestLoggerFactory;

public class LoggingMonitorProcessorTest {
  TestLogger logger = TestLoggerFactory.getTestLogger(LoggingMonitorProcessor.class);

  String format = "{%n"
      + "  \"name\": \"%s\"%n"
      + "  \"type\": \"%s\"%n"
      + "  \"attributes\": {%n"
      + "    \"%s\": \"%s\"%n"
      + "  }%n"
      + "}";
  @Test public void processedMonitorsAreLogged() {
    LoggingMonitorProcessor processor = new LoggingMonitorProcessor();
    Monitor m = new TestMonitor();
    processor.process(m);
    assertThat(logger.getLoggingEvents(), is(asList(info(String.format(format, "Test Monitor", m.getClass().getName(), "attr1", "val1")))));
  }

  @After
  public void clearLoggers() {
    TestLoggerFactory.clear();
  }

  private static class TestMonitor extends AbstractMonitor {

    public TestMonitor() {
      super("Test Monitor");
    }
  }
}
