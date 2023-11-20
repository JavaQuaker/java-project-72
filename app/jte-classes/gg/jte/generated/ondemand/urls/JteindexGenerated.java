package gg.jte.generated.ondemand.urls;
import hexlet.code.dto.UrlsPage;
import hexlet.code.model.Url;
import hexlet.code.model.UrlCheck;
public final class JteindexGenerated {
	public static final String JTE_NAME = "urls/index.jte";
	public static final int[] JTE_LINE_INFO = {1,1,2,3,4,4,4,6,6,9,9,11,11,15,15,15,16,16,33,33,36,36,36,38,38,38,38,38,38,38,40,40,40,41,41,41,45,45,69,69,69,69,71,71,71};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlsPage page) {
		jteOutput.writeContent("\r\n        ");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n\r\n        ");
				if (page != null && page.getFlash() != null) {
					jteOutput.writeContent("\r\n<main class=\"flex-grow-1\">\r\n    <div class=\"rounded-0 m-0 alert alert-dismissible fade show alert-success\" role=\"alert\">\r\n\r\n        <p class=\"m-0\" >");
					jteOutput.setContext("p", null);
					jteOutput.writeUserContent(page.getFlash());
					jteOutput.writeContent("</p>\r\n        ");
				}
				jteOutput.writeContent("\r\n        <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\r\n    </div>\r\n    <section>\r\n        <div class=\"container-lg mt-5\">\r\n            <h1>Сайты</h1>\r\n\r\n            <table class=\"table table-bordered table-hover mt-3\">\r\n                <thead>\r\n                <tr>\r\n                    <th class=\"col-1\">ID</th>\r\n                    <th>Имя</th>\r\n                    <th class=\"col-2\">Последняя проверка</th>\r\n                    <th class=\"col-1\">Код ответа</th>\r\n                </tr>\r\n                </thead>\r\n                <tbody>\r\n                ");
				for (var url : page.getUrls()) {
					jteOutput.writeContent("\r\n\r\n                <tr>\r\n                    <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(url.getId());
					jteOutput.writeContent("</td>\r\n                    <td>\r\n                        <a href=\"/urls/");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(url.getId());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\">");
					jteOutput.setContext("a", null);
					jteOutput.writeUserContent(url.getName());
					jteOutput.writeContent("</a>\r\n                    </td>\r\n                    <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(page.getUrlChecks().isEmpty() || page.getUrlChecks().get(url.getId()) == null ? "" : page.getUrlChecks().get(url.getId()).getCreatedAt().toString());
					jteOutput.writeContent("</td>\r\n                    <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(page.getUrlChecks().isEmpty() || page.getUrlChecks().get(url.getId()) == null ? "" : page.getUrlChecks().get(url.getId()).getStatusCode().toString());
					jteOutput.writeContent("</td>\r\n\r\n\r\n                </tr>\r\n                ");
				}
				jteOutput.writeContent("\r\n\r\n\r\n\r\n                </tbody>\r\n            </table>\r\n\r\n            <nav aria-label=\"Page navigation\">\r\n                <ul class=\"pagination justify-content-center mt-5\">\r\n                    <li class=\"page-item disabled\">\r\n                        <a class=\"page-link\" href=\"/urls?page=0\">Previous</a>\r\n                    </li>\r\n                    <li class=\"page-item active\">\r\n                        <a class=\"page-link\" href=\"/urls?page=1\">1</a>\r\n                    </li>\r\n                    <li class=\"page-item disabled\">\r\n                        <a class=\"page-link\" href=\"/urls?page=2\">Next</a>\r\n                    </li>\r\n                </ul>\r\n            </nav>\r\n        </div>\r\n    </section>\r\n</main>\r\n\r\n        ");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n<p>Thanks for visiting, come again soon!</p>\r\n        ");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlsPage page = (UrlsPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
