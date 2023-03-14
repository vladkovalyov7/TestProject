package com.org.api;
//
//import com.ita.edu.speakua.api.clients.ClubClient;
//import com.ita.edu.speakua.api.clients.SignInClient;
//import com.ita.edu.speakua.api.models.ErrorResponse;
//import com.ita.edu.speakua.api.models.SingInRequest;
//import com.ita.edu.speakua.api.models.SingInResponse;
//import com.ita.edu.speakua.api.models.club.ClubPostRequest;
//import com.ita.edu.speakua.api.models.club.ClubPostResponse;
//import com.ita.edu.speakua.api.models.club.Location;
//import com.ita.edu.speakua.utils.ConfigProperties;
//import io.qameta.allure.Description;
//import io.restassured.response.Response;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ClubTest {
//    protected static final ConfigProperties configProperties = new ConfigProperties();
//    private ClubClient client;
//
//    List<String> categoriesName = new ArrayList<String>() {
//        {
//            add("Вокальна студія, музика, музичні інструменти");
//        }
//    };
//
//    Location location = Location
//            .builder()
//            .name("Голосівська")
//            .cityName("Київ")
//            .districtName("Голосіївський")
//            .stationName("Голосіївська")
//            .address("https://speak-ukrainian.org.ua/dev/club/910")
//            .coordinates("50.35535081747696, 30.51765754176391")
//            .phone("0937777777")
//            .key(0.00)
//            .build();
//
//    List<Location> locations = new ArrayList<Location>() {
//        {
//            add(location);
//        }
//    };
//
//    @BeforeClass
//    public void beforeClass() {
//        SignInClient clientSI = new SignInClient();
//        SingInRequest credential = new SingInRequest(configProperties.getAdminEmail(), configProperties.getAdminPassword());
//        SingInResponse responseSI = clientSI.post(credential);
//        client = new ClubClient(responseSI.getAccessToken());
//    }
//
//
//    @Description("TUA-463 - Verify that User as 'Керiвник гуртка' can create and new club, which will registered on him.")
//    @Test
//    public void successfulPost() {
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        String clubName = "Голосистi діти " + timestamp;
//        ClubPostRequest requestBody = new ClubPostRequest(
//                clubName,
//                "{\"blocks\":[{\"key\":\"brl63\",\"text\":\"аааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааа\",\"type\":\"unstyled\",\"depth\":1,\"inlineStyleRanges\":[],\"entityRanges\":[],\"data\":{}}],\"entityMap\":{}}",
//                2,
//                categoriesName,
//                locations,
//                2,
//                18,
//                null,
//                null,
//                true,
//                "{\"1\"::\"ліл\"}",
//                264
//        );
//        Response response = this.client.successPost(requestBody);
//        ClubPostResponse clubsResponse = response.as(ClubPostResponse.class);
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(response.getStatusCode(), 200);
//        softAssert.assertEquals(clubsResponse.getName(), clubName);
//        softAssert.assertAll();
//    }
//
//    @Description("TUA-503 - Verify that User as 'Керiвник гуртка' cannot create a new club if 'Назва' field contain more than 100 characters")
//    @Test
//    public void verifyThatUserCannotCreateNewClubIfNameContainMore100Characters() {
//        ClubPostRequest requestBody = new ClubPostRequest(
//                "Ми поставили перед собою ціль створити мережу найкращих центрів раннього розвитку в Україні, де дітки навчатимуться з задоволенням, а батьки радітимуть від результатів",
//                "{\"blocks\":[{\"key\":\"brl63\",\"text\":\"аааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааа\",\"type\":\"unstyled\",\"depth\":1,\"inlineStyleRanges\":[],\"entityRanges\":[],\"data\":{}}],\"entityMap\":{}}",
//                2,
//                categoriesName,
//                locations,
//                2,
//                18,
//                null,
//                null,
//                true,
//                "{\"1\"::\"ліл\"}",
//                264
//        );
//        Response response = this.client.successPost(requestBody);
//        ErrorResponse errorResponse = response.as(ErrorResponse.class);
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(response.statusCode(), 400);
//        softAssert.assertEquals(errorResponse.getMessage(), "name Довжина назви має бути від 5 до 100 символів");
//        softAssert.assertAll();
//
//    }
//
//    @Description("Verifying that admin can't create new club with Russian alphabet for name field")
//    @Test
//    public void errorMessageInvalidNameClub() {
//        ClubPostRequest requestBody = new ClubPostRequest(
//                "Тестовый экземпляр",
//                "{\"blocks\":[{\"key\":\"brl63\",\"text\":\"Ми поставили перед собою ціль створити мережу найкращих центрів раннього розвитку в Україні, де дітки навчатимуться з задоволенням, а батьки радітимуть від результатів.\",\"type\":\"unstyled\",\"depth\":1,\"inlineStyleRanges\":[],\"entityRanges\":[],\"data\":{}}],\"entityMap\":{}}",
//                0,
//                categoriesName,
//                null,
//                17,
//                18,
//                "/dev/static/images/user/avatar/user1.png",
//                "/dev/static/images/user/avatar/user1.png",
//                true,
//                "testTestTest",
//                999
//        );
//        ErrorResponse response = client.badPost(requestBody);
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(response.getStatus(), 400);
//        softAssert.assertEquals(response.getMessage(), "name Помилка. Присутні недопустимі символи");
//        softAssert.assertAll();
//    }
//
//    @Description("Check that admin can't create new club with less than 5 characters for name field")
//    @Test
//    public void InvalidNameLessThan5CharactersClub() {
//        ClubPostRequest requestBody = new ClubPostRequest(
//                "Жук",
//                "{\"blocks\":[{\"key\":\"brl63\",\"text\":\"Ми поставили перед собою ціль створити мережу найкращих центрів раннього розвитку в Україні, де дітки навчатимуться з задоволенням, а батьки радітимуть від результатів.\",\"type\":\"unstyled\",\"depth\":1,\"inlineStyleRanges\":[],\"entityRanges\":[],\"data\":{}}],\"entityMap\":{}}",
//                0,
//                categoriesName,
//                null,
//                2,
//                18,
//                "/dev/static/images/user/avatar/user1.png",
//                "/dev/static/images/user/avatar/user1.png",
//                true,
//                "contactContact",
//                0
//        );
//        ErrorResponse response = client.badPost(requestBody);
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(response.getStatus(), 400);
//        softAssert.assertEquals(response.getMessage(), "name Довжина назви має бути від 5 до 100 символів");
//        softAssert.assertAll();
//    }
//
//    @Description("Verify that User as \"Керiвник гуртка\" can create new club is in a center using valid characters for \"Назва\" field")
//    @Test
//    public void verifyThatUserCanCreateNewClubAsAdmin() {
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        String clubName = "Джмелик&company =,/ , , *, (, ), _, :, ;, #, %, ^, ?, [, ] " + timestamp;
//        ClubPostRequest requestBody = new ClubPostRequest(
//                clubName,
//                "{\"blocks\":[{\"key\":\"brl63\",\"text\":\"Ми поставили перед собою ціль створити мережу найкращих центрів раннього розвитку в Україні, де дітки навчатимуться з задоволенням, а батьки радітимуть від результатів\",\"type\":\"unstyled\",\"depth\":1,\"inlineStyleRanges\":[],\"entityRanges\":[],\"data\":{}}],\"entityMap\":{}}",
//                2,
//                categoriesName,
//                locations,
//                2,
//                18,
//                null,
//                null,
//                true,
//                "{\"1\"::\"ліл\"}",
//                264
//        );
//        Response response = this.client.successPost(requestBody);
//        ClubPostResponse clubsResponse = response.as(ClubPostResponse.class);
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(response.getStatusCode(), 200);
//        softAssert.assertEquals(clubsResponse.getName(), clubName);
//        softAssert.assertAll();
//
//
//    }
//}
