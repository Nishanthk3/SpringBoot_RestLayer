package com.nishanth.springboot;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nishanth.springboot.Athlete;
import com.nishanth.springboot.SportsKnown;
import com.nishanth.springboot.Ack;
import com.nishanth.springboot.SampleObject;

@RestController
public class Controller {

    @RequestMapping("/")
    public String initialPage() {
        return "Welcome To Spring Boot";
    }
    
    @RequestMapping( value = "/getxmlObject", produces = {"application/xml"})
    public SampleObject getXMLObject()
    {
		SampleObject sampleObject = new SampleObject();
		sampleObject.setId("1");
		sampleObject.setName("XML");
		return sampleObject;
    }
	
	@RequestMapping( value = "/getjsonObject", produces = {"application/json"})
    public SampleObject getJSONObject()
    {
		SampleObject sampleObject = new SampleObject();
		sampleObject.setId("1");
		sampleObject.setName("JOSN");
		return sampleObject;
    }
	
	@RequestMapping( value = "/plain", method = RequestMethod.POST)
    public Ack getPlainObject( @RequestBody String str, HttpServletRequest httpReq,
    		HttpServletResponse httpResp)
    {
		Ack ack = new Ack();
		ack.setUniqueId("123789");
		ack.setType("plain");
		return ack;
    }
	
	@RequestMapping( value = "/xmlRequest", consumes = {"application/xml"}, method = RequestMethod.POST)
    public Ack getXmlObject( @RequestBody SampleObject sample, HttpServletRequest httpReq,
    		HttpServletResponse httpResp)
    {
		Ack ack = new Ack();
		ack.setUniqueId(sample.getId());
		ack.setType(sample.getName());
		return ack;
    }
	
	@RequestMapping( value = "/jsonRequest", consumes = "application/json", method = RequestMethod.POST)
    public Ack getJsonObject( @RequestBody SampleObject sample, HttpServletRequest httpReq,
    		HttpServletResponse httpResp)
    {
		Ack ack = new Ack();
		ack.setUniqueId(sample.getId());
		ack.setType(sample.getName());
		return ack;
    }
	
	@RequestMapping( value = "/xmlRequestProduceJson", consumes = "application/xml",produces = "application/json", method = RequestMethod.POST)
    public Ack submitXmlRequestProduceJson( @RequestBody SampleObject sampleObject, HttpServletRequest httpReq,
    		HttpServletResponse httpResp)
    {
		Ack ack = new Ack();
		ack.setUniqueId(sampleObject.getId());
		ack.setType(sampleObject.getName());
		return ack;
    }
	
	@RequestMapping( value = "/jsonRequestProduceJson", consumes = "application/json",produces = "application/json", method = RequestMethod.POST)
    public Ack submitJsonRequestProduceJson( @RequestBody SampleObject sampleObject, HttpServletRequest httpReq,
    		HttpServletResponse httpResp)
    {
		Ack ack = new Ack();
		ack.setUniqueId(sampleObject.getId());
		ack.setType(sampleObject.getName());
		return ack;
    }
	
	
	@RequestMapping( value = "/xmlListRequest", consumes = "application/xml", method = RequestMethod.POST)
    public Ack submitXmlListRequest( @RequestBody Athlete athlete, HttpServletRequest httpReq,
    		HttpServletResponse httpResp)
    {
		Ack ack = new Ack();
		System.out.println(athlete.getName());
		System.out.println(athlete.getAddress());
		System.out.println(athlete.getAge());
		List<SportsKnown> lists = athlete.getSports();
		for(SportsKnown list : lists)
		{
			System.out.println(list.getSport());
			System.out.println(list.getHandedness());
		}
		return ack;
    }
	
	@RequestMapping( value = "/jsonListRequest", consumes = "application/json", method = RequestMethod.POST)
    public Ack submitJsonListRequest( @RequestBody Athlete athlete, HttpServletRequest httpReq,
    		HttpServletResponse httpResp)
    {
		Ack ack = new Ack();
		System.out.println(athlete.getName());
		System.out.println(athlete.getAddress());
		System.out.println(athlete.getAge());
		List<SportsKnown> lists = athlete.getSports();
		for(SportsKnown list : lists)
		{
			System.out.println(list.getSport());
			System.out.println(list.getHandedness());
		}
		return ack;
    }
}