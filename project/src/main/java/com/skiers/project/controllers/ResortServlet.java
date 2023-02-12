package com.skiers.project.controllers;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import com.skiers.project.repositories.ResortRepository;
import com.skiers.project.models.Resorts;
import com.google.gson.*;


@WebServlet("/resorts/{resortID}")
public class ResortServlet extends HttpServlet {
    @Autowired
    ResortRepository resortRepository;
    private Gson gson = new Gson();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String emailId = req.getParameter("emailId");
        String password = req.getParameter("password");

        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("<html>");
        printWriter.print("<body>");
        printWriter.print("<h1>Student Resistration Form Data</h1>");
        printWriter.print("<p> firstName :: " + firstName + "</p>");
        printWriter.print("<p> lastName :: " + firstName + "</p>");
        printWriter.print("<p> firstName :: " + firstName + "</p>");
        printWriter.print("<p> firstName :: " + firstName + "</p>");
        printWriter.print("</body>");
        printWriter.print("</html>");
        printWriter.close();

        System.out.println("firstName :: " + firstName);
        System.out.println("lastName :: " + lastName);
        System.out.println("emailId :: " + emailId);
        System.out.println("password :: " + password);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] pathInfo = req.getPathInfo().split("/");
        String id = pathInfo[1]; // {id}
        System.out.println("" + id);
        Resorts resorts =  resortRepository.findByMappingCode(id);
    

        //resp.setContentType("application/json");

        String jsonString = gson.toJson(resorts);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(jsonString);
        out.flush();

        
    }}

   