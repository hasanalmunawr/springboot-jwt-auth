package hasanalmunawrDev.springbootjwtauth.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpRequest {

    @NotBlank(message = "Username Must not blank")
    private String username;

    @NotBlank(message = "Password Must not blank")
    private String password;

    @NotBlank(message = "email Must not blank")
    private String email;
}
