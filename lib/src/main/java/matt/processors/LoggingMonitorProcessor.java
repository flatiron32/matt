package matt.processors;

import matt.Monitor;
import matt.MonitorProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingMonitorProcessor implements MonitorProcessor {
  private static final Logger LOGGER = LoggerFactory.getLogger(LoggingMonitorProcessor.class);

  @Override
  public void process(Monitor monitor) {
    LOGGER.info(monitor.toString());
  }
}
