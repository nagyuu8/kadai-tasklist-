package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Tasks;

/**
 * Servlet implementation class NewServlet
 */
@WebServlet("/new")
public class NewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //CSRF対策
        req.setAttribute("_token", req.getSession().getId());

        //おまじないインスタンス
        req.setAttribute("tasks", new Tasks());

        //データベース入力テスト
//        EntityManager em = DBUtil.createEntityManager();
//        em.getTransaction().begin();
//
//        Tasks t = new Tasks();
//        String content = "taskPG-TestMessage";
//        t.setContent(content);
//        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
//        t.setCreated_at(currentTime);
//        t.setUpdated_at(currentTime);
//        em.persist(t);
//        em.getTransaction().commit();
//        resp.getWriter().append(Integer.valueOf(t.getId()).toString());
//        em.close();

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/tasks/new.jsp");
        rd.forward(req, resp);


    }

}
