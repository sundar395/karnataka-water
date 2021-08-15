package yes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.RouteDefinition;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import io.syndesis.integration.runtime.api.SyndesisExtensionAction;

@Configuration
public class yesExtension {
    @Bean
    @SyndesisExtensionAction(
        id = "my-step",
        name = "My Step",
        description = "A simple step",
        entrypoint = "direct:my-step"
    )
    public RouteBuilder myAction() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from("direct:my-step")
                    .log("Body is: ${body}");
            }
        };
    }
}
