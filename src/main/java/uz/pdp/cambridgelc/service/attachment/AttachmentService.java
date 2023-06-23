package uz.pdp.cambridgelc.service.attachment;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.cambridgelc.entity.attachment.AttachmentEntity;

public interface AttachmentService {
    AttachmentEntity uploadFile(MultipartHttpServletRequest request);
}
