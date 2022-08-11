/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.com.fauzanvic3.spring.tmforce.tnps.json;

import my.com.tmrnd.tmforce.common.api.json.TmfJSON;

/**
 *
 * @author Fauzan
 */
public class DacVocTnpsDetail extends TmfJSON {

    private String mid;
    private String mobileNum;
    private String rating;
    private String ratingReason;
    private String comment;
    private String custResFeedback;
    private String careScore;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
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

    public void setCareScore(String careScore) {
        this.careScore = careScore;
    }

    public String getCareScore() {
        return careScore;
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
