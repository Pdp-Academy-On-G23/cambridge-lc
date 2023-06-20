package uz.pdp.cambridgelc.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginRequest {

    @NotNull
    private String phoneNumber;

    @NotNull
    private String password;

    @NotNull
    private Integer roleId;
}
