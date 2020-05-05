package ApiModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
public class Post {

        int userId;
        String title;
        String body;
        int Id;




    }
