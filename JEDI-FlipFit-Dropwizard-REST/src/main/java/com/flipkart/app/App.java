package com.flipkart.app;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flipkart.rest.FlipfitController;
import com.flipkart.rest.GymAdminFlipfitController;
import com.flipkart.rest.GymCustomerFlipfitController;
import com.flipkart.rest.GymOwnerFlipfitController;

/**
 * Hello world!
 *
 */
public class App extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");
        //  e.jersey().register(new EmployeeRESTController(e.getValidator()));
        e.jersey().register(new FlipfitController());
        e.jersey().register(new GymAdminFlipfitController());
        e.jersey().register(new GymOwnerFlipfitController());
        e.jersey().register(new GymCustomerFlipfitController());
      
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}