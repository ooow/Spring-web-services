package com.nc.hello;

import com.nc.DAO.PositionDao;
import com.nc.DAO.RoleDao;
import com.nc.DAO.UserDao;
import com.nc.DAO.WorkTableDAO;
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


/**
 * Created by Гога on 14.04.2016.
 */
@Controller
public class RequestController {
    public String status = "stop";

    @RequestMapping(value = "/singup", method = RequestMethod.POST)
    public ModelAndView singup(HttpServletRequest request) {
        User user = new User(request.getParameter("username"),
                request.getParameter("password"),
                request.getParameter("name"),
                request.getParameter("surname"),
                new RoleDao().getRoleByTitle("ROLE_" + request.getParameter("role").toUpperCase()),
                new PositionDao().getPositionByTitle(request.getParameter("position").toLowerCase()));
        new UserDao().registUser(user);
        return new ModelAndView("adminhome", "singUpInfo", "User Registered");
    }

    @RequestMapping(value = "/createrole", method = RequestMethod.POST)
    public ModelAndView createNewRole(HttpServletRequest request) {
        Role role = new Role(request.getParameter("role"));
        new RoleDao().createNewRole(role);
        System.out.println(role.toString());
        return new ModelAndView("adminhome", "createRoleInfo", "New Role Created");
    }

    @RequestMapping(value = "/createposition", method = RequestMethod.POST)
    public ModelAndView createNewPosition(HttpServletRequest request) {
        Position position = new Position(request.getParameter("title"), request.getParameter("salaryt"),
                new BigDecimal(request.getParameter("salary")));
        new PositionDao().createNewPosition(position);
        System.out.println(position.toString());
        return new ModelAndView("adminhome", "createPositionInfo", "New Position Created");
    }

    @RequestMapping(value = "/")
    public ModelAndView userSingIn() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return new ViewUserProfile().getProfileInfo(username, status);
    }

    @RequestMapping(value = "/home")
    public ModelAndView userSingInH() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return new ViewUserProfile().getProfileInfo(username, status);
    }

    @RequestMapping(value = "/workstart", method = RequestMethod.POST)
    public ModelAndView workStart() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        DateTime current = DateTime.now();
        System.out.println("Время_-- " + current);
        WorkTable wt = new WorkTable();
        wt.setUser(new UserDao().findByUserName(username));
        wt.setStartTime(current);
        new WorkTableDAO().createNewWT(wt);
        status = "start";
        return new ViewUserProfile().getProfileInfo(username, status);
    }

    @RequestMapping(value = "/workstop", method = RequestMethod.POST)
    public ModelAndView workStop() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        DateTime current = DateTime.now();
        System.out.println("Время_-- " + current);
        User user = new UserDao().findByUserName(username);
        WorkTable wt = new WorkTableDAO().getWTbyUser(user);
        wt.setEndTime(current);
        new WorkTableDAO().updateEndTime(wt);
        status = "stop";
        return new ViewUserProfile().getProfileInfo(username, status);
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
