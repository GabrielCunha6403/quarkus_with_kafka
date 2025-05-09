package org.acme.panache.integration.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class ProdutoService {

    @Incoming("produto-topic-in")
    public void receiveMessageFromKafka(String message) {
        System.out.println(message);
    }
}
