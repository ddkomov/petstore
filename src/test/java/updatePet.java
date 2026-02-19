import api.dto.UpdatePetRequest;
import api.dto.UpdatePetResponse;
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

public class updatePet {
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
    public void updatePet(){
        UpdatePetRequest request = UpdatePetRequest.builder()
                .id(Long.valueOf(5))
                .name("test name")
                .status("test status")
                .build();
        
        UpdatePetResponse response = validatedRequester.updatePet(request);

        softly.assertThat(response.getId()).isEqualTo(request.getId());
        softly.assertThat(response.getName()).isEqualTo(request.getName());
        softly.assertThat(response.getStatus()).isEqualTo(request.getStatus());
    }
}
