package com.e_commerce.e_commerceWebsite.Repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.e_commerce.e_commerceWebsite.Model.DressProduct;

public interface DressProductRepository extends JpaRepository<DressProduct, Long> {
	@Query(value="SELECT * FROM dress_product  WHERE  name=:name",nativeQuery=true)
	List<DressProduct> findByName(@Param("name") String name);
	@Query(value="SELECT * FROM dress_product  WHERE  category=:category",nativeQuery=true)
    List<DressProduct> findByCategory(@Param("category") String category);
}
