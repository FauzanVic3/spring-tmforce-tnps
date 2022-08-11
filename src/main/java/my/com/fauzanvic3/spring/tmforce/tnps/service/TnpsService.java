/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.com.fauzanvic3.spring.tmforce.tnps.service;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import my.com.fauzanvic3.spring.tmforce.tnps.json.DacVocTnpsDetail;
import my.com.fauzanvic3.spring.tmforce.tnps.xml.Survey;
import my.com.fauzanvic3.spring.tmforce.tnps.xml.SurveyRequest;
import my.com.fauzanvic3.spring.tmforce.tnps.xml.SurveyRequestElements;
import my.com.tmrnd.tmforce.common.APIConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Fauzan
 */
@RequestMapping("")
@RestController
@Service
@Path("/receiver/tnps")
public class TnpsService extends HttpServlet{
    
    private final Logger log = LoggerFactory.getLogger(getClass().getName());
    private final String OK = "OK";
    private final String NOT_OK = "NOT OK";
    private final String ASSURANCE = "evOutVOCAssuranceTMF";
    private final String FULFILLMENT = "evOutVOCFulfillmentTMF";
    private JAXBContext context;

    public TnpsService() {
    }
    
    
//    @ApiOperation(value = "TNPS Receiver")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Success", response = String.class),
//            @ApiResponse(code = 400, message = "Error 400, 404, 500", response = ExceptionResponse.class)
//    })
//    @PostMapping("receiver/tnps")
//    @Path("receiver/tnps")
    @POST
    @Consumes("text/xml")
    @Produces("text/xml")
    public String receiveTnpsService(String strRequest){
        
        log.info("strRequest"+strRequest);
        
        SurveyRequest request = convertMapper(strRequest);
                
        log.info("XML request : "+request);
        
        if(request == null){
            returnResponse(request, NOT_OK);
        }
        
        try{
            String mid = request.getSurvey().getSurveyRequestElements().getMid();
            String businessEventMain = request.getSurvey().getSurveyRequestElements().getBusinessEventMain();
            String mobileNum = request.getSurvey().getSurveyRequestElements().getMobileNum();
            String rating = request.getSurvey().getSurveyRequestElements().getRating();
            String ratingReason = request.getSurvey().getSurveyRequestElements().getRatingReason();
            String comment = request.getSurvey().getSurveyRequestElements().getComment();
            String custResFeedback = request.getSurvey().getSurveyRequestElements().getCustResFeedback();
            String careScore = request.getSurvey().getSurveyRequestElements().getCareScore();
        
            if(!businessEventMain.isEmpty()){
                if(businessEventMain.equals(ASSURANCE)){
                    DacVocTnpsDetail jsonRequest = new DacVocTnpsDetail();
                    jsonRequest.setMid(mid);
                    jsonRequest.setComment(comment);
                    jsonRequest.setCustResFeedback(custResFeedback);
                    jsonRequest.setMobileNum(mobileNum);
                    jsonRequest.setRating(rating);
                    jsonRequest.setRatingReason(ratingReason);
                    jsonRequest.setCareScore(careScore);
                    
                    String uriDacReceiveTnps = getApiEndPoint(APIConstant.API.MODEL.DAC.CODE);
                    String pathReceiveTnps = "/api/dac/voc/tnps/detail";
                    
                    String endpointReceiveTnps = uriDacReceiveTnps + pathReceiveTnps;
                    
                    //test
//                    endpointReceiveTnps = "http://localhost:80/api/dac/voc/tnps/detail";
                    
                    log.info("Endpoint dac tnps : "+endpointReceiveTnps);
                    log.info("Request : \n"+jsonRequest);
                    String jsonResponse = "";
                    
                    Client client = ClientBuilder.newClient();
                    WebTarget webTarget = client.target(endpointReceiveTnps);
                    Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
                    Response responseSendTnps = invocationBuilder.header("TMF-Header", mid).post(Entity.json(jsonRequest));

                    log.info("Response : \n"+responseSendTnps);
                    jsonResponse = responseSendTnps.readEntity(String.class);
                    log.info("jsonResponse : \n"+jsonResponse);
                    
                    if(responseSendTnps.getStatus() == 200){
                        log.info("Success send tnps to TMForce");
                        return returnResponse(request, OK);
                    }else{
                        log.info("Failed send tnps to TMForce\n");
                        return returnResponse(request, NOT_OK);
                    }
                    
                    
                }else if(businessEventMain.equals(FULFILLMENT)){
                    
                    //To be updated when Fulfillment is confirmed
                    DacVocTnpsDetail jsonRequest = new DacVocTnpsDetail();
                    jsonRequest.setMid(mid);
                    jsonRequest.setComment(comment);
                    jsonRequest.setCustResFeedback(custResFeedback);
                    jsonRequest.setMobileNum(mobileNum);
                    jsonRequest.setRating(rating);
                    jsonRequest.setRatingReason(ratingReason);
                    jsonRequest.setCareScore(careScore);

                    String uriDacReceiveTnps = getApiEndPoint(APIConstant.API.MODEL.FL_DAC.CODE);
                    String pathReceiveTnps = "/api/fl-dac/voc/tnps/detail";
                    
                    String endpointReceiveTnps = uriDacReceiveTnps + pathReceiveTnps;
                    log.info("Endpoint dac tnps : "+endpointReceiveTnps);
                    log.info("Request : \n"+jsonRequest);
                    String jsonResponse = "";
                    
                    Client client = ClientBuilder.newClient();
                    WebTarget webTarget = client.target(endpointReceiveTnps);
                    Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
                    Response responseSendTnps = invocationBuilder.header("TMF-Header", mid).post(Entity.json(jsonRequest));

                    log.info("Response : \n"+responseSendTnps);
                    jsonResponse = responseSendTnps.readEntity(String.class);
                    log.info("jsonResponse : \n"+jsonResponse);
                    
                    if(responseSendTnps.getStatus() == 200){
                        log.info("Success send tnps to TMForce");
                        return returnResponse(request, OK);
                    }else{
                        log.info("Failed send tnps to TMForce\n");
                        return returnResponse(request, NOT_OK);
                    }
                    
                }else{
                    log.warn("event name is neither Assurance or Fulfillment : "+businessEventMain);
                }
            }
            
        }catch(Exception e){
            log.error("Error in TnpsService : \n", new Exception(e));
        }
        
//        return returnResponse(request, OK);
        return returnResponse(request, OK);
    }
    
