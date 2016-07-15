package edu.spcollege.ecox.home;

import edu.spcollege.ecox.image.Image;
import edu.spcollege.ecox.image.ImageService;
import edu.spcollege.ecox.sensor.TemperatureReading;
import edu.spcollege.ecox.sensor.TemperatureReadingService;
import edu.spcollege.ecox.shared.Location;
import java.io.FileNotFoundException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author atillman
 */
@Controller
public class HomeController {

    @Autowired
    ImageService imageService;
    
    @Autowired
    TemperatureReadingService temperatureReadingService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Principal principal) {
        return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
    }

    @RequestMapping(value = "/homeSignedIn")
    public String dashboard(Model model) {
        List<String> imageStrings = new ArrayList<>();
        try {
            List<Image> images = imageService.findByLocation(new Location(0, 0));
            for (Image image : images) {
                imageStrings.add(Base64.encodeBase64String(image.getBytes()));
            }
            model.addAttribute("imageStrings", imageStrings);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        
        List<TemperatureReading> temperatureReadings = new ArrayList<>();     
        for (int i=0; i<20; i++) {
            try {
                temperatureReadings.add(temperatureReadingService.findById((long)i));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
        model.addAttribute("temperatureReadings", temperatureReadings);

        return "home/homeSignedIn";

    }
}
