
@import hexlet.code.dto.UrlsPage
        @import hexlet.code.model.Url
        @import hexlet.code.model.UrlCheck
        @param UrlsPage page

        @template.layout.page(
        content = @`

        @if(page != null && page.getFlash() != null)
<main class="flex-grow-1">
    <div class="rounded-0 m-0 alert alert-dismissible fade show alert-success" role="alert">

        <p class="m-0" >${page.getFlash()}</p>
        @endif
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <section>
        <div class="container-lg mt-5">
            <h1>Сайты</h1>

            <table class="table table-bordered table-hover mt-3">
                <thead>
                <tr>
                    <th class="col-1">ID</th>
                    <th>Имя</th>
                    <th class="col-2">Последняя проверка</th>
                    <th class="col-1">Код ответа</th>
                </tr>
                </thead>
                <tbody>
                @for(var url : page.getUrls())

                <tr>
                    <td>${url.getId()}</td>
                    <td>
                        <a href="/urls/${url.getId()}">${url.getName()}</a>
                    </td>
                    <td>${page.getUrlChecks().isEmpty() || page.getUrlChecks().get(url.getId()) == null ? "" : page.getUrlChecks().get(url.getId()).getCreatedAt().toString()}</td>
                    <td>${page.getUrlChecks().isEmpty() || page.getUrlChecks().get(url.getId()) == null ? "" : page.getUrlChecks().get(url.getId()).getStatusCode().toString()}</td>


                </tr>
                @endfor



                </tbody>
            </table>

            <nav aria-label="Page navigation">
                <ul class="pagination justify-content-center mt-5">
                    <li class="page-item disabled">
                        <a class="page-link" href="/urls?page=0">Previous</a>
                    </li>
                    <li class="page-item active">
                        <a class="page-link" href="/urls?page=1">1</a>
                    </li>
                    <li class="page-item disabled">
                        <a class="page-link" href="/urls?page=2">Next</a>
                    </li>
                </ul>
            </nav>
        </div>
    </section>
</main>

        `,
        footer = @`
<p>Thanks for visiting, come again soon!</p>
        `
        )