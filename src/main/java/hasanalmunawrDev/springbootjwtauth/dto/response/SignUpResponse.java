package hasanalmunawrDev.springbootjwtauth.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpResponse {

    private String username;

    private String email;

    @JsonProperty("created_at")
    private Date createdAt;
}
