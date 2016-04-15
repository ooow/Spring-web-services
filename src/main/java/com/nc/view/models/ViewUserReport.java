package com.nc.view.models;

import com.nc.DAO.UserDao;
import com.nc.DAO.WorkTableDAO;
import com.nc.model.User;
import com.nc.model.WorkTable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Гога on 15.04.2016.
 */
public class ViewUserReport {
    public ModelAndView getReport(String username) {
        ModelAndView mv = new ModelAndView("/home");
        User user = new UserDao().findByUserName(username);
        List<WorkTable> wt = new WorkTableDAO().getReportByUser(user);
        mv.addObject("worktables", wt);
        return mv;
    }
}
