package io.sohan.Springbatchdemo.jobs;

import io.sohan.Springbatchdemo.model.Image;
import io.sohan.Springbatchdemo.service.ImageService;
import io.sohan.Springbatchdemo.service.ImageUploader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class ImageUploaderWriter implements ItemWriter<MultipartFile> {
    private ImageUploader imageUploader;
    private ImageService imageService;

    public ImageUploaderWriter(ImageUploader imageUploader, ImageService imageService) {
        this.imageUploader = imageUploader;
        this.imageService = imageService;
    }

    @Override
    public void write(List<? extends MultipartFile> list) throws Exception {
        list.forEach(multipartFile -> {
            try {
                imageUploader.store(multipartFile);
            } catch (IOException e) {
                throw new RuntimeException("Failed to store\n"+e.getMessage());
            }
        });
    }

//    private ImageUploader imageUploader;
//    private ImageService imageService;
//
//    public ImageUploaderWriter(ImageUploader imageUploader, ImageService imageService) {
//        this.imageUploader = imageUploader;
//        this.imageService = imageService;
//    }
//
//
//    @Override
//    public void write(List<? extends Image> list) throws Exception {
//        list.forEach(image -> imageService.add(image));
//    }
}
