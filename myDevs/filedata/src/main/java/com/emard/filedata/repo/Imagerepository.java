package com.emard.filedata.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emard.filedata.entities.Image;

public interface Imagerepository extends JpaRepository<Image, Long> {
    
}
