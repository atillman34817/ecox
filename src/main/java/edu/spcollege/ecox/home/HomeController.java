
package edu.spcollege.ecox.home;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author atillman
 */

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Principal principal) {
		return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
	}
        
        @RequestMapping(value = "/homeSignedIn")
         public String dashboard() {
        return "home/homeSignedIn";
    
        }
}
