package Utils;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggerUtil {
    private static Logger log = LogManager.getLogManager().getLogger("logger");

    public static void info(String msg){
        log.info(msg);
    }
    public static void error(String msg){
        log.warning(msg);
    }
}
