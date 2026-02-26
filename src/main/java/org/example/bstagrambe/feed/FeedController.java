package org.example.bstagrambe.feed;

import lombok.RequiredArgsConstructor;
import org.example.bstagrambe.feed.model.FeedDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/feed")
@RestController
@RequiredArgsConstructor
public class FeedController {
    private final UploadService uploadService;
    private final FeedService feedService;

    @PostMapping("/reg")
    public ResponseEntity upload(
            @RequestPart FeedDto.RegReq dto,
            @RequestPart List<MultipartFile> images
            ) {
        FeedDto.RegRes result = feedService.register(dto);
        uploadService.upload(images);

        return ResponseEntity.ok(result);
    }
}
