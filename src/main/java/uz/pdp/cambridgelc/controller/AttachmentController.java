package uz.pdp.cambridgelc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.cambridgelc.dto.response.ApiResponse;
import uz.pdp.cambridgelc.entity.attachment.AttachmentEntity;
import uz.pdp.cambridgelc.service.attachment.AttachmentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/attachment")
public class AttachmentController {

    private final AttachmentService attachmentService;

    @PostMapping("/upload")
    public ResponseEntity<ApiResponse<AttachmentEntity>> upload(MultipartHttpServletRequest request) {
        AttachmentEntity attachment = attachmentService.uploadFile(request);
        return ResponseEntity.ok(new ApiResponse<>(attachment));
    }

}
