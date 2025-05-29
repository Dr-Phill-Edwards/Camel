package training;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.AdviceWith;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CamelTest extends CamelTestSupport {
    private Camel camel;
    private MockEndpoint result;
    private ProducerTemplate template;

    @BeforeEach
    void setup() throws Exception {
        camel = new Camel();
        context.addRoutes(camel);
        template = context.createProducerTemplate();
        result = context.getEndpoint("mock:out", MockEndpoint.class);
    }
}
