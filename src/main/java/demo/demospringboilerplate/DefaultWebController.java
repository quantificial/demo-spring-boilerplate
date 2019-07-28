package demo.demospringboilerplate;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class DefaultWebController {
	
    private String appMode;

    /**
     * to show how to get the environment variable
     * @param environment
     */
    @Autowired
    public DefaultWebController(Environment environment){
        appMode = environment.getProperty("app-mode");
    }
    
    /**
     * list out all the header for the incoming request
     * @param headers
     * @return
     */
    @RequestMapping("/listHeaders")
    public ResponseEntity<String> listAllHeaders(@RequestHeader Map<String, String> headers) {
        headers.forEach((key, value) -> {
        	
            log.info(String.format("Header '%s' = %s", key, value));
           
        });
     
        return new ResponseEntity<String>(String.format("Listed %d headers", headers.size()), HttpStatus.OK);
    }
    
    /**
     * response the request with custom header
     * @return
     */
    @GetMapping("/customHeader")
    ResponseEntity<String> customHeader() {
        return ResponseEntity.ok()
            .header("Custom-Header", "foo")
            .body("Custom header set");
    }

    /**
     * default landing page
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String index(Model model){
    	
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Test");
        model.addAttribute("mode", appMode);

        return "index";
    }
}
