package org.example.bstagrambe.feed;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UploadService {
    List<String> upload(List<MultipartFile> fileList);
}
