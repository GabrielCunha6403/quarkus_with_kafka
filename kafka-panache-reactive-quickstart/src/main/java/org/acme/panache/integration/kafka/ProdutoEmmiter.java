package org.acme.panache.integration.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class ProdutoEmmiter {

    @Inject @Channel("produto-topic-out")
    Emitter<String> emmiter;

    public void sendKafkaData(String message) {
        emmiter.send(message);
    }

}
