package matt.example;

import matt.MonitoringEngine;
import matt.monitors.TransactionMonitor;
import matt.test.MockMonitorProcessor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MonitorTransactionsTest {

  private MockMonitorProcessor mockMonitorProcessor;

  @Before public void setup() {
    mockMonitorProcessor = new MockMonitorProcessor();
    MonitoringEngine.getInstance().addProcessor(mockMonitorProcessor);
  }

  @After public void teardown() {
    MonitoringEngine.getInstance().clearProcessors();
  }

  @Test public void transactionProcessed() {
    TransactionMonitor tm = new TransactionMonitor(getClass(), "test.transaction");
    try {
      //do something to be timed
    } finally {
      tm.done();
    }

    mockMonitorProcessor.assertEventMonitor("matt.example.MonitorTransactionsTest.test.transaction",
        TransactionMonitor.START_TIME, TransactionMonitor.STOP_TIME);
    mockMonitorProcessor.assertConsumed();
  }

  //success
  //failure
  //abandoned
}
