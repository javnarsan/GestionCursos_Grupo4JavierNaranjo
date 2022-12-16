package com.example.upload;

import java.nio.file.Path;
import java.util.stream.Stream;

import javax.annotation.Resource;

import org.springframework.web.multipart.MultipartFile;

public interface StrorageService{
	  public void init();

	  public void save(MultipartFile file,int id);

	  public Resource load(String filename);

	  public void deleteAll();

	  public Stream<Path> loadAll();
}
