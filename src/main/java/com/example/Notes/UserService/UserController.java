package com.example.Notes.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/u", method = RequestMethod.GET )
public class UserController {
    @Autowired
    UserService userService;

    private final HttpServletRequest request;
    @Autowired
    public UserController(HttpServletRequest request)
    {
        this.request=request;
    }

    @GetMapping("/signup")
    public String directSignUpPage(Model model)
    {
        model.addAttribute("user", new User());
        return "user/usersignup";
    }
    @PostMapping("/adduser")
    public String addNewUser(@ModelAttribute User user, @RequestParam String role, @RequestParam String classSelection, @RequestParam String key, Model model)
    {
        java.time.LocalDate date=java.time.LocalDate.now();
        user.role=role;
        user.date=date;
        System.out.println(role);
        if ("teacher".equals(role) || "admin".equals(role))
        { 
            classSelection="Not available";
        }
        user.studentClass=classSelection;
        if (role.equals("admin") && !key.equals("saikat98") )
        {
            model.addAttribute("errorMessage", "Invalid Key");
            return "user/usersignup";
        }
        User user1=userService.getUserByUsername(user.username);
        if(user1.username.equals(user.username))
        {
            model.addAttribute("errorMessage", "User exists ! Try another username ");
            return "user/usersignup";
        }
        userService.saveUser(user);
        return "redirect:/u/signin";
    }
    @GetMapping("/signin")
    public String directSignInPage(Model model)
    {
        model.addAttribute("user", new User());
        return "user/usersignin";
    }
    @PostMapping("/postsignin")
    public String signinFunction(@ModelAttribute User user, Model model)
    {
        User user1=userService.getUserByUsername(user.username);
        if (user1==null)
        {
            model.addAttribute("errorMessage", "The User doesn't exist");
            return "user/usersignin";
        }
        else if(!user1.getPassword().equals(user.getPassword()))
        {
            model.addAttribute("errorMessage", "Incorrect Password");
            return "user/usersignin";
        }
        else
        {
            // Creates a new session or retrives the current session associated with that request
            HttpSession session = request.getSession(); //request is defined above

            //This allows other part of the application that has access to this session to have access to the data stored in the currentUser object.
            session.setAttribute("currentUser", user);

            // Redirect to the notes page

            return "redirect:/viewall";
        }
        
    }
}
