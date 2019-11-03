package logger.layouts;

import logger.enums.ReportLevel;
import logger.interfaces.Layout;

public class SimpleLayouts implements Layout {
    @Override
    public String format(String time, String message, ReportLevel reportLevel) {
        return String.format("%s - %s - %s", time, reportLevel.toString(), message);
    }
}
