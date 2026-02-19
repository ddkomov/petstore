package api.request;

import api.dto.BaseModel;
import api.dto.DeletePetResponse;
import io.restassured.response.ValidatableResponse;


public interface CrudInterface<T extends BaseModel> {

    public Object createPet(T model);

    public Object findPetsByStatus(String status);

    public Object deletePet(int id);

    public Object updatePet( T model);

}