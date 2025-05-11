package training;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Camel extends RouteBuilder {
    @Override
    public void configure() {
        from("timer:Hello").log("Hello from Camel");
    }

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Camel.class);
        Camel camel = new Camel();
        try (CamelContext camelctx = new DefaultCamelContext()) {
            camelctx.addRoutes(camel);
            camelctx.start();
            Thread.sleep(10_000);
        } catch (Exception e) {
            System.err.println("Error " + e);
        }
    }
}