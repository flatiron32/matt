package matt.example;

import java.util.Random;
import matt.MonitoringEngine;
import matt.monitors.ValueMonitor;
import matt.test.MockMonitorProcessor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MonitorValuesTest {

  private static final Random RANDOM = new Random();
  private MockMonitorProcessor mockMonitorProcessor;

  @Before
  public void setup() {
    mockMonitorProcessor = new MockMonitorProcessor();
    MonitoringEngine.getInstance().addProcessor(mockMonitorProcessor);
  }

  @After
  public void teardown() {
    MonitoringEngine.getInstance().clearProcessors();
  }

  @Test
  public void transactionProcessed() {
    ValueMonitor valueMonitor = new ValueMonitor(getClass(), "test.value");

    valueMonitor.record(RANDOM.nextDouble());

    mockMonitorProcessor.assertEventMonitor("matt.example.MonitorValuesTest.test.value",
        ValueMonitor.VALUE);
    mockMonitorProcessor.assertConsumed();
  }


}
