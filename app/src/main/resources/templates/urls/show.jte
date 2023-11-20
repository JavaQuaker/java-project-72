
@import hexlet.code.dto.UrlPage
        @import hexlet.code.model.Url
        @import hexlet.code.model.UrlCheck
        @param UrlPage page

        @template.layout.page(
        content = @`


<style>
    .ellipsis {
      white-space: nowrap;
      overflow: hidden;
      text-overflow: ellipsis;
      max-width: 250px; /*  ширина столбца */
    }
    .table-bordered.table-hover.mt-3 td,
    .table-bordered.table-hover.mt-3 th {
      word-wrap: break-word;
    }
</style>
        @if(page != null && page.getFlash() != null)

<main class="flex-grow-1">
<div class="rounded-0 m-0 alert alert-dismissible fade show alert-success" role="alert">

    <p class="m-0" >${page.getFlash()}</p>
    @endif
    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>
<section>
    <div class="container-lg mt-5">

        <h1>Сайт: ${page.getUrl().getName()}</h1>

        <table class="table table-bordered table-hover mt-3">
            <tbody>
            <tr>
                <td>ID</td>
                <td>${page.getUrl().getId()}</td>
            </tr>
            <tr>
                <td>Имя</td>
                <td>${page.getUrl().getName()}</td>
            </tr>
            <tr>
                <td>Дата создания</td>
                <td>${page.getUrl().getCreatedAt().toString()}</td>
            </tr>
            </tbody>
        </table>


        <h2 class="mt-5">Проверки</h2>
        <form method="post" action="/urls/${page.getUrl().getId()}/checks">
            <button type="submit" class="btn btn-primary">Запустить проверку</button>
        </form>

        <table class="table table-bordered table-hover mt-3">
            <thead>
            <tr>
                <th class="col-1">ID</th>
                <th class="col-1">Код ответа</th>
                <th>title</th>
                <th>h1</th>
                <th>description</th>
                <th class="col-2">Дата проверки</th>
            </tr></thead>
            <tbody>
            <tr>
                @for (UrlCheck urlCheck : page.getUrlCheck())
                <td>${urlCheck.getId()}</td>
                <td>${urlCheck.getStatusCode()}</td>
                <!--td>${urlCheck.getTitle()}</td-->
                <td><div class="ellipsis">${urlCheck.getTitle()}</div></td>
                <!--td>${urlCheck.getH1()}</td-->
                <td><div class="ellipsis">${urlCheck.getH1()}</div></td>
                <!--td>${urlCheck.getDescription()}</td-->
                <td><div class="ellipsis">${urlCheck.getDescription()}</div></td>
                <td>${urlCheck.getCreatedAt().toString()}</td>

            </tr>
            @endfor

            </tbody>
        </table>
    </div>
</section>
</main>

        `,
        footer = @`
<p>Thanks for visiting, come again soon!</p>
        `
        )