package io.sohan.Springbatchdemo.jobs;

import io.sohan.Springbatchdemo.model.Image;
import io.sohan.Springbatchdemo.service.ImageService;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Configuration;

@Configuration
//@StepScope
public class ImageUploaderProcessor {//implements ItemProcessor<Image> {

    private ImageService imageService;

    public ImageUploaderProcessor(ImageService imageService) {
        this.imageService = imageService;
    }

//    @Override
    public Object process(Object o) throws Exception {
        return null;
    }

//    @Override
//    public Object process(Object o) throws Exception {
//        return null;
//    }
}
