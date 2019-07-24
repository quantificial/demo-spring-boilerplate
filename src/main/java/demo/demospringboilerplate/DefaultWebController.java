package demo.demospringboilerplate;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class DefaultWebController {
	
    private String appMode;

    @Autowired
    public DefaultWebController(Environment environment){
        appMode = environment.getProperty("app-mode");
    }
    
    @RequestMapping("/listHeaders")
    public ResponseEntity<String> listAllHeaders(@RequestHeader Map<String, String> headers) {
        headers.forEach((key, value) -> {
        	
            log.info(String.format("Header '%s' = %s", key, value));
           
        });
     
        return new ResponseEntity<String>(String.format("Listed %d headers", headers.size()), HttpStatus.OK);
    }

    @RequestMapping("/")
    public String index(Model model){
    	
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Test");
        model.addAttribute("mode", appMode);

        return "index";
    }
}
