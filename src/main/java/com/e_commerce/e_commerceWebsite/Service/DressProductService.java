
package com.e_commerce.e_commerceWebsite.Service;

// import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.e_commerce.e_commerceWebsite.Model.DressProduct;
import com.e_commerce.e_commerceWebsite.Repo.DressProductRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class DressProductService {

    @Autowired
    private DressProductRepository dressProductRepository;

    public void saveProductsFromFile(MultipartFile file, String imagesDir) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                String description = fields[1];
                Double price = Double.parseDouble(fields[2]);
                String imageName = fields[3];

                Path imagePath = Paths.get(imagesDir, imageName);
                byte[] image = Files.readAllBytes(imagePath);

                DressProduct product = new DressProduct();
                product.setName(name);
                product.setDescription(description);
                product.setPrice(price);
                product.setImage(image);

                dressProductRepository.save(product);
            }
        }
    }
}
