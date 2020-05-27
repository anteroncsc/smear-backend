package fi.csc.avaa.smear.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
@Tag("integration")
public class TableMetadataResourceTest {

    @Test
    public void findByName_shouldReturnCorrectResult() {
        given()
                .get(Endpoints.TABLE_METADATA + "/HYY_META")
                .then()
                .statusCode(200)
                .body("id", equalTo(4))
                .body("identifier", equalTo("URN:NBN:fi-fe201207066177"))
                .body("name", equalTo("HYY_META"))
                .body("period", equalTo(1))
                .body("spatialCoverage",
                        equalTo("DCMI-point: name=Hyytiälä; east=24.294795; north=61.847463 elevation=179"))
                .body("stationId", equalTo(2))
                .body("timestamp", equalTo("2017-03-14T16:25:09.000"))
                .body("title", equalTo("Hyytiälä SMEAR II meteorology, gases and soil"));
    }
}