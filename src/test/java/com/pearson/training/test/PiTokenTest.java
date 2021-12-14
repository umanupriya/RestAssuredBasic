package com.pearson.training.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PiTokenTest {
    @Test
    public void authTokenTest(){

        String piToken;
        String status;
        PiTokenDTO piTokenDto = new PiTokenDTO("edsng_3pl_system","MNOjkp2Mlp49q79Bt1pHroDBNqZv76r3");
        RestAssured.baseURI = "https://int-piapi.stg-openclass.com/v1/piapi-int";
        RestAssured.port = 443;
        Response response = RestAssured.given()
                .contentType("application/json")
                .body
                .post("/tokens");
        piToken = response.jsonPath().getString("data");
        status = response.jsonPath().getString("status");
        System.out.println(piToken);
        System.out.print(response.getStatusCode());
       Assert.assertNotNull(piToken);
        Assert.assertEquals(status,"success");
    }
}
