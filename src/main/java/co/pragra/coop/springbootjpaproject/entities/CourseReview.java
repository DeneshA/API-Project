package co.pragra.coop.springbootjpaproject.entities;

import co.pragra.coop.springbootjpaproject.enums.StatusEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Entity(name = "course_reviews")
public class CourseReview {



        //@ApiProperty({description:'Review ID for the review'})
        //@ObjectIdColumn()
        private  String id;

        //@ApiProperty({description: 'Reviver Name -> First & Last | Aur Supplied Name'})
        @Column()
        private String reviewer ;

        //@ApiProperty({description: 'Date of Review'})
        @Column()
        private Date reviewDate;

        //@ApiProperty({description: 'Set to null if review has not been modified'})
        @Column(nullable= true)
        private Date modifiedDate;

        //@ApiProperty({description: 'Review Stars'})
        @Column()
        private int reviewStar;

        //@ApiProperty({description:'Review comments'})
        @Column()
        private String reviewComments;

        //@ApiProperty({description: 'Status of Review'})
        @Column()
        @Enumerated(EnumType.STRING)
        private String statusEnum;

        //@ApiProperty({description: 'Programs review'})
        @Column()
        private String programId;

        //@ApiProperty({description: 'Set to true if review has been modified'})
        private boolean modified;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public int getReviewStar() {
        return reviewStar;
    }

    public void setReviewStar(int reviewStar) {
        this.reviewStar = reviewStar;
    }

    public String getReviewComments() {
        return reviewComments;
    }

    public void setReviewComments(String reviewComments) {
        this.reviewComments = reviewComments;
    }

    public String getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(String statusEnum) {
        this.statusEnum = statusEnum;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public boolean isModified() {
        return modified;
    }

    public void setModified(boolean modified) {
        this.modified = modified;
    }

    public CourseReview() {
    }

    public CourseReview(String id, String reviewer, Date reviewDate, Date modifiedDate, int reviewStar, String reviewComments, String statusEnum, String programId, boolean modified) {
        this.id = id;
        this.reviewer = reviewer;
        this.reviewDate = reviewDate;
        this.modifiedDate = modifiedDate;
        this.reviewStar = reviewStar;
        this.reviewComments = reviewComments;
        this.statusEnum = statusEnum;
        this.programId = programId;
        this.modified = modified;
    }
}
