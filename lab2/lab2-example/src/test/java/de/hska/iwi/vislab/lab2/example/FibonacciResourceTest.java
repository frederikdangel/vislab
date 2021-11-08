package de.hska.iwi.vislab.lab2.example;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import
javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

    public class FibonacciResourceTest {

        private HttpServer server;
        private WebTarget target;

        @Before
        public void setUp() throws Exception {
            // start the server
            server = Main.startServer();
            // create the client
            Client c = ClientBuilder.newClient();

            // uncomment the following line if you want to enable
            // support for JSON in the client (you also have to uncomment
            // dependency on jersey-media-json module in pom.xml and
            // Main.startServer())
            // --
            // c.configuration().enable(new
            // org.glassfish.jersey.media.json.JsonJaxbFeature());

            target = c.target(Main.BASE_URI);
        }

        @After
        public void tearDown() throws Exception {
            server.shutdown();
        }


        @Test
        public void testPost(){
            for (int i = 0; i<=10; i++) {

                int number = target.path("fibonacci").request().accept(MediaType.TEXT_PLAIN).post(null, Integer.class);
                assertEquals(number, new FibonacciServiceImpl().getFibonacci(i));

            }
            target.path("fibonacci").request().delete();
            int number = target.path("fibonacci").request().accept(MediaType.TEXT_PLAIN).post(null, Integer.class);
            assertEquals(number, 0);
        }

}
