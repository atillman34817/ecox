
package edu.spcollege.ecox.signin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author atillman
 */

@Controller
public class SignInController {

	@RequestMapping(value = "signin")
	public String signin() {
        return "signin/signin";
    }
}
