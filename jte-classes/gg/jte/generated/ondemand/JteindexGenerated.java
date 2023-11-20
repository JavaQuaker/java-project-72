package gg.jte.generated.ondemand;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {1,1,1,1,1,1,4,4,48,48,48,48,50,50,50};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n<!doctype html>\r\n<html lang=\"en\">\r\n<head>\r\n    <meta charset=\"utf-8\">\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n    <link href=\"https://getbootstrap.com/docs/5.3/assets/css/docs.css\" rel=\"stylesheet\">\r\n    <title>Bootstrap Example</title>\r\n    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\"></script>\r\n</head>\r\n\r\n<body class=\"p-3 m-0 border-0 bd-example m-0 border-0\">\r\n<main class=\"flex-grow-1\">\r\n    <section>\r\n        <div class=\"container-fluid bg-dark p-5\">\r\n            <div class=\"row\">\r\n                <div class=\"col-md-10 col-lg-8 mx-auto text-white\">\r\n\r\n                    <h1 class=\"display-3 mb-0\">Анализатор страниц</h1>\r\n                    <p class=\"lead\">Бесплатно проверяйте сайты на SEO пригодность</p>\r\n                    <form action=\"/urls\" method=\"post\" class=\"rss-form text-body\">\r\n                        <div class=\"row\">\r\n                            <div class=\"col\">\r\n                                <div class=\"form-floating\">\r\n                                    <input id=\"url-input\" autofocus=\"\" type=\"text\" required=\"\" name=\"url\" aria-label=\"url\" class=\"form-control w-100\" placeholder=\"ссылка RSS\" autocomplete=\"off\">\r\n                                    <label for=\"url-input\">Ссылка</label>\r\n                                </div>\r\n                            </div>\r\n                            <div class=\"col-auto\">\r\n                                <button type=\"submit\" class=\"h-100 btn btn-lg btn-primary px-sm-5\">Проверить</button>\r\n                            </div>\r\n                        </div>\r\n                    </form>\r\n                    <p class=\"mt-2 mb-0 text-white\">Пример: https://www.example.com</p>\r\n\r\n                </div>\r\n            </div>\r\n        </div>\r\n    </section>\r\n</main>\r\n</body>\r\n</html>\r\n\r\n        ");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n<p>Thanks for visiting, come again soon!</p>\r\n        ");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
