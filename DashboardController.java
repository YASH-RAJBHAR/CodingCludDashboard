package com.example.demo.cotroller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DashboardController {

	@GetMapping("/login")
    public String showLoginPage() {
        return "login";  // points to login.html
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {
        if ("admin".equals(username) && "1234".equals(password)) {
            // ✅ Successful login → go to dashboard
            model.addAttribute("user", username);
            return "dashboard";
        } else {
            // ❌ Invalid credentials → stay on login page
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
       
        return "dashboard";
    }
}