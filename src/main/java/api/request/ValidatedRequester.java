package api.request;

import api.dto.*;
import io.restassured.common.mapper.TypeRef;

import java.util.List;

public class ValidatedRequester implements CrudInterface{
    private Requester requester = new Requester();

    @Override
    public CreatePetResponse createPet(BaseModel model) {
        return requester.createPet(model).extract().as(CreatePetResponse.class);
    }

    @Override
    public List<FindPetByStatusResponse> findPetsByStatus(String status) {
        return requester.findPetsByStatus(status).extract()
                .body()
                .as(new TypeRef<>() {});
    }

    @Override
    public DeletePetResponse deletePet(int id) {
        return  requester.deletePet(id)
                .extract().as(DeletePetResponse.class);

    }

    @Override
    public UpdatePetResponse updatePet(BaseModel model) {
        return requester.updatePet( model).extract().as(UpdatePetResponse.class);
    }
}
