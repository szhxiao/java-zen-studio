/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloLog {
    private static final Logger logger =
            LoggerFactory.getLogger(HelloLog.class);
    
    public static void main(String[] args) {
        //BasicConfigurator.configure();
        logger.info("hello log4j2 info");
        logger.warn("hello log4j2 warning");
    }

}
