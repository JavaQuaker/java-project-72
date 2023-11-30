package hexlet.code.controller;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.net.URL;
import java.util.Map;


import hexlet.code.dto.UrlPage;
import hexlet.code.dto.UrlsPage;
import hexlet.code.model.Url;
import hexlet.code.model.UrlCheck;
import hexlet.code.repository.UrlCheckRepository;
import hexlet.code.repository.UrlRepository;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;


public class UrlsController {
    public static void index(Context ctx) throws SQLException {
        String flash = ctx.consumeSessionAttribute("flash");
        List<Url> urls = UrlRepository.getEntities();
        Map<Long, UrlCheck> urlChecks = UrlCheckRepository.lastVerification();
        UrlsPage page = new UrlsPage(urls, flash, urlChecks);
        System.out.println("form: " + urlChecks);
        ctx.render("urls/index.jte", Collections.singletonMap("page", page));
    }
    public static void show(Context ctx) throws SQLException {
        String flash = ctx.consumeSessionAttribute("flash");
        var id = ctx.pathParamAsClass("id", Long.class).get();
        Url url = UrlRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        System.out.println("site test: " + url.toString());
        List<UrlCheck> urlChecks = UrlCheckRepository.getUrlChecks(id);

        var page = new UrlPage(url, urlChecks, flash);

        System.out.println("page test :" + page.toString());
        System.out.println("urlChecks: " + urlChecks);
        ctx.render("urls/show.jte", Collections.singletonMap("page", page));
    }
    public static void create(Context ctx) throws SQLException, MalformedURLException {
        var url = ctx.formParam("url");
        URL parsedUrl;

        try {
            parsedUrl  = new URL(url);
        } catch (MalformedURLException e) {
            ctx.sessionAttribute("flash", "incorrect URL");
            ctx.redirect("/urls");
            return;
        }
        String normalizedUrl = String
                .format(
                        "%s://%s%s",
                        parsedUrl.getProtocol(),
                        parsedUrl.getHost(),
                        parsedUrl.getPort() == -1 ? "" : ":" + parsedUrl.getPort()
                )
                .toLowerCase();

        if (!UrlRepository.findName(normalizedUrl.toString()).isPresent()) {
            Url newUrl = new Url(normalizedUrl);
            UrlRepository.save(newUrl);
            ctx.sessionAttribute("flash", "site is successfully added");
        } else {
            ctx.sessionAttribute("flash", "site already exist");
            ctx.sessionAttribute("flash-type", "danger");
            ctx.redirect("/urls");
        }
        ctx.redirect("/urls");
    }
}
