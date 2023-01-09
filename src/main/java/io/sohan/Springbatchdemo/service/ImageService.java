package io.sohan.Springbatchdemo.service;

import io.sohan.Springbatchdemo.model.Image;
import io.sohan.Springbatchdemo.repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    private ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public List<Image> getAllImg(){
        return imageRepository.findAll();
    }

    public Image add(Image image){
        return imageRepository.save(image);
    }

    public String deleteImg(long id){
        String img=imageRepository.findById(id).get().getName();
        imageRepository.deleteById(id);
        return img;
    }
}
