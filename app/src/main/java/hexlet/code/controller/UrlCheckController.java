package hexlet.code.controller;
import java.sql.SQLException;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import hexlet.code.model.Url;
import hexlet.code.model.UrlCheck;
import hexlet.code.repository.UrlCheckRepository;
import hexlet.code.repository.UrlRepository;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class UrlCheckController {
    public static void checkUrl(Context ctx) throws SQLException {
        long id = ctx.pathParamAsClass("id", long.class).get();
        Url url = UrlRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found UrlRepository"));
        System.out.println("test from checkUrl method: " + url);

        try {
            var response = Unirest.get(url.getName()).asString();
            int statusCode = response.getStatus();
            System.out.println("status_code: " + statusCode);
            String body = response.getBody().toString();
            Document document = Jsoup.parse(body);
//            String h1 = document.selectFirst("h1") == null ? "" : document.selectFirst("h1").html();
            Element element = document.selectFirst("h1");
            String h1 = element == null ? "" : element.text();

            System.out.println("h1: " + h1);

            String title = document.title();
            System.out.println("title: " + title);
            String description = document.selectFirst("meta[name=description]") == null ? ""
                    : document.selectFirst("meta[name=description]").attr("content");
            System.out.println("description: " + description);
            UrlCheck urlCheck = new UrlCheck(id, statusCode, title, h1, description);
            System.out.println("urlCheck from checkUrl method: " + urlCheck);
            UrlCheckRepository.save(urlCheck);

            ctx.sessionAttribute("flash", "page has been successfully verified");
            System.out.println("test flash verified");
            ctx.sessionAttribute("flash-type", "success");
        } catch (UnirestException ex) {
            ctx.sessionAttribute("flash", "page not verified");
        } catch (Exception e) {
            ctx.sessionAttribute("flash", "error");
        }
        ctx.redirect("/urls/" + url.getId());
    }
}
