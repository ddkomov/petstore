package api.request;

import api.dto.BaseModel;
import api.dto.DeletePetResponse;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class Requester implements CrudInterface {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";


    @Override
    public ValidatableResponse createPet(BaseModel model) {
        return given()
                .body(model)
                .header("api_key", "special-key")
                .header("Content-type", "application/json")
                .when()
                .post(BASE_URL + "/pet")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Override
    public ValidatableResponse findPetsByStatus(String status) {
        return given()
                .when()
                .header("api_key", "special-key")
                .header("Content-type", "application/json")
                .get(BASE_URL + "/pet/findByStatus?status=" + status)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Override
    public ValidatableResponse deletePet(int id) {
        return given()
                .when()
                .header("api_key", "special-key")
                .header("Content-type", "application/json")
                .delete(BASE_URL + "/pet/" + id)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Override
    public ValidatableResponse updatePet(BaseModel model) {
        return given()
                .body(model)
                .when()
                .header("api_key", "special-key")
                .header("Content-type", "application/json")
                .put(BASE_URL + "/pet/")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
