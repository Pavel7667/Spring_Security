package com.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * "@Controller" set that this will work with User request URL
 */
@Controller
public class MyController {

    /**
     * The infoForAllEmployee for Get request with URL "/", send User View
     *
     * @return link to JSP.file = View
     */
    @GetMapping("/")
    public String infoForAllEmployee() {
        return "view_for_all_employees";
    }

    /**
     * The getInfoOnlyForHR for Get request with URL "/hr_info", send User View
     *
     * @return link to JSP.file = View
     */
    @GetMapping("/hr_info")
    public String getInfoOnlyForHR() {
        return "view_for_hr";
    }

    /**
     * The getInfoOnlyForManagers for Get request with URL "/manager_info",
     * send User View
     *
     * @return link to JSP.file = View
     */
    @GetMapping("/manager_info")
    public String getInfoOnlyForManagers() {
        return "view_for_manager";
    }

}
