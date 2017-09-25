import com.myweb.DAO;
import com.myweb.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Виталик on 26.05.2016.
 */
@javax.servlet.annotation.WebServlet(name = "RegistrationSerf", urlPatterns="/Registration")
public class RegistrationSerf extends javax.servlet.http.HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        super.service(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String name=request.getParameter("RegName");
        //System.out.println(name);
        String email=request.getParameter("RegMail");
        String password=request.getParameter("RegPass");
        String doblePassword=request.getParameter("RegDoblePass");//Сюда вставить проверку совпадения с паролем через if
        User user=null;
       String equa=null;
        try {
            user=DAO.RegisteredId(email);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(user==null) {
            if (password.equals(doblePassword)) {

                try {
                    DAO.AddUser(name, email, password);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
//                equa="You are registered";
//                request.setAttribute("Equa",equa);

                response.sendRedirect("/Main?error=4");

            }else{
                response.sendRedirect("/Main?error=3");//пароли не совпадают
            }

        }else {
            System.out.println("Нашел в базе идентичного");
            response.sendRedirect("/Main?error=5");//Такой пользователь есть в базе

        }
        System.out.println("тестинг");
        //response.sendRedirect("/Main");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        System.out.println("!!!!!!! Работает GEt в регистрации");
        request.getRequestDispatcher("WEB-INF/Main.jsp").forward(request,response);
    }
}
