package matt.monitor.matt;

import matt.EventMonitor;
import matt.Monitor;
import matt.MonitorProcessor;
import matt.MonitoringEngine;
import org.junit.Assert;
import org.junit.Test;

public class MonitoringEngineTest {

  @Test public void useAllProcessors() {
    final boolean[] pUsed = {false, false};
    MonitoringEngine.getInstance().addProcessor(new MonitorProcessor() {
      @Override
      public void process(Monitor monitor) {
        pUsed[0] = true;
      }
    });
    MonitoringEngine.getInstance().addProcessor(new MonitorProcessor() {
      @Override
      public void process(Monitor monitor) {
        pUsed[1] = true;
      }
    });

    new EventMonitor("test.event").fire();

    Assert.assertTrue(pUsed[0]);
    Assert.assertTrue(pUsed[1]);
  }
}
