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

@WebServlet(name = "newReceiverServlet", urlPatterns = "/new-receiver")
public class NewReceiverServlet extends HttpServlet {
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        try {
            ReceiverDao receiverDao = daoFactory.getReceiverDao();
            Receiver receiver = new Receiver();

            receiver.setIdRec(Integer.parseInt(req.getParameter("test.idRec")));
            receiver.setReceiverRec(req.getParameter("test.receiverRec"));

            receiverDao.addReceiver(receiver);

            writer.println("<p1>New receiver " + receiver + " has been added!");
        } catch (Exception e) {
            e.printStackTrace();
            writer.println("<p1>Error: " + e.getMessage());

        }
    }
}
