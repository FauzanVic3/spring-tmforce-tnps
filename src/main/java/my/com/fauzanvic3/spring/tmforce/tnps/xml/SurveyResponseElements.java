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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "surveyResponseElements", propOrder = {
    "mid",
    "status"
})
public class SurveyResponseElements {
    
    @XmlElement(name = "MID")
    protected String mid;
    @XmlElement(name = "status")
    protected String status;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
