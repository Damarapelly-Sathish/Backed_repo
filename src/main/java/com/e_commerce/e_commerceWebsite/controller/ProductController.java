package com.e_commerce.e_commerceWebsite.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.e_commerce.e_commerceWebsite.Service.DressProductService;
import com.e_commerce.e_commerceWebsite.Service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private DressProductService productService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // Assuming imagesDir is a directory where images are stored.
            String imagesDir = "C:\\my-practice\\public";
            productService.saveProductsFromFile(file, imagesDir);
            return "File uploaded and products saved successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to upload file";
        }
    }
}
