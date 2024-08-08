package edu.miu.cs.cs425.service;

import edu.miu.cs.cs425.exception.ReviewException;
import edu.miu.cs.cs425.model.Review;

import java.util.List;

public interface ReviewService {

    public Review addReviewToProduct(Integer productId, Integer UserId, Review review)
            throws ReviewException;

    public Review updateReviewToProduct(Integer reviewId,Review review)
            throws ReviewException;

    public void deleteReview(Integer reviewId) throws ReviewException;

    public List<Review> getAllReviewOfProduct(Integer productId)throws ReviewException;

}