package Controllers;

import DAO.ValidateUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginAuthenticationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String userName=request.getParameter("txtName");
        String userPass=request.getParameter("txtPass");
        ValidateUser isValid=new ValidateUser();
        if(isValid.validate(userName,userPass)){
            out.write("VALID USER");
        }else{
            out.write("INVALID USER");
        }

    }
}
