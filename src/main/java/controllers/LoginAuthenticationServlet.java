package controllers;

import dao.ValidateUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginAuthenticationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String userName=request.getParameter("txtName");
        String userPass=request.getParameter("txtPass");
        ValidateUser isValid=new ValidateUser();
        HttpSession session=request.getSession();
        if(isValid.validate(userName,userPass)){
            session.setAttribute("uname",userName);
            session.setAttribute("upass",userPass);
            RequestDispatcher nextPage=request.getRequestDispatcher("blog.jsp");
            nextPage.forward(request,response);
        }else{
            RequestDispatcher errPage=request.getRequestDispatcher("index.jsp");
            out.println("Sorry Wrong username or password");
            errPage.include(request,response);
        }

    }
}
