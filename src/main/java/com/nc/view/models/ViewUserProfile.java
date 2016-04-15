package com.nc.view.models;

import com.nc.DAO.UserDao;
import com.nc.model.User;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Гога on 14.04.2016.
 */
public class ViewUserProfile {
    public ModelAndView getProfileInfo(String username, String status) {
        ModelAndView mv = new ModelAndView("/home");
        User user = new UserDao().findByUserName(username);
        mv.addObject("username", username);
        mv.addObject("name", user.getName());
        mv.addObject("surname", user.getSurname());
        mv.addObject("role", user.getRole().getTitle());
        mv.addObject("position", user.getPost().getTitle());
        mv.addObject("salaryt", user.getPost().getSalaryType());
        mv.addObject("salary", user.getPost().getSalary());
        if (!status.equals(""))
            mv.addObject("status", status);
        return mv;
    }
}
