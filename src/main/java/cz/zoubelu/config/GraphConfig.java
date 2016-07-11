package cz.zoubelu.config;

import org.apache.log4j.Logger;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

/**
 * Created by zoubas
 */
@Configuration
@Profile("production")
public class GraphConfig extends Neo4jConfiguration {
    private final Logger log = Logger.getLogger(getClass());

    @Value("${neo4j.db.url}")
    private String url;

    @Value("${neo4j.db.driver")
    private String driver;

    @Bean
    public org.neo4j.ogm.config.Configuration getConfiguration() {
        org.neo4j.ogm.config.Configuration config = new org.neo4j.ogm.config.Configuration();
        config
                .driverConfiguration()
                .setDriverClassName(driver)
                .setURI(url);
        return config;
    }

    @Bean
    public SessionFactory getSessionFactory() {
        return new SessionFactory(getConfiguration(), "cz.zoubelu.domain");
    }

    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Session getSession() throws Exception {
        return super.getSession();
    }

}