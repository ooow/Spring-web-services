package com.nc.view.models;

import com.nc.DAO.UserDao;
import com.nc.model.User;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Гога on 14.04.2016.
 */
public class ViewUserProfile {
    public ModelAndView getProfileInfo(User user) {
        ModelAndView mv = new ModelAndView("/home");
        mv.addObject("username", user.getLogin());
        mv.addObject("name", user.getName());
        mv.addObject("surname", user.getSurname());
        mv.addObject("role", user.getRole().getTitle());
        mv.addObject("position", user.getPost().getTitle());
        mv.addObject("salaryt", user.getPost().getSalaryType());
        mv.addObject("salary", user.getPost().getSalary());
        mv.addObject("status", user.getStatus());
        return mv;
    }

    public ModelAndView getUsers() {
        return new ModelAndView("adminhome", "users", new UserDao().getUsers());
    }
}
