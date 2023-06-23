package uz.pdp.cambridgelc.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateForAdminDTO {

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String password;

    private Integer roleId;
}
