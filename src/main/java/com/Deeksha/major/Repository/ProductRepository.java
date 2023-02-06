package com.Deeksha.major.Repository;

import com.Deeksha.major.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends JpaRepository<Product ,Long> {
}
