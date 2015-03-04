package com.nishanth.springboot;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonRootName;

@XmlRootElement(name= "ack")
@JsonRootName(value = "ack")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ack", propOrder = {
		"uniqueId",
		"type"
})
public class Ack {

	protected String uniqueId;
	protected String type;
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}