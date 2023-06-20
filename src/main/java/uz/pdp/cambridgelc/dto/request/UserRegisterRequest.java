package uz.pdp.cambridgelc.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterRequest {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String password;

    @NotNull
    private Integer roleId;
}
