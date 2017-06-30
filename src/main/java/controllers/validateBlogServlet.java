package controllers;

import dao.ValidateBlog;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class validateBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        Integer blogId=Integer.parseInt(request.getParameter("txtID"));
        String blog=request.getParameter("txtBlog");
        ValidateBlog isValid=new ValidateBlog();
        if(isValid.validate(blogId,blog)>0){
            out.write("BLOG SUCCESSFULLY ADDED");
        }else{
            RequestDispatcher errPage=request.getRequestDispatcher("blog.jsp");
            out.write("Insertion Failed");
            errPage.include(request,response);
        }
    }

}
