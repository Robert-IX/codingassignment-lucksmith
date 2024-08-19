package com.github.Robert_IX.codingassignment_lucksmith.config;

import java.io.IOException;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for setting up Drools with Spring.
 * This class configures the Drools KIE (Knowledge Is Everything) services,
 * creating the necessary beans for KieContainer and KieSession.
 *
 * This configuration enables the application to load and execute business rules
 * defined in Drools files ( rules.xls ).
 *
 * @author Robert Gheorghe
 */
@Configuration
public class DroolsConfig
{

    // Instance of KieServices used for creating KIE components
    private KieServices kieServices = KieServices.Factory.get();

    /**
     * Configures the KieFileSystem with the rules from a specific resource file.
     *
     * @return KieFileSystem instance with the rules loaded.
     * @throws IOException if there is an error accessing the resource file.
     */
    private KieFileSystem getKieFileSystem() throws IOException
    {
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        // Loading rules from the classpath resource 'rules.xls'
        kieFileSystem.write(ResourceFactory.newClassPathResource("rules.xls"));
        return kieFileSystem;
    }

    /**
     * Creates and returns a KieContainer bean.
     * The KieContainer is responsible for loading the KIE modules and rules into memory.
     *
     * @return KieContainer instance.
     * @throws IOException if there is an error during the KieFileSystem configuration.
     */
    @Bean
    public KieContainer getKieContainer() throws IOException
    {
        System.out.println("KieContainer created!");
        getKieRepository();
        // Building all resources in the KieFileSystem
        KieBuilder kb = kieServices.newKieBuilder(getKieFileSystem());
        kb.buildAll();
        // Getting the KieModule and creating a KieContainer with it
        KieModule kieModule = kb.getKieModule();
        KieContainer kContainer = kieServices.newKieContainer(kieModule.getReleaseId());
        return kContainer;
    }

    /**
     * Configures the KieRepository.
     * The KieRepository keeps track of all KIE modules and their ReleaseIds.
     */
    private void getKieRepository()
    {
        final KieRepository kieRepository = kieServices.getRepository();
        // Adding a new KieModule to the repository
        kieRepository.addKieModule(new KieModule()
        {
            public ReleaseId getReleaseId()
            {
                return kieRepository.getDefaultReleaseId();
            }
        });
    }

    /**
     * Creates and returns a KieSession bean.
     * The KieSession represents a single Drools session where rules are executed.
     *
     * @return KieSession instance.
     * @throws IOException if there is an error during the KieContainer creation.
     */
    @Bean
    public KieSession getKieSession() throws IOException
    {
        System.out.println("KieSession created!");
        // Creating a new KieSession from the KieContainer
        return getKieContainer().newKieSession();
    }
}