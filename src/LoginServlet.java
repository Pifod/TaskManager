import com.myweb.DAO;
import com.myweb.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Виталик on 26.05.2016.
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/Login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        super.service(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("Login");
        String password=request.getParameter("LoginPass");

        System.out.println("Перед try");
        try {
            System.out.println("В  try");
            User user= DAO.RegisteredId(email);

            if(user==null){
                System.out.println("Нету в базе");
                response.sendRedirect("/Main?error=1");//ненашло в базе
                System.out.println("в if");
            }else{
                if(user.getPassword().equals(password)) {
                    System.out.println("Пароли совпадают");
                    HttpSession session = request.getSession();
                    session.setAttribute("UserID", user.getId());
                    session.setAttribute("UserClas", user);
                    session.setAttribute("UserClas", user);
                    response.sendRedirect("/MainLoged");
                }else{
                    response.sendRedirect("/Main?error=2");
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("RegMail");
        String password=request.getParameter("RegPass");

    }
}
