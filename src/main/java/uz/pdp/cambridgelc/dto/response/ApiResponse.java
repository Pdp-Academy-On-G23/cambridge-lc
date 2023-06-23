package uz.pdp.cambridgelc.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {

    private String message;

    private Boolean success;

    private T data;

    public ApiResponse(T data) {
        this.data = data;
    }

    public ApiResponse(String message, Boolean success) {
        this.message = message;
        this.success = success;
    }

    public ApiResponse(String message, Boolean success, T data) {
        this.message = message;
        this.success = success;
        this.data = data;
    }
}
