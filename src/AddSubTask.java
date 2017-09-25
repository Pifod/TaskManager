import com.myweb.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Виталик on 30.05.2016.
 */
@WebServlet(name = "AddSubTask",urlPatterns = "/taskSubAdd")


public class AddSubTask extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        super.service(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //System.out.println(name);
        String description=request.getParameter("Subtasktext");
        //Simple date format
        System.out.println(description);

        int subTask_Id = Integer.parseInt(request.getParameter("task_id"));
        System.out.println(subTask_Id);
        String strdaedline=request.getParameter("Subtaskdate");
        System.out.println(strdaedline);
        DateFormat format=new SimpleDateFormat("yyyy-dd-MM");
        Date daedline=null;
        try {
            daedline = format.parse(strdaedline);
            java.sql.Date sqlDate1=new java.sql.Date(daedline.getTime());
            DAO.AddSubTask(subTask_Id,description,sqlDate1);
        } catch (ParseException |ClassNotFoundException  | SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/getsub?task_id="+subTask_Id);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
