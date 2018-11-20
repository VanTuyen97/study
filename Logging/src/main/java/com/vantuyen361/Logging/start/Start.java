package com.vantuyen361.Logging.start;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Start {

    public final static Logger logger = LogManager.getLogger(Start.class.getName());

    public static void main(String[] args) {
        logger.entry();
        logger.trace("Trace Message!");
        logger.debug("Debug Message!");
        logger.info("Info Message!");
        logger.warn("Warn Message!");
        logger.error("Error Message!");
        logger.fatal("Fatal Message!");
        logger.exit();
    }
}
