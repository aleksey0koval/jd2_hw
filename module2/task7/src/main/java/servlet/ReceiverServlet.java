package servlet;

import data.DaoFactory;
import data.DatabaseName;
import data.Receiver;
import data.ReceiverDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "receiverServlet", urlPatterns = "/receivers")
public class ReceiverServlet extends HttpServlet {

    DaoFactory daoFactory;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        final String databaseName = config.getServletContext().getInitParameter("database.name");
        try {
            daoFactory = DaoFactory.getInstance(DatabaseName.valueOf(databaseName));
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String id = req.getParameter("id");
            final List<Receiver> receivers;
            ReceiverDao receiverDao = daoFactory.getReceiverDao();
            if (id == null) {
                receivers = receiverDao.readAllReceivers();
            } else {
                Receiver receiver = null;
                try {
                    receiver = receiverDao.readReceiver(Integer.parseInt(id));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                receivers = receiver != null ? List.of(receiver) : Collections.emptyList();
            }
            resp.setContentType("text/html; charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter writer = resp.getWriter();
            writer.println("<html><head><title>receiverServlet</title></head>");

            for (Receiver receiver : receivers) {
                System.out.println("id= " + receiver.getIdRec() + " name " + receiver.getReceiverRec());
                writer.println("<body><h1>id= " + receiver.getIdRec() + " name " + receiver.getReceiverRec() + "</h1>");
                writer.println("</body></html>");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
