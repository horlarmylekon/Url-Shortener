/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intellisensedev.urlshortener_engine.web;

import com.intellisensedev.urlshortener_engine.urlapp.repositories.AdminRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

/**
 * @author intellisense
 *
 * The login controller provide access to authorize
 * users to login to their dashboard
 */

@SessionAttributes({"currentUser"})
@Controller
public class LoginController {


    @Autowired
    private AdminRepository adminRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/user/login")
    public String showLoginPage(@RequestParam(value = "failed", required = false) boolean failed, Model model) {

        if (failed) {
            //if user credential is invalid return an invalid credential message
            // to the view.
            model.addAttribute("failed", true);
        }
        return "user/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(SessionStatus session) {
        SecurityContextHolder.getContext().setAuthentication(null);
        session.setComplete();
        return "redirect:/welcome";
    }

//    @RequestMapping(value = "/postLogin", method = RequestMethod.POST)
//    public String postLogin(Model models, HttpSession session) {
//        logger.info("postLogin()");
//        // read principal out of security context and set it to session
//        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
//        validatePrinciple(authentication.getPrincipal());
//
//        Admin loggedInUser = ((CustomUserDetails) authentication.getPrincipal()).getUserDetails();
//        models.addAttribute("currentUser", loggedInUser.getUsername());
//        session.setAttribute("userId", loggedInUser.getUserID());
//
//        return "redirect:/dashboard/profile";
//    }
//
//    private void validatePrinciple(Object principal) {
//        if (!(principal instanceof CustomUserDetails)) {
//            throw new  IllegalArgumentException("Principal can not be null!");
//        }
//    }

}
