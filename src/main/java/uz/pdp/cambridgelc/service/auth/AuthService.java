package uz.pdp.cambridgelc.service.auth;

import uz.pdp.cambridgelc.dto.request.UserLoginRequest;
import uz.pdp.cambridgelc.dto.response.ApiResponse;

public interface AuthService {

    ApiResponse loginUser(UserLoginRequest loginRequest);
}
