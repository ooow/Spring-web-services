package com.nc.spring;

import com.nc.DAO.PositionDao;
import com.nc.DAO.RoleDao;
import com.nc.DAO.UserDao;
import com.nc.DAO.WorkTableDAO;
import com.nc.exception.*;
import com.nc.model.Position;
import com.nc.model.Role;
import com.nc.model.User;
import com.nc.model.WorkTable;
import com.nc.view.models.ViewUserProfile;
import com.nc.view.models.ViewUserReport;
import org.joda.time.DateTime;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Гога on 14.04.2016.
 */
@Controller
public class RequestController {

    @RequestMapping(value = "/singup", method = RequestMethod.POST)
    public ModelAndView singup(HttpServletRequest request) {
        String requestStatus = "User Registered";
        try {
            String[] ifBlank = {request.getParameter("username").toUpperCase(),
                    request.getParameter("password").toUpperCase(),
                    request.getParameter("name").toUpperCase(),
                    request.getParameter("surname").toUpperCase(),
                    request.getParameter("role").toUpperCase(),
                    request.getParameter("position").toUpperCase()};
            for (int i = 0; i < ifBlank.length; i++) {
                if (ifBlank[i] == null) {
                    requestStatus = "Fill blank fields";
                    return new ModelAndView("adminhome", "singUpInfo", requestStatus);
                }
            }
            Role role = new Role();
            if ("ADMIN".equals(ifBlank[4]))
                role = new RoleDao().getRoleByTitle("ROLE_" + ifBlank[4]);
            else
                role = new RoleDao().getRoleByTitle(ifBlank[4].toLowerCase());
            Position position = new PositionDao().getPositionByTitle(ifBlank[5].toLowerCase());
            User user = new User(ifBlank[0], ifBlank[1], ifBlank[2], ifBlank[3], role, position);
            new UserDao().registUser(user);
        } catch (UsernameIsAlreadyTakenException | RoleDoesNotExistException | PositionDoesNotExistException e) {
            requestStatus = e.getMessage();
        }
        return new ModelAndView("adminhome", "singUpInfo", requestStatus);
    }

    @RequestMapping(value = "/createrole", method = RequestMethod.POST)
    public ModelAndView createNewRole(HttpServletRequest request) {
        String requestStatus = "New Role Created";
        String newRole = request.getParameter("role");
        if (newRole == null)
            requestStatus = "Fill blank fields";
        else {
            Role role = new Role(newRole);
            try {
                new RoleDao().createNewRole(role);
            } catch (AlreadyCreatedException e) {
                requestStatus = e.getMessage();
            }
        }
        return new ModelAndView("adminhome", "createRoleInfo", requestStatus);
    }

    @RequestMapping(value = "/createposition", method = RequestMethod.POST)
    public ModelAndView createNewPosition(HttpServletRequest request) {
        String requestStatus = "New Position Created";
        String newPosition = request.getParameter("position");
        if (newPosition == null)
            requestStatus = "Fill blank fields";
        else {
            try {
                Position position = new Position(request.getParameter("title"), request.getParameter("salaryt"),
                        new BigDecimal(request.getParameter("salary")));
                new PositionDao().createNewPosition(position);
            } catch (AlreadyCreatedException | SalaryTypeException e) {
                requestStatus = e.getMessage();
            } catch (NumberFormatException e) {
                requestStatus = "Enter a number in the [salary] field";
            }
        }
        return new ModelAndView("adminhome", "createPositionInfo", requestStatus);
    }

    @RequestMapping(value = "/")
    public ModelAndView userSingIn() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = new UserDao().findByUserName(username);
        return new ViewUserProfile().getProfileInfo(user);
    }

    @RequestMapping(value = "/home")
    public ModelAndView userSingInH() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = new UserDao().findByUserName(username);
        return new ViewUserProfile().getProfileInfo(user);
    }

    @RequestMapping(value = "/workstart", method = RequestMethod.POST)
    public ModelAndView workStart() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        DateTime current = DateTime.now();
        WorkTable wt = new WorkTable();
        User user = new UserDao().findByUserName(username);
        user.setStatus("start");
        new UserDao().updateUser(user);
        wt.setUser(user);
        wt.setStartTime(current);
        new WorkTableDAO().createNewWT(wt);
        return new ViewUserProfile().getProfileInfo(user);
    }

    @RequestMapping(value = "/workstop", method = RequestMethod.POST)
    public ModelAndView workStop() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        DateTime current = DateTime.now();
        User user = new UserDao().findByUserName(username);
        user.setStatus("stop");
        new UserDao().updateUser(user);
        WorkTable wt = new WorkTableDAO().getWTbyUser(user);
        wt.setEndTime(current);
        new WorkTableDAO().updateEndTime(wt);
        return new ViewUserProfile().getProfileInfo(user);
    }

    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public ModelAndView getReport() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return new ViewUserReport().getReport(username);
    }

    @RequestMapping("/403")
    public String accessDenied() {
        return "errors/403";
    }
}
