package factories;

import appenders.ConsoleAppender;
import appenders.FileAppender;
import enums.ReportLevel;
import interfaces.Appender;
import interfaces.Factory;
import interfaces.Layout;

public class AppenderFactory implements Factory<Appender> {

    private LayoutFactory layoutFactory;

    public AppenderFactory() {

        this.layoutFactory = new LayoutFactory();

    }

    @Override
    public Appender produce(String produceData) {

        String[] data = produceData.split("\\s+");

        Layout produce = this.layoutFactory.produce(data[1]);

        Appender appender;

        if (data[0].equals("ConsoleAppender")) {
            appender = new ConsoleAppender(produce);
        } else {
            appender = new FileAppender(produce);
        }

        if (data.length > 2) {
            appender.setReportLevel(ReportLevel.valueOf(data[2]));
        }

        return appender;
    }
}
