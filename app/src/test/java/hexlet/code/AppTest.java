package hexlet.code;
import hexlet.code.model.Url;
import hexlet.code.repository.UrlRepository;
import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
public class AppTest {
    Javalin app;
    private MockWebServer mockWebServer;

    @BeforeEach
    public final void setUp() throws SQLException, IOException {
        app = App.getApp();
    }
    @BeforeAll
    public static void beforeAll() throws IOException {
        MockWebServer mockServer = new MockWebServer();
        MockResponse mockedResponse = new MockResponse()
                .setBody(readFixture("index.html"));
        mockServer.enqueue(mockedResponse);
        mockServer.start();
    }
    private static String readFixture(String fileName) throws IOException {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }
    private static Path getFixturePath(String fileName) {
        return Paths.get("src/test/resources/example.html");
    }



    @Test
    public void testMainPage() {
        JavalinTest.test(app, ((server, client) -> {
            var response = client.get("/");
            assertThat(response.code()).isEqualTo(200);
        }));
    }

    @Test
    public void testUrlsPage() {
        JavalinTest.test(app, ((server, client) -> {
            var response = client.get("/urls");
            assertThat(response.code()).isEqualTo(200);
        }));
    }
    @Test
    public void testCreateUrl() {
        JavalinTest.test(app, (server, client) -> {
            var requestBody = "url=https://www.test.io";
            var response = client.post("/urls", requestBody);
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("https://www.test.io");

        });
    }

    @Test
    public void testUrlsIdNotFound() throws SQLException {
        Url site = new Url(1, "www.example.ru", null);
        UrlRepository.save(site);
        JavalinTest.test(app, ((server, client) -> {
            var response = client.get("/urls/1000");
            assertThat(response.code()).isEqualTo(404);
        }));
    }

    @Test
    public void testUrlPage() throws SQLException {
        Url site = new Url(2, "www.example.ru", null);
        UrlRepository.save(site);
        JavalinTest.test(app, ((server, client) -> {
            var response = client.get("/urls/" + site.getId());
            assertThat(response.code()).isEqualTo(200);
        }));
    }
    @Test
    public void testShowUrlById() throws SQLException {
        Url url = new Url("https://www.test.io");
        UrlRepository.save(url);

        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/urls/" + url.getId());
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("https://www.test.io");
        });
    }
    @Test
    void testStore() throws SQLException {
        String inputUrl = "https://ru.hexlet.io";

        JavalinTest.test(app, (server, client) -> {
            var requestBody = "url=" + inputUrl;
            var response = client.post("/urls", requestBody);
            assertThat(response.code()).isEqualTo(200);
        });

        Url actualUrl = UrlRepository.findName(inputUrl).orElse(null);

        assertThat(actualUrl).isNotNull();
        assertThat(actualUrl.getName()).isEqualTo(inputUrl);
    }
}
