package servlets;

import entity.*;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import session.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AdminServlet", urlPatterns = {
        "/listBuyers",
        "/adminForm",
        "/setRole",
        "/editUserProfileSettings",
        "/confirmUserFromListUsers",
        "/changeRoleFromListUsers",
})

public class AdminServlet extends HttpServlet {

    @EJB
    private ProductFacade productFacade;
    @EJB
    private UserFacade userFacade;
    @EJB
    private UserRolesFacade userRolesFacade;
    @EJB
    private RoleFacade roleFacade;
    @EJB
    private BuyerFacade buyerFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> listProducts = productFacade.findAll();
        request.setAttribute("listProducts", listProducts);

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession httpSession = request.getSession(false);
        if (httpSession == null) {
            request.setAttribute("info", "У вас нет права использовать этот ресурс. Войдите!");
            request.getRequestDispatcher("/loginForm").forward(request, response);
            return;
        }
        User user = (User) httpSession.getAttribute("user");
        if (user == null) {
            request.setAttribute("info", "У вас нет права использовать этот ресурс. Войдите!");
            request.getRequestDispatcher("/loginForm").forward(request, response);
            return;
        }
        boolean isRole = userRolesFacade.isRole("ADMIN", user);
        if (!isRole) {
            request.setAttribute("info", "У вас нет права использовать этот ресурс. Войдите с соответствующими правами!");
            request.getRequestDispatcher("/loginForm").forward(request, response);
            return;
        }

        request.setAttribute("role", userRolesFacade.getTopRoleForUser(user));
        String path = request.getServletPath();
        switch (path) {
            case "/listBuyers":
                request.setAttribute("activeListBuyers", "true");

                List<User> listUsers = userFacade.findAll();
                Map<User, List<String>> usersMapWithArrayRoles = new HashMap<>();
                for (User u : listUsers) {
                    List<String> arrStrRoles = userRolesFacade.findRoles(u);
                    usersMapWithArrayRoles.put(u, arrStrRoles);
                }

                request.setAttribute("usersMapWithArrayRoles", usersMapWithArrayRoles);
                request.setAttribute("usersCount", listUsers.size());
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("listBuyers")).forward(request, response);
                break;

            case "/adminForm":
                listProducts = productFacade.findAll();
                request.setAttribute("listProducts", listProducts);
                request.setAttribute("activeAdminPanel", "true");

                Map<User, String> usersMap = new HashMap<>();
                listUsers = userFacade.findAll();
                for (User u : listUsers) {
                    usersMap.put(u, userRolesFacade.getTopRoleForUser(u));
                }
                request.setAttribute("usersMap", usersMap);
                request.setAttribute("listRoles", roleFacade.findAll());
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("adminPanel")).forward(request, response);
                break;

            case "/setRole":
                String userId = request.getParameter("userId");
                String roleId = request.getParameter("roleId");

                user = userFacade.find(Long.parseLong(userId));
                Role role = roleFacade.find(Long.parseLong(roleId));
                UserRoles userRoles = new UserRoles(user, role);
                if (!"admin".equals(user.getLogin())) {
                    userRolesFacade.setNewRole(userRoles);
                    request.setAttribute("info", "Роль изменена!");
                } else {
                    request.setAttribute("userId", userId);
                    request.setAttribute("roleId", roleId);
                    request.setAttribute("info", "Изменить роль невозможно!");
                }
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("index")).forward(request, response);
                break;

            case "/editUserProfileSettings":
                String buyerId = request.getParameter("buyerId");
                Buyer buyer = buyerFacade.find(Long.parseLong(buyerId));

                request.setAttribute("buyer", buyer);
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("userProfileSettings")).forward(request, response);
                break;

            case "/confirmUserFromListUsers":
                userId = request.getParameter("userId");
                user = userFacade.find(Long.parseLong(userId));

                user.setUserStatus("confirmed");
                userFacade.edit(user);
                request.getRequestDispatcher("/listBuyers").forward(request, response);
                break;

            case "/changeRoleFromListUsers":
                userId = request.getParameter("userId");
                user = userFacade.find(Long.parseLong(userId));
                String strRoleId = "3";

                if (user.getUserStatus().equals("confirmed")){
                    if (userRolesFacade.isRole("BUYER", user)) {
                        strRoleId = "2";
                    }

                    if (userRolesFacade.isRole("MANAGER", user)) {
                        strRoleId = "1";
                    }

                    if (userRolesFacade.isRole("ADMIN", user)) {
                        strRoleId = "3";
                    }
                } else {
                    request.setAttribute("info", "Изменить роль невозможно! Подтвердите профиль!");
                    request.getRequestDispatcher("/listBuyers").forward(request, response);
                    break;
                }

                roleId = strRoleId;
                role = roleFacade.find(Long.parseLong(roleId));
                userRoles = new UserRoles(user, role);
                userRolesFacade.setNewRole(userRoles);
                request.getRequestDispatcher("/listBuyers").forward(request, response);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
