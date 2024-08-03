package edu.miu.cs.cs425.repository;

import edu.miu.cs.cs425.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query("SELECT r FROM Review r WHERE r.product.productId = :productId")
    List<Review> findAllReviewsByProductId(@Param("productId") Integer productId);

}