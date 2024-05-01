package com.danimtnz.fuelapi.config;

import com.danimtnz.fuelapi.util.SSLUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Configuration
public class SSLConfiguration {

    @Value("${app.certPath}")
    private String certPath;

    @Bean
    public Object configureSSL() {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();

        // Static cert route
//        String certPath = "classpath:files/sedeaplicaciones.minetur.gob.es.crt";

        try {
            // Take the path from app properties
            Resource resource = resourceLoader.getResource(certPath);

            // Copiar el archivo de recursos a un directorio temporal
            InputStream inputStream = resource.getInputStream();
            byte[] buffer = FileCopyUtils.copyToByteArray(inputStream);

            String tempDir = System.getProperty("java.io.tmpdir");
            String certFilePath = tempDir + "/sedeaplicaciones.minetur.gob.es.crt";
            OutputStream outputStream = new FileOutputStream(certFilePath);
            FileCopyUtils.copy(buffer, outputStream);
            inputStream.close();
            outputStream.close();

            SSLUtil.configureTrustManager(certFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Object();
    }
}


//		ResourceLoader resourceLoader = new DefaultResourceLoader();
//
//		// Ruta al certificado en el classpath
//		String certPath = "classpath:files/sedeaplicaciones.minetur.gob.es.crt";
//
//		try {
//			// Obtener el recurso
//			Resource resource = resourceLoader.getResource(certPath);
//
//			// Copiar el archivo de recursos a un directorio temporal
//			InputStream inputStream = resource.getInputStream();
//			byte[] buffer = FileCopyUtils.copyToByteArray(inputStream);
//
//			String tempDir = System.getProperty("java.io.tmpdir");
//			String certFilePath = tempDir + "/sedeaplicaciones.minetur.gob.es.crt";
//			OutputStream outputStream = new FileOutputStream(certFilePath);
//			FileCopyUtils.copy(buffer, outputStream);
//			inputStream.close();
//			outputStream.close();
//
//			// Configurar SSL
//			SSLUtil.configureTrustManager(certFilePath);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}