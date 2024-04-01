/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springbootlogging;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringBootLoggingTest {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void contextLoads() {
        logger.trace("trace logs...");
        logger.debug("debug logs...");
        logger.info("info logs...");
        logger.warn("warn logs...");
        logger.error("error logs...");
    }
}
