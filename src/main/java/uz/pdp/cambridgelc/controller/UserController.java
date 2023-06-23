package uz.pdp.cambridgelc.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.cambridgelc.dto.request.UserDTO;
import uz.pdp.cambridgelc.dto.request.UserUpdateDTO;
import uz.pdp.cambridgelc.dto.request.UserUpdateForAdminDTO;
import uz.pdp.cambridgelc.dto.response.ApiResponse;
import uz.pdp.cambridgelc.entity.user.UserEntity;
import uz.pdp.cambridgelc.service.user.UserService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/admin/add")
    public ResponseEntity<ApiResponse<UserEntity>> addUser(
            @Valid
            @RequestBody UserDTO userDTO
    ) {
        UserEntity user = userService.addUser(userDTO);
        return ResponseEntity.ok(new ApiResponse<>(user));
    }

    @GetMapping("/admin/get-page")
    public ResponseEntity<ApiResponse<Page<UserEntity>>> getAllUsers(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "15") Integer size
    ) {
        Page<UserEntity> userEntities = userService.getAll(page, size);
        return ResponseEntity.ok(new ApiResponse<>(userEntities));
    }

    @GetMapping("/admin/get/{id}")
    public ResponseEntity<ApiResponse<UserEntity>> getUserById(
            @PathVariable Long id
    ) {
        UserEntity user = userService.getById(id);
        return ResponseEntity.ok(new ApiResponse<>(user));
    }

    // Update for User
    @PutMapping("/user/update/{id}")
    public ResponseEntity<ApiResponse<UserEntity>> editUser(
            @PathVariable Long id,
            @RequestBody UserUpdateDTO userUpdateDTO
    ) {
        UserEntity user = userService.editeUser(id, userUpdateDTO);
        return ResponseEntity.ok(new ApiResponse<>(user));
    }

    @PutMapping("/admin/update/{id}")
    public ResponseEntity<ApiResponse<UserEntity>> editUser(
            @PathVariable Long id,
            @RequestBody UserUpdateForAdminDTO userUpdateDTO
    ) {
        UserEntity user = userService.editeUserForAdmin(id, userUpdateDTO);
        return ResponseEntity.ok(new ApiResponse<>(user));
    }

    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<?> deleteUser(
            @PathVariable Long id
    ) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
