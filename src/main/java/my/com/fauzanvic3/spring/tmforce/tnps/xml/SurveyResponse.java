/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.com.fauzanvic3.spring.tmforce.tnps.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Fauzan
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "SurveyResponse"
})
@XmlRootElement(name = "surveyResponse")
public class SurveyResponse {
    
    @XmlElement(name = "SurveyResponse")
    protected SurveyResponseElements surveyResponseElement; 

    public SurveyResponseElements getSurveyResponseElement() {
        return surveyResponseElement;
    }

    public void setSurveyResponseElement(SurveyResponseElements surveyResponseElement) {
        this.surveyResponseElement = surveyResponseElement;
    }
    
    
}
