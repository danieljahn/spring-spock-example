import com.github.danieljahn.springspockexample.SpringSpockExampleApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import spock.lang.Specification

@SpringBootTest(classes = SpringSpockExampleApplication.class)
@AutoConfigureWebTestClient
class HelloSpec extends Specification {

    @Autowired
    private WebTestClient client

    def "should greet me by name"() {
        when: "I request to greet John"
        def body = [
                name: "John"
        ]

        def response = client
                .post()
                .uri("/hello")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(body)
                .exchange()

        then: "I should be greeted with 'Hello, John'"
        response.expectStatus().is2xxSuccessful()
        response.expectBody().jsonPath("message").isEqualTo("Hello, John!")
    }
}
