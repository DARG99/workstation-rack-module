package com.ctw.resource;

import com.ctw.workstation.rack.dto.RackCreateDTO;
import com.ctw.workstation.team.dto.TeamCreateDTO;
import com.ctw.workstation.team.entity.Team;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@QuarkusTest
public class RackResourceTest {
    @DisplayName("Should create a rack with a valid team")
    @Test
    public void testCreateRackWithTeam() {

        TeamCreateDTO teamCreation = new TeamCreateDTO("QA Team", "string", "string"){};

        String teamId =
                given().contentType(ContentType.JSON)
                        .body(teamCreation)
                        .when()
                        .post("/workstation/teams")
                        .then()
                        .statusCode(201)
                        .extract()
                        .path("id");
        System.out.println("Created team ID: " + teamId);

        RackCreateDTO rackCreation = new RackCreateDTO("string", "AVAILABLE", "string", UUID.fromString(teamId));


        given()
                .body(rackCreation)
                .contentType(ContentType.JSON)
                .when()
                .post("/workstation/racks")
                .then()
                .statusCode(201)
                .body("serialNumber", equalTo("string"))
                .body("status", equalTo("AVAILABLE"))
                .body("defaultLocation", equalTo("string"))
                .body("id", notNullValue());
    }
}
