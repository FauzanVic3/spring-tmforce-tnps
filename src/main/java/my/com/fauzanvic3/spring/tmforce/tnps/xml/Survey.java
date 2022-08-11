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
 * 
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
    <SurveyRequest>
            <Survey>
                    <MID>593924518</MID>
                    <BusinessEventMain>evOutVOCFulfilmentTMF</BusinessEventMain>
                    <MobileNum>0139999999</MobileNum>
                    <Rating>10</Rating>
                    <RatingReason>Others</RatingReason>
                    <Comment>UniFi,Streamyx,Del</Comment>
           <CustResFeedback>Yes</CustResFeedback>
            </Survey>
    </SurveyRequest>
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "survey", propOrder = {"surveyRequestElements"})
public class Survey {

    @XmlElement(name = "Survey")
    protected SurveyRequestElements surveyRequestElements;

    public SurveyRequestElements getSurveyRequestElements() {
        return surveyRequestElements;
    }

    public void setSurveyRequestElements(SurveyRequestElements surveyRequestElements) {
        this.surveyRequestElements = surveyRequestElements;
    }    
}
