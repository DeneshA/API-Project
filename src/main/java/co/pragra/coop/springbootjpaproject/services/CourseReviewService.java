package co.pragra.coop.springbootjpaproject.services;

import co.pragra.coop.springbootjpaproject.entities.CourseReview;
import co.pragra.coop.springbootjpaproject.exceptions.NotFoundException;
import co.pragra.coop.springbootjpaproject.exceptions.RequiredDataMissingException;
import co.pragra.coop.springbootjpaproject.repositories.CourseReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CourseReviewService {

    Date dateobj = new Date();

    @Autowired
    public CourseReviewRepo courseReviewRepo;

    //Post
    public CourseReview saveUserReviewServices(CourseReview courseReview){

        if(null != courseReview){
            if(null == courseReview.getReviewer() || courseReview.getReviewer().equals("")){
                throw new RequiredDataMissingException("Reviewer should not be empty");
            }else if (courseReview.getReviewDate() != dateobj) {
                throw new RequiredDataMissingException("The date should be today");
            }else if (null == courseReview.getReviewComments() || courseReview.getReviewComments().equals("")){
                throw new RequiredDataMissingException("please review your comments and it should not be empty");
            }
            return courseReviewRepo.save(courseReview);
        }
        // throw new RequiredDataMissingException("User body cannot be null");
        throw  new RequiredDataMissingException("User Review cannot be null");
    }

    //Put
    public CourseReview updateCourseReview(CourseReview courseReview){
        if(null != courseReview){
//            if(null == user.getFirstName() || user.getFirstName().equals("")){
//                throw new RequiredDataMissingException("Name should not be empty");
//            }
            CourseReview fetctCourseReview = courseReviewRepo.findByCRId(courseReview.getId());
            //fetctCourseReview1.setLogin(user.getLogin());
            fetctCourseReview.setReviewer(courseReview.getReviewer());
            fetctCourseReview.setReviewDate(courseReview.getReviewDate());
            fetctCourseReview.setModifiedDate(courseReview.getModifiedDate());
            fetctCourseReview.setReviewStar(courseReview.getReviewStar());
            fetctCourseReview.setReviewComments(courseReview.getReviewComments());
            fetctCourseReview.setStatusEnum(courseReview.getStatusEnum());
            fetctCourseReview.setProgramId(courseReview.getProgramId());
            fetctCourseReview.setModified(courseReview.isModified());
            return  courseReviewRepo.save(fetctCourseReview);
        }
        throw new RequiredDataMissingException("Review body can't be null");
    }
    //Get
    public Optional<CourseReview> getCourseReviewById(String id) throws NotFoundException {
        //need a validation
        return courseReviewRepo.findById(id);
    }
    //Get - All reviews
    public List<CourseReview> getAllCourseReview(){
        return  courseReviewRepo.findAll();
    }

    //Delete
    public String deleteCourseReview(String id){
        Optional<CourseReview> byid = (courseReviewRepo.findById(id));
        if ( !byid.isPresent())
        {
            throw  new RequiredDataMissingException("Course review " + id +" Doesn't exist ");
        }
         courseReviewRepo.deleteById(id);
        return " Your review Sucessfully removed " + id;
    }
}
