import com.myweb.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Виталик on 26.05.2016.
 */
@WebServlet(name = "AddTask",urlPatterns = "/AddTask")
public class AddTask extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        super.service(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int person_id= (int) request.getSession().getAttribute("UserID");
        String name=request.getParameter("TaskName");
        //System.out.println(name);
        String description=request.getParameter("Description");
        //Simple date format

        String strdaedline=request.getParameter("Deadline");
        System.out.println(strdaedline);

        System.out.println(request.getParameter("Deadline"));
        DateFormat format=new SimpleDateFormat("yyyy-dd-MM");
        Date daedline=null;
        try {
            daedline = format.parse(strdaedline);
            java.sql.Date sqlDate1=new java.sql.Date(daedline.getTime());
            Date date= Calendar.getInstance().getTime();
            java.sql.Date sqlDate2 = new java.sql.Date(date.getTime());
            DAO.AddTask(person_id,name,description,sqlDate1,sqlDate2);
        } catch (ParseException |ClassNotFoundException  | SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/MainLoged");//response.sendRedirect("/getsub");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
