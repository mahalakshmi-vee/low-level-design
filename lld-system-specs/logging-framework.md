## **Design Logging Framework**

Develop a basic logging library that can be used by applications to log messages.
The library should handle message logging efficiently and reliably offering basic configuration options.

### **Key Requirements:**
1. Driver application should be able to initialize the library and log messages to the desired sink.
2. Logger has the following capabilities:
       a. Accept messages from clients.
       b. A loggger would have one or more sinks associated with it.
       c. Supports defined message levels such as DEBUG, INFO, WARNING, ERROR, and FATAL. Log level should be extensible to support new log levels in the future.
       d. Enriches message with current timestamp while directing message to a sink.
       e. Logger is inititalized with a configuration example logger name, sinks, buffer size.
       f. Logger should support both sync and async logging.
       g. For async logger buffer size would determine the maximum inflight messages.
       h. Messages must be ordered. Messages should reach the sink in the order in which they were sent.
       i. Should support writes from multiple threads.
       j. There should not be any data loss.
3. Sink:
       a. There can be various types of sinks (file, console, database).
       b. Sink has an associated log level. Any message with the level lower than the sink level should be discarded.
       c. Sinks should be extensible to support new output destinations in the future.

 
