package io.sohan.Springbatchdemo.controller;

import io.sohan.Springbatchdemo.service.ImageService;
import io.sohan.Springbatchdemo.service.ImageUploader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;

public class ImageController {

    private ImageService imageService;
    private ImageUploader imageUploader;

    public ImageController(ImageService imageService, ImageUploader imageUploader) {
        this.imageService = imageService;
        this.imageUploader = imageUploader;
    }

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;

    private static final Logger logger = LoggerFactory.getLogger(ImageController.class);


}
