package com.pearson.training.test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstEndPoint {

    @Test
    public void weatherInfroTest() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RequestSpecification httprequest = RestAssured.given();
        Response response = httprequest.get("/users");
        ResponseBody body = response.getBody();
        System.out.println(body.asString());
        JsonPath jasonPathEvaluvator = response.jsonPath();
        String name = jasonPathEvaluvator.getString("name[0]");
        String nameExpected = "Leanne Graham";
        Assert.assertEquals(name,nameExpected );
    }
}
