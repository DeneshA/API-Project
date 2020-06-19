package co.pragra.coop.springbootjpaproject.repositories;

import co.pragra.coop.springbootjpaproject.entities.CourseReview;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseReviewRepo extends MongoRepository<CourseReview,String> {
    CourseReview findByCRId(String s);
}
