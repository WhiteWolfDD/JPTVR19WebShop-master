package servlets;

import entity.*;
import session.*;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ManagerServlet", urlPatterns = {
        "/addProduct",
        "/createProduct",
        "/editBuyerForm",
        "/editBuyer",
        "/showBoughtProduct",
        "/uploadForm",
        "/checkUserProfile",
        "/addCollection",
        "/createCollection",
        "/removeCollection",
        "/deleteCollection"
})

public class ManagerServlet extends HttpServlet {

    @EJB
    private ProductFacade productFacade;
    @EJB
    private BuyerFacade buyerFacade;
    @EJB
    private HistoryFacade historyFacade;
    @EJB
    private UserRolesFacade userRolesFacade;
    @EJB
    private CoverFacade coverFacade;
    @EJB
    private CollectionFacade collectionFacade;

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
        boolean isRole = userRolesFacade.isRole("BUYER", user);
        if (!isRole) {
            request.setAttribute("info", "У вас нет права использовать этот ресурс. Войдите с соответствующими правами!");
            request.getRequestDispatcher("/loginForm").forward(request, response);
            return;
        }

        request.setAttribute("role", userRolesFacade.getTopRoleForUser(user));
        String path = request.getServletPath();
        switch (path) {
            case "/addProduct":
                List<Cover> listCovers = coverFacade.findAll();
                List<Collection> collectionList = collectionFacade.findAll();
                request.setAttribute("listCovers", listCovers);
                request.setAttribute("collectionList", collectionList);
                request.setAttribute("activeAddProduct", "true");
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("newProduct")).forward(request, response);
                break;

            case "/createProduct":
                String model = request.getParameter("model");
                String price = request.getParameter("price");
                String count = request.getParameter("count");
                String coverId = request.getParameter("coverId");
                String collectionId = request.getParameter("collectionId");
                String width = request.getParameter("width");
                String height = request.getParameter("width");
                String depth = request.getParameter("depth");
                String seat_height = request.getParameter("seat_height");
                String seat_depth = request.getParameter("seat_depth");
                String sleeping_area_width = request.getParameter("sleeping_area_width");
                String sleeping_area_length = request.getParameter("sleeping_area_length");
                String delivery_time = request.getParameter("delivery_time");
                String delivery_price = request.getParameter("delivery_price");
                String guarantee = request.getParameter("guarantee");
                String sleeping_function = request.getParameter("sleeping_function");
                String legs = request.getParameter("legs");
                String bedding_box = request.getParameter("bedding_box");
                String color_selection = request.getParameter("color_selection");
                String materials = request.getParameter("materials");
                String resistance = request.getParameter("resistance");
                String origin = request.getParameter("origin");

                Collection collection = collectionFacade.find(Long.parseLong(collectionId));
                Cover cover = coverFacade.find(Long.parseLong(coverId));
                Product product = new Product(model, Double.parseDouble(price), Integer.parseInt(count), Integer.parseInt(width), Integer.parseInt(height), Integer.parseInt(depth), Integer.parseInt(seat_depth), Integer.parseInt(seat_height), Integer.parseInt(sleeping_area_length), Integer.parseInt(sleeping_area_width), Integer.parseInt(delivery_time), Double.parseDouble(delivery_price), Integer.parseInt(guarantee), sleeping_function, legs, bedding_box, color_selection, materials, resistance, origin, cover, collection);
                productFacade.create(product);

                request.setAttribute("info", "Товар " + '"' + product.getCollection() + " " + product.getModel() + " добавлен.");
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("index")).forward(request, response);
                break;

            case "/addCollection":
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("addCollection")).forward(request, response);
                break;

            case "/createCollection":
                String collectionName = request.getParameter("collectionName");

                collection = new Collection(collectionName);
                collectionFacade.create(collection);

                request.setAttribute("info", "Коллекция " + '"' + collection.getCollectionName() + '"' + " успешно добавлена.");
                request.getRequestDispatcher("/addProduct").forward(request, response);
                break;

            case "/removeCollection":
                listCovers = coverFacade.findAll();
                collectionList = collectionFacade.findAll();
                request.setAttribute("listCovers", listCovers);
                request.setAttribute("collectionList", collectionList);

                request.getRequestDispatcher(LoginServlet.pathToFile.getString("removeCollection")).forward(request, response);
                break;

            case "/deleteCollection":
                collectionId = request.getParameter("collectionId");

                collection = collectionFacade.find(Long.parseLong(collectionId));
                collectionFacade.remove(collection);

                request.setAttribute("info", "Коллекция" + '"' + collection.getCollectionName() + '"' + " успешно удалена.");
                request.getRequestDispatcher("/addProduct").forward(request, response);
                break;

            case "/editBuyerForm":
                request.setAttribute("listBuyers", "true");
                List<Buyer> listBuyers = buyerFacade.findAll();
                request.setAttribute("listBuyers", listBuyers);
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("editBuyer")).forward(request, response);
                break;

            case "/editBuyer":
                String buyerId = request.getParameter("buyerId");
                String name = request.getParameter("name");
                String lastname = request.getParameter("lastname");
                String money = request.getParameter("money");
                String email = request.getParameter("email");

                Buyer buyer = buyerFacade.find(Long.parseLong(buyerId));
                buyer.setName(name);
                buyer.setLastname(lastname);
                buyer.setMoney(Double.parseDouble(money));
                buyer.setEmail(email);
                buyerFacade.edit(buyer);
                request.setAttribute("buyerId", buyerId);
                request.setAttribute("buyer", buyer);
                request.setAttribute("info", "Пользователь " + buyer.getName() + " " + buyer.getLastname() + " был успешно изменён.");
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("index")).forward(request, response);
                break;

            case "/showBoughtProduct":
                request.setAttribute("activeListHistory", "true");

                List<History> listHistory = historyFacade.findAll();
                Map<History, List<History>> historyListMap = new HashMap<>();
                for (History history : listHistory) {
                    List<History> historyArray = historyFacade.findBoughtProducts(history);
                    historyListMap.put(history, historyArray);
                }

                request.setAttribute("historyListMap", historyListMap);
                request.setAttribute("historyCount", listHistory.size());
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("showBoughtProduct")).forward(request, response);
                break;

            case "/uploadForm":
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("uploadForm")).forward(request, response);
                break;

            case "/checkUserProfile":
                buyerId = request.getParameter("buyerId");
                buyer = buyerFacade.find(Long.parseLong(buyerId));

                request.setAttribute("buyer", buyer);
                request.getRequestDispatcher(LoginServlet.pathToFile.getString("userProfile")).forward(request, response);
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