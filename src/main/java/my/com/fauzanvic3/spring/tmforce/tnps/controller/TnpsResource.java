/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.com.fauzanvic3.spring.tmforce.tnps.controller;

import my.com.fauzanvic3.spring.tmforce.tnps.TnpsController;
import my.com.fauzanvic3.spring.tmforce.tnps.service.TnpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Fauzan
 */
@RestController
public class TnpsResource extends TnpsController{
    
    @Autowired
    TnpsService service;
    
    
}
