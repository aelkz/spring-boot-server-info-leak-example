package com.github.dreambrother;

import org.apache.catalina.valves.ErrorReportValve;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
public class Config {

    @Bean
    public Controller controller() {
        return new Controller();
    }

    /**
     * It is possible to hide some information overriding error report valve in Tomcat,
     * but some classes' names are still presented in exception message.
     */
    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        // Disable tomcat version and exception logging by ErrorReportValve
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();

        ErrorReportValve errorReportValve = new ErrorReportValve();
        errorReportValve.setShowReport(false);
        errorReportValve.setShowServerInfo(false);

        tomcat.addContextValves(errorReportValve);

        return tomcat;
    }
}
