package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Гога on 12.04.2016.
 */

/*@Controller*/
public class Restrequests {
    /*@RequestMapping(value = "/dropp", method = RequestMethod.GET)
    public String sayHello(org.springframework.ui.Model model) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(model.toString());
        return "retro";
    }

    @RequestMapping(value = "/dropp", method = RequestMethod.POST)
    public String say(org.springframework.ui.Model model) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(model.toString());
        return "retro";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }*/
}
