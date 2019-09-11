package com.foton.m2m.demo.action;

import javax.annotation.Resource;

import com.foton.m2m.drools.model.Message;
import com.foton.m2m.drools.service.TestDroolsService;
import com.foton.m2m.framework.core.util.JacksonUtil;
import com.foton.m2m.framework.core.web.action.BaseAction;

public class DemoDroolsAction extends BaseAction {
	
	private static final long serialVersionUID = 1L;
	
	private JacksonUtil jacksonUtil = JacksonUtil.buildNonNullBinder();
	
	@Resource
	private TestDroolsService testDroolsService;
	
	private Message message;
	
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public String run(){
		Message message = new Message();
		message.setMessage("Hello World");
		message.setStatus(Message.HELLO);
		Message msg = testDroolsService.test(message);
		setJsonString("{success:true,data:"+jacksonUtil.toJson(msg)+"}");
		return "success";
	}
	
}
