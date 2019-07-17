package com.celfocus.training.business.logger;

import java.util.logging.Logger;

public class ConsoleLogger {

    private static final Logger LOGGER = Logger.getLogger( ConsoleLogger.class.getName() );

    public void writeInfo(String msg) {
        LOGGER.info(msg);
    }

    public void writeError(String msg, Exception e) {
        LOGGER.info("Error: " + msg + ";" + e);
    }
}
