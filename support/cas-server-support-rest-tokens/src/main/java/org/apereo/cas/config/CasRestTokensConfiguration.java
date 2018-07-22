package org.apereo.cas.config;

import org.apereo.cas.CentralAuthenticationService;
import org.apereo.cas.configuration.CasConfigurationProperties;
import org.apereo.cas.rest.factory.TicketGrantingTicketResourceEntityResponseFactory;
import org.apereo.cas.rest.plan.ServiceTicketResourceEntityResponseFactoryConfigurer;
import org.apereo.cas.rest.plan.ServiceTicketResourceEntityResponseFactoryPlan;
import org.apereo.cas.services.ServicesManager;
import org.apereo.cas.ticket.registry.TicketRegistrySupport;
import org.apereo.cas.token.TokenTicketBuilder;
import org.apereo.cas.tokens.JWTServiceTicketResourceEntityResponseFactory;
import org.apereo.cas.tokens.JWTTicketGrantingTicketResourceEntityResponseFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This is {@link CasRestTokensConfiguration}.
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@Configuration("casRestTokensConfiguration")
@EnableConfigurationProperties(CasConfigurationProperties.class)
public class CasRestTokensConfiguration implements ServiceTicketResourceEntityResponseFactoryConfigurer {
    @Autowired
    @Qualifier("centralAuthenticationService")
    private CentralAuthenticationService centralAuthenticationService;

    @Autowired
    @Qualifier("tokenTicketBuilder")
    private TokenTicketBuilder tokenTicketBuilder;

    @Autowired
    @Qualifier("servicesManager")
    private ServicesManager servicesManager;

    @Autowired
    @Qualifier("defaultTicketRegistrySupport")
    private TicketRegistrySupport ticketRegistrySupport;

    @Bean
    public TicketGrantingTicketResourceEntityResponseFactory ticketGrantingTicketResourceEntityResponseFactory() {
        return new JWTTicketGrantingTicketResourceEntityResponseFactory(this.servicesManager, tokenTicketBuilder);
    }

    @Override
    public void configureEntityResponseFactory(final ServiceTicketResourceEntityResponseFactoryPlan plan) {
        plan.registerFactory(new JWTServiceTicketResourceEntityResponseFactory(centralAuthenticationService,
            tokenTicketBuilder, ticketRegistrySupport, servicesManager));
    }
}
