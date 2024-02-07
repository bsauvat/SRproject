package fr.esir.sr.SRproject.Server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.remoting.support.RemoteExporter;

import fr.esir.sr.SRproject.Server.RemoteServices.RemoteServices;
import fr.esir.sr.SRproject.Server.RemoteServices.RemotesServicesImpl;

@Configuration
public class Config {

    @Bean
    RemoteExporter registerRMIExporter() {

        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceName("sayHello");
        exporter.setServiceInterface(RemoteServices.class);
        exporter.setService(new RemotesServicesImpl());

        return exporter;
    }
}