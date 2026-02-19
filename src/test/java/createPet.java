import api.dto.CreatePetRequest;
import api.dto.CreatePetResponse;
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

public class createPet {
    private Requester requester = new Requester();
    private ValidatedRequester validatedRequester = new ValidatedRequester();
    private SoftAssertions softly = new SoftAssertions();

    @BeforeAll
    public static void before(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
    @BeforeEach
    public void beforeEach(){
        softly = new SoftAssertions();
    }
    @AfterEach
    public void afterEach(){
        softly.assertAll();
    }

    @Test
    public void createPet(){
        CreatePetRequest createPetRequest = CreatePetRequest.builder()
                .id(Long.valueOf(111))
                .name("test1")
                .status("available")
                .build();
        CreatePetResponse response = validatedRequester.createPet(createPetRequest);

        softly.assertThat(response.getId()).isEqualTo(createPetRequest.getId());
        softly.assertThat(response.getName()).isEqualTo(createPetRequest.getName());
    }
}
