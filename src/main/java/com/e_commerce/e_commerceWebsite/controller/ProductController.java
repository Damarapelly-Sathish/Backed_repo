package com.e_commerce.e_commerceWebsite.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.e_commerce.e_commerceWebsite.Model.DressProduct;
import com.e_commerce.e_commerceWebsite.Service.DressProductService;

@CrossOrigin
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private DressProductService productService;

    @PostMapping("/upload")
    public String uploadFile(@RequestPart("file") MultipartFile file) {
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
    
    @GetMapping("/getproduct")
	public ResponseEntity<List<DressProduct>> getListProducts() {
        List<DressProduct> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/getproduct/filter")
    public ResponseEntity<List<DressProduct>> getFilterProducts(@RequestParam(required = false) String name,
            @RequestParam(required = false) String category) {
    	if(name!=null) {
        List<DressProduct> productsFilter = productService.getFilterProducts(name);
        return new ResponseEntity<>(productsFilter, HttpStatus.OK);}
    	else if(category!=null) {
        List<DressProduct> productsByCategory = productService.getProductsByCategory(category);
        return new ResponseEntity<>(productsByCategory, HttpStatus.OK);}
		return null;
    }
}
