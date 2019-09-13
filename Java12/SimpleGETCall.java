// cerner_2^5_2019

/* Content of module-info.java */
module httpclienttest {
    requires java.net.http;
}

/* Content of SimpleGETCall.java
 * Async call to open FHIR endpoint using new HttpClient
 */
package httpclienttest;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class SimpleGetCall {

    public static void main(final String[] args) {
        final HttpClient client = HttpClient.newHttpClient();
        final HttpRequest request = HttpRequest.newBuilder()
             .headers("Accept", "application/json")
             .uri(URI.create("https://fhir-open.sandboxcerner.com/r4/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Patient?_id=4342009")).GET()
             .build();

        client.sendAsync(request, BodyHandlers.ofString())
        .thenApply(HttpResponse::body)
        .thenAccept(System.out::println)
        .join();
    }
}
