package uz.pdp.cambridgelc.service.user;

import uz.pdp.cambridgelc.dto.request.UserLoginRequest;
import uz.pdp.cambridgelc.dto.request.UserRegisterRequest;
import uz.pdp.cambridgelc.dto.response.ApiResponse;

public interface UserService {
    ApiResponse registerUser(UserRegisterRequest registerRequest);

    ApiResponse loginUser(UserLoginRequest loginRequest);

    ApiResponse deleteUser(Long id);
}
