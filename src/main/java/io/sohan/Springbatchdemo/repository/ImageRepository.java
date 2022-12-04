package io.sohan.Springbatchdemo.repository;

import io.sohan.Springbatchdemo.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,Long> {
}
