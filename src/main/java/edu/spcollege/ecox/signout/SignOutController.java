
package edu.spcollege.ecox.signout;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author DouglasJones
 */
@Controller
public class SignOutController {
    
    @RequestMapping(value = "signout")
    public String signout() {
        return "home/homeNotSignedIn";
    
    }
}        
