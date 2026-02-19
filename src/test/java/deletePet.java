import api.dto.DeletePetResponse;
import api.request.Requester;
import api.request.ValidatedRequester;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.ValidatableResponse;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class deletePet {
    private Requester requester = new Requester();
    private ValidatedRequester validatedRequester = new ValidatedRequester();
    private SoftAssertions softly = new SoftAssertions();

    @BeforeAll
    public static void before() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @BeforeEach
    public void beforeEach() {
        softly = new SoftAssertions();
    }

    @AfterEach
    public void afterEach() {
        softly.assertAll();
    }

    @Test
    public void deletePet() {
       DeletePetResponse response = validatedRequester.deletePet(5);

       softly.assertThat(response.getCode()).isEqualTo(200);
       softly.assertThat(response.getMessage()).isEqualTo("5");
       softly.assertThat(response.getType()).isEqualTo("unknown");
    }
}
