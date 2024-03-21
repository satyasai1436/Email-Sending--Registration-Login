package in.satya.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.satya.Entity.Person2;
import in.satya.Service.person2Service;

@Controller
public class person2Controller {
    @Autowired
    private person2Service service;

    //To Load The Form
    @GetMapping("/")
    public String loadForm(Model model) {
        model.addAttribute("set", new Person2());
        return "index";
    }

    //To Set The Data for Registration
    @PostMapping("/form")
    public String set(@ModelAttribute("set") Person2 p, Model model) {
        Person2 data = service.setData(p);
        if (data.getpId() != null)
            model.addAttribute("msg", "Success");
        else
            model.addAttribute("msg", "Failed");
        return "index";
    }

    //To Check the Credentials...
    @GetMapping("/lform")
    public String loadForm1(Model model) {
        model.addAttribute("get", new Person2());
        return "login";
    }

    @PostMapping("/login")
    public String show(@ModelAttribute("get") Person2 p, Model model) {
        
    	boolean validateUser = service.validateUser(p.getEmail(), p.getPassword());
    	if(validateUser) {
    		return "redirect:/dash";
    	}else {
    		model.addAttribute("msg", "Invalid login credemntials");
    		return "login";
    	}
    }
    
    @GetMapping("/dash")
    public String all(Model model) {
    	return "dashBoard";
    }

}
