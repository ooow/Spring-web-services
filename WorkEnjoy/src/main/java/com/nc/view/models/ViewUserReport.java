package com.nc.view.models;

import com.nc.DAO.UserDao;
import com.nc.DAO.WorkTableDAO;
import com.nc.exception.UserNotFoundException;
import com.nc.model.User;
import com.nc.model.WorkTable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Гога on 15.04.2016.
 */
public class ViewUserReport {
    public ModelAndView getReport(String username) {
        User user = new UserDao().findByUserName(username);
        ModelAndView mv = new ViewUserProfile().getProfileInfo(user);
        List<WorkTable> wt = new WorkTableDAO().getReportByUser(user);
        mv.addObject("status", user.getStatus());
        mv.addObject("worktables", wt);
        return mv;
    }

    public ModelAndView getReportByUserName(String username) throws UserNotFoundException {
        User user = new UserDao().findByUserName(username);
        if (user == null)
            throw new UserNotFoundException("User " + username + " not found");
        ModelAndView mv = new ModelAndView("/adminhome");
        List<WorkTable> wt = new WorkTableDAO().getReportByUser(user);
        mv.addObject("worktables", wt);
        return mv;
    }
}
