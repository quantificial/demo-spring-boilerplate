package demo.demospringboilerplate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@RequestMapping("/api")
public class DemoRestEndPoint {
	
	
	@Data
	public class Message {
		private long id;
		private String message;
	}
	
	
	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public ResponseEntity<Message> genMessage() {
		Message message = new Message();
		message.setId(1);
		message.setMessage("hello");
		
		return new ResponseEntity<Message>(message, HttpStatus.OK);
	}

}