    /**
     * 
     * <?xml version="1.0" ?>
        <SurveyResponse>
                <MID>593924518</MID>
                <status>OK</status>
        </SurveyResponse>

     * @param request
     * @param status
     * @return 
     */
    private String returnResponse(SurveyRequest request, String status){

        String response = "";
        
        response +="<?xml version=\"1.0\" ?>";
        response +="<SurveyResponse>";
        response +="<MID>";
        response +=request.getSurvey().getSurveyRequestElements().getMid();
        response +="</MID>";
        response +="<status>";
        response +=status;
        response +="</status>";
        response +="</SurveyResponse>";
                
        
        return response;
    }
    
    
    /**
     * <MID>593924518</MID>
                    <BusinessEventMain>evOutVOCFulfillmentTMF</BusinessEventMain>
                    <MobileNum>0139999999</MobileNum>
                    <Rating>10</Rating>
                    <RatingReason>Others</RatingReason>
                    <Comment>UniFi,Streamyx,Del</Comment>
           <CustResFeedback>Yes</CustResFeedback>
     * @param strRequest
     * @return 
     */
    private SurveyRequest convertMapper(String strRequest){
        SurveyRequest request = new SurveyRequest();
        Survey survey = new Survey();
        SurveyRequestElements elements = new SurveyRequestElements();
        
        String mid = "";
        String businessEventMain = "";
        String mobileNum = "";
        String rating = "";
        String ratingReason = "";
        String comment = "";
        String custResFeedback = "";
        String careScore = "";
        

        mid = strRequest.contains("<MID>") ? strRequest.substring(strRequest.indexOf("<MID>")+5, strRequest.indexOf("</MID>")) : "";
        businessEventMain = strRequest.contains("<BusinessEventMain>") ? strRequest.substring(strRequest.indexOf("<BusinessEventMain>")+19, strRequest.indexOf("</BusinessEventMain>")) : "";
        mobileNum = strRequest.contains("<MobileNum>") ? strRequest.substring(strRequest.indexOf("<MobileNum>")+11, strRequest.indexOf("</MobileNum>")) : "";
        rating = strRequest.contains("<Rating>") ? strRequest.substring(strRequest.indexOf("<Rating>")+8, strRequest.indexOf("</Rating>")) : "";        
        ratingReason = strRequest.contains("<RatingReason>") ? strRequest.substring(strRequest.indexOf("<RatingReason>")+14, strRequest.indexOf("</RatingReason>")) : "";        
        comment = strRequest.contains("<Comment>") ? strRequest.substring(strRequest.indexOf("<Comment>")+9, strRequest.indexOf("</Comment>")) : "";
        custResFeedback = strRequest.contains("<CustResFeedback>") ? strRequest.substring(strRequest.indexOf("<CustResFeedback>")+17, strRequest.indexOf("</CustResFeedback>")) : "";
        careScore = strRequest.contains("<CareScore>") ? strRequest.substring(strRequest.indexOf("<CareScore>") + 11, strRequest.indexOf("</CareScore>")) : "";
        
        elements.setMid(mid);
        elements.setBusinessEventMain(businessEventMain);
        elements.setMobileNum(mobileNum);
        elements.setRating(rating);
        elements.setRatingReason(ratingReason);
        elements.setComment(comment);
        elements.setCustResFeedback(custResFeedback);
        elements.setCareScore(careScore);
        
        survey.setSurveyRequestElements(elements);
        request.setSurvey(survey);
        
        return request;
    }
    
    public String getApiEndPoint(String code) {
        String endpoint = System.getenv("TMF_API_" + code + "_ENDPOINT");

        if (endpoint == null) {
            log.error(code + " endpoint not found");
        }

        return endpoint;
    }
}
