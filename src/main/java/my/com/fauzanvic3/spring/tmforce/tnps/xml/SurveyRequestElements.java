/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.com.fauzanvic3.spring.tmforce.tnps.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Fauzan
 */
/**
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
 * <SurveyRequest>
 * <Survey>
 * <MID>593924518</MID>
 * <BusinessEventMain>evOutVOCFulfilmentTMF</BusinessEventMain>
 * <MobileNum>0139999999</MobileNum>
 * <Rating>10</Rating>
 * <RatingReason>Others</RatingReason>
 * <Comment>UniFi,Streamyx,Del</Comment>
 * <CustResFeedback>Yes</CustResFeedback>
 * </Survey>
 * </SurveyRequest>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "surveyRequestElements", propOrder = {
    "mid",
    "businessEventMain",
    "mobileNum",
    "rating",
    "ratingReason",
    "careScore",
    "comment",
    "custResFeedback"
})
public class SurveyRequestElements {

    @XmlElement(name = "MID")
    protected String mid;
    @XmlElement(name = "BusinessEventMain")
    protected String businessEventMain;
    @XmlElement(name = "MobileNum")
    protected String mobileNum;
    @XmlElement(name = "Rating")
    protected String rating;
    @XmlElement(name = "RatingReason")
    protected String ratingReason;
    @XmlElement(name = "CareScore")
    protected String careScore;
    @XmlElement(name = "Comment")
    protected String comment;
    @XmlElement(name = "CustResFeedback")
    protected String custResFeedback;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getBusinessEventMain() {
        return businessEventMain;
    }

    public void setBusinessEventMain(String businessEventMain) {
        this.businessEventMain = businessEventMain;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRatingReason() {
        return ratingReason;
    }

    public void setRatingReason(String ratingReason) {
        this.ratingReason = ratingReason;
    }

    public String getCareScore() {
        return careScore;
    }

    public void setCareScore(String careScore) {
        this.careScore = careScore;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCustResFeedback() {
        return custResFeedback;
    }

    public void setCustResFeedback(String custResFeedback) {
        this.custResFeedback = custResFeedback;
    }

}
