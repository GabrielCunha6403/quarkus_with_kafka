package org.acme.panache;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.acme.panache.integration.kafka.ProdutoEmmiter;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("produto")
public class ProdutoResource {

    private static final Logger log = LoggerFactory.getLogger(ProdutoResource.class);
    @ConfigProperty(name = "quarkus.message")
    private String message;

    @Inject
    ProdutoEmmiter produtoEmmiter;

    @GET
    @Path("message")
    public String getMessage() {
        return message;
    }

    @POST
    @Path("message")
    public Response sendMessageToKafka(String nomeProduto) {
        try {
            produtoEmmiter.sendKafkaData(nomeProduto);
            return Response.ok("O nome do produto foi salvo: " + nomeProduto).build();
        } catch(Exception e) {
            return Response.serverError().build();
        }
    }
}
