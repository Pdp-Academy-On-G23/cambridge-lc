package uz.pdp.cambridgelc.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.cambridgelc.dto.request.UserLoginRequest;
import uz.pdp.cambridgelc.dto.request.UserRegisterRequest;
import uz.pdp.cambridgelc.dto.response.ApiResponse;
import uz.pdp.cambridgelc.service.user.UserService;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public HttpEntity<?> registerUser(
            @Valid
            @RequestBody UserRegisterRequest registerRequest
    ) {
        ApiResponse apiResponse = userService.registerUser(registerRequest);
        return ResponseEntity.status(apiResponse.getSuccess() ? 200 : 409).body(apiResponse);
    }

    @PostMapping("/login")
    public HttpEntity<?> loginUser(
            @Valid
            @RequestBody UserLoginRequest loginRequest
    ) {
        ApiResponse apiResponse = userService.loginUser(loginRequest);
        return ResponseEntity.status(apiResponse.getSuccess() ? 200 : 409).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteUser(
            @PathVariable Long id
    ) {
        ApiResponse apiResponse = userService.deleteUser(id);
        return ResponseEntity.status(apiResponse.getSuccess() ? 200 : 409).body(apiResponse);
    }


}
