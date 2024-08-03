
package com.e_commerce.e_commerceWebsite.Service;
// import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.e_commerce.e_commerceWebsite.Model.DressProduct;
import com.e_commerce.e_commerceWebsite.Model.Product;
import com.e_commerce.e_commerceWebsite.Repo.DressProductRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class DressProductService {

    @Autowired
    private DressProductRepository dressProductRepository;

    public List<DressProduct> saveProductsFromFile(MultipartFile file, String imagesDir) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                System.out.println("filed length"+fields.length);
                if (fields.length < 4) {
                    // Skip this line or handle the error appropriately
                    System.out.println("Invalid line:");
   
                }

                String name = fields[0];
                String description = fields[1];
                Double price = null;
                try {
                    price = Double.parseDouble(fields[2]);
                } catch (NumberFormatException e) {
                    // Skip this line or handle the error appropriately
                    System.out.println("Invalid price: " + fields[2]);
                   
                }
                String imageName = fields[4];
                Double discount = null;
                discount = Double.parseDouble(fields[3]);
                int review=Integer.parseInt(fields[5]);
                int rating=Integer.parseInt(fields[6]);
                String gender = fields[7];
                String caterogy = fields[8];
                DressProduct product = new DressProduct();
                product.setName(name);
                product.setDescription(description);
                product.setPrice(price);
                product.setImage(imageName);
                product.setDiscount(discount);
                product.setReview(review);
                product.setRating(rating);
                product.setGender(gender);
                product.setCategory(caterogy);
                
                dressProductRepository.save(product);
            }
        }
		return null;
    }

	public List<DressProduct> getProducts() {
		return dressProductRepository.findAll();
	}
	public List<DressProduct> getFilterProducts(String name) {
		return dressProductRepository.findByName(name);
	}
	public List<DressProduct> getProductsByCategory(String category){
		return dressProductRepository.findByCategory(category);
	}
}
