package ru.tests;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;


public class Test3 {

    public static void main(String[] args) {
        Test3 test = new Test3();
        test.addCommentToJiraIssue();
    }

    public void addCommentToJiraIssue() {
        RestAssured.baseURI = "https://jira.net"; // cпасибо обязательности https в нашей Jira и keystore ><
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("Login"); // вин-логин без домена
        authScheme.setPassword("Password"); //доменный пароль
        RestAssured.authentication = authScheme;
        String issueKey = "SFAIMP-1219";
        String commentText = "Привет!\\nМиша был здесь.";

        Response response = RestAssured.given().header("Content-Type", "application/json").body("{\"body\": \"" + commentText + "\"}").post("/rest/api/2/issue/" + issueKey + "/comment");

        // Костыльная проверка успешности запроса (раз уж в требованиях только про REST Assured)
        int statusCode = response.getStatusCode();
        if (statusCode == 201) {
            System.out.println("Успех! Комментарий успешно добавлен в " + issueKey);
        } else {
            System.out.println("Ошибка! Код ошибки: " + statusCode);
            System.out.println("Текст ошибки: " + response.getBody().asString());
        }
    }
}