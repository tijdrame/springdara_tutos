package com.emard.filedata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.emard.filedata.entities.Image;
import com.emard.filedata.repo.Imagerepository;

@SpringBootTest
class FiledataApplicationTests {

	@Autowired Imagerepository repository;

	@Test
	void testImageSaved() throws IOException {
		Image image = Image.builder()
		.name("datasource.PNG").build();

		File f = new File("C:\\Users\\tidiane\\OneDrive - Alithya\\Pictures\\Capture.PNG");
		byte fileContent[] = new byte[(int) f.length()]; 
		FileInputStream inputStream = new FileInputStream(f);
		inputStream.read(fileContent);
		image.setData(fileContent);
		repository.save(image);
		inputStream.close();
	}

	@Test
	void testReadImage() throws IOException{
		Image image =  repository.findById(1L).get();
		File f = new File("C:\\Users\\tidiane\\OneDrive - Alithya\\Pictures\\"+image.getName());
		FileOutputStream fos = new FileOutputStream(f);
		fos.write(image.getData());
		fos.close();
	}

}
