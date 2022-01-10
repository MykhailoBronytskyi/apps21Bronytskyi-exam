package app;

import json.Json;
import json.Tuple;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import static org.junit.Assert.*;

/**
 * Created by Andrii_Rodionov on 1/5/2017.
 */
public class JSONAppTest {
    @Test
    public void testSessionResult() throws Exception {
        Json jsonObject = JSONApp.sessionResult();

        String expectedJSON =
                "{'name': 'Mykhailo', 'surname': 'Bronytskyi', 'year': 2, 'exams': [" +
                        "{'course': 'OOP', 'mark': 5, 'passed': true}," +
                        "{'course': 'Algorithms', 'mark': 5, 'passed': true}," +
                        "{'course': 'POC', 'mark': 2, 'passed': false}" +
                        "]}";

        JSONAssert.assertEquals(expectedJSON, jsonObject.toJson(), true);
//        System.out.println(jsonObject.toJson());
    }
}