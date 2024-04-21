package hasanalmunawrDev.springbootjwtauth.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignInResponse {

    private String token;

    private long expiresIn;
}
