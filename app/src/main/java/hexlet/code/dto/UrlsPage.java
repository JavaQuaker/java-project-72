package hexlet.code.dto;
import hexlet.code.model.Url;
import hexlet.code.model.UrlCheck;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class UrlsPage {
    private List<Url> urls;
    public String flash;
    private Map<Long, UrlCheck> urlChecks;
}
