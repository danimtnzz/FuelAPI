package com.danimtnz.fuelapi;

import com.danimtnz.fuelapi.util.SSLUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@SpringBootApplication
public class FuelapiApplication {
	public static void main(String[] args) {
		SpringApplication.run(FuelapiApplication.class, args);
	}
}
