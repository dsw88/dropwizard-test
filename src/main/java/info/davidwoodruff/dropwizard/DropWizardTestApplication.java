package info.davidwoodruff.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import info.davidwoodruff.dropwizard.resources.DropWizardTestResource;
import info.davidwoodruff.dropwizard.health.TemplateHealthCheck;

public class DropWizardTestApplication extends Application<DropWizardTestConfiguration> {
    public static void main(String[] args) throws Exception {
        new DropWizardTestApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard-test";
    }

    @Override
    public void initialize(Bootstrap<DropWizardTestConfiguration> bootstrap) {
        //Nothing yet
    }

    @Override
    public void run(DropWizardTestConfiguration configuration,
                    Environment environment) {
        final DropWizardTestResource resource = new DropWizardTestResource(
            configuration.getTemplate(),
            configuration.getDefaultName()
        );
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }

}
