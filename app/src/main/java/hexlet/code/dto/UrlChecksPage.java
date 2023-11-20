package hexlet.code.dto;
import hexlet.code.model.UrlCheck;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
public class UrlChecksPage {
    private List<UrlCheck> urlCheckList;
}
