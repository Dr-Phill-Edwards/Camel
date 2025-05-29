package training;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Camel extends RouteBuilder {
    protected final Logger logger;
    private final CamelContext context;

    public Camel() {
        logger = LogManager.getLogger(getClass());
        context = new DefaultCamelContext();
    }

    public void execute() {
        logger.info("Executing Camel");
        try {
            context.addRoutes(this);
            context.start();
            synchronized(this) {
                this.wait();
            }
        } catch (Exception e) {
            logger.error("Error on execute " + e);
        }
    }

    @Override
    public void configure() {
        from("timer:Hello").log("Hello from Camel");
    }

    public static void main(String[] args) {
        new Camel().execute();
    }
}