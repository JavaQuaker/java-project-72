package gg.jte.generated.ondemand.urls;
import hexlet.code.dto.UrlPage;
import hexlet.code.model.Url;
import hexlet.code.model.UrlCheck;
public final class JteshowGenerated {
	public static final String JTE_NAME = "urls/show.jte";
	public static final int[] JTE_LINE_INFO = {1,1,2,3,4,4,4,6,6,9,9,17,24,24,29,29,29,30,30,36,36,36,42,42,42,46,46,46,50,50,50,57,57,57,57,73,73,74,74,74,75,75,75,76,77,77,77,78,79,79,79,80,81,81,81,82,82,82,85,85,93,93,93,93,95,95,95};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlPage page) {
		jteOutput.writeContent("\r\n        ");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n\r\n\r\n<style>\r\n    .ellipsis {\r\n      white-space: nowrap;\r\n      overflow: hidden;\r\n      text-overflow: ellipsis;\r\n      max-width: 250px; ");
				jteOutput.writeContent("\r\n    }\r\n    .table-bordered.table-hover.mt-3 td,\r\n    .table-bordered.table-hover.mt-3 th {\r\n      word-wrap: break-word;\r\n    }\r\n</style>\r\n        ");
				if (page != null && page.getFlash() != null) {
					jteOutput.writeContent("\r\n\r\n<main class=\"flex-grow-1\">\r\n<div class=\"rounded-0 m-0 alert alert-dismissible fade show alert-success\" role=\"alert\">\r\n\r\n    <p class=\"m-0\" >");
					jteOutput.setContext("p", null);
					jteOutput.writeUserContent(page.getFlash());
					jteOutput.writeContent("</p>\r\n    ");
				}
				jteOutput.writeContent("\r\n    <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\r\n</div>\r\n<section>\r\n    <div class=\"container-lg mt-5\">\r\n\r\n        <h1>Сайт: ");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(page.getUrl().getName());
				jteOutput.writeContent("</h1>\r\n\r\n        <table class=\"table table-bordered table-hover mt-3\">\r\n            <tbody>\r\n            <tr>\r\n                <td>ID</td>\r\n                <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUrl().getId());
				jteOutput.writeContent("</td>\r\n            </tr>\r\n            <tr>\r\n                <td>Имя</td>\r\n                <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUrl().getName());
				jteOutput.writeContent("</td>\r\n            </tr>\r\n            <tr>\r\n                <td>Дата создания</td>\r\n                <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUrl().getCreatedAt().toString());
				jteOutput.writeContent("</td>\r\n            </tr>\r\n            </tbody>\r\n        </table>\r\n\r\n\r\n        <h2 class=\"mt-5\">Проверки</h2>\r\n        <form method=\"post\" action=\"/urls/");
				jteOutput.setContext("form", "action");
				jteOutput.writeUserContent(page.getUrl().getId());
				jteOutput.setContext("form", null);
				jteOutput.writeContent("/checks\">\r\n            <button type=\"submit\" class=\"btn btn-primary\">Запустить проверку</button>\r\n        </form>\r\n\r\n        <table class=\"table table-bordered table-hover mt-3\">\r\n            <thead>\r\n            <tr>\r\n                <th class=\"col-1\">ID</th>\r\n                <th class=\"col-1\">Код ответа</th>\r\n                <th>title</th>\r\n                <th>h1</th>\r\n                <th>description</th>\r\n                <th class=\"col-2\">Дата проверки</th>\r\n            </tr></thead>\r\n            <tbody>\r\n            <tr>\r\n                ");
				for (UrlCheck urlCheck : page.getUrlCheck()) {
					jteOutput.writeContent("\r\n                <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(urlCheck.getId());
					jteOutput.writeContent("</td>\r\n                <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(urlCheck.getStatusCode());
					jteOutput.writeContent("</td>\r\n                ");
					jteOutput.writeContent("\r\n                <td><div class=\"ellipsis\">");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(urlCheck.getTitle());
					jteOutput.writeContent("</div></td>\r\n                ");
					jteOutput.writeContent("\r\n                <td><div class=\"ellipsis\">");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(urlCheck.getH1());
					jteOutput.writeContent("</div></td>\r\n                ");
					jteOutput.writeContent("\r\n                <td><div class=\"ellipsis\">");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(urlCheck.getDescription());
					jteOutput.writeContent("</div></td>\r\n                <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(urlCheck.getCreatedAt().toString());
					jteOutput.writeContent("</td>\r\n\r\n            </tr>\r\n            ");
				}
				jteOutput.writeContent("\r\n\r\n            </tbody>\r\n        </table>\r\n    </div>\r\n</section>\r\n</main>\r\n\r\n        ");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n<p>Thanks for visiting, come again soon!</p>\r\n        ");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlPage page = (UrlPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
