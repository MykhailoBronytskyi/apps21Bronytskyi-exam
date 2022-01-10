package domain;

import json.*;

import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {

    protected Tuple<String, Integer>[] exams;

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        super(name, surname, year);
        this.exams = exams;
    }

    @Override
    public JsonObject toJsonObject() {
        JsonObject resultJsonObject = super.toJsonObject();

        JsonObject[] jsonExams = new JsonObject[exams.length];


        for (int idx = 0; idx < exams.length; idx++){
            JsonObject newExam = new JsonObject(new JsonPair("course", new JsonString(exams[idx].key)),
                                                new JsonPair("mark" , new JsonNumber(exams[idx].value)),
                                                new JsonPair("passed" , new JsonBoolean(exams[idx].value > 2)));
            jsonExams[idx] = newExam;
        }

        resultJsonObject.add(new JsonPair("exams", new JsonArray(jsonExams)));
        return resultJsonObject;
    }
}