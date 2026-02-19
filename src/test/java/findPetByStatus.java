import api.dto.FindPetByStatusResponse;
import api.request.Requester;
import api.request.ValidatedRequester;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class findPetByStatus {
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
    public void findPetByStatus() {
        List<FindPetByStatusResponse> response = validatedRequester.findPetsByStatus("available");

        assertThat(response)
                .isNotEmpty()
                .allMatch(pet -> "available".equals(pet.getStatus()),
                        "All pets should be 'available'");
    }
}
