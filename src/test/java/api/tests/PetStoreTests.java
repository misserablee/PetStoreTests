package api.tests;

import api.Data;
import api.specification.Specifications;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PetStoreTests {

    private final String URL = "https://petstore.swagger.io/#/";
    //Data getData = new Data();
    @Test
    public void GetPetById () {
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecificationUnique(200));

        Response response = given()
                .when()
                .get("/pet/{0}")
                .then().log().all()
                .extract().response();
    }

    @Test
    public void GetPetByIdNew () {
        //Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecificationUnique(200));

        Response response = given()
                .when()
                .get(URL + "/pet/{0}")
                .then().log().all()
                .extract().response();
    }
}
