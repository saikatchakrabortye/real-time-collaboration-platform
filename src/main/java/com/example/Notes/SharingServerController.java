package com.example.Notes;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class SharingServerController {
	
   /*  @MessageMapping("/receiver")
	@SendTo("/topic/all") //send to subscribers of /topic/ten
	public Greeting greeting(HelloMessage message) throws Exception {
		Thread.sleep(1000); // simulated delay
		String str="Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!";
		String str1="Saikat";
		return new Greeting(str, str1);
	}*/
	@MessageMapping("/receiver")
	@SendTo("/topic/all") //send to subscribers of /topic/ten
	public ReceivingPacket greeting(SendingPacket message) throws Exception {
		Thread.sleep(1000); // simulated delay
		
		String username=HtmlUtils.htmlEscape(message.getSenderUsername());
		String groupName=HtmlUtils.htmlEscape(message.getGroupToShare());
		String title=HtmlUtils.htmlEscape(message.getTitle());
		String description=HtmlUtils.htmlEscape(message.getDescription());

		return new ReceivingPacket(username, groupName, title, description);
	}
    
}
