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


@WebServlet("/resorts/*")
public class ResortID extends HttpServlet {
    @Autowired
    ResortRepository resortRepository;
    private Gson gson = new Gson();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StringBuilder sb = new StringBuilder();
            String s;
            while ((s = req.getReader().readLine()) != null) {
                sb.append(s);
            }
 
            Resorts resort = (Resorts) gson.fromJson(sb.toString(), Resorts.class);
        // var modelMapper = new ModelMapper();
        // priceDetails = modelMapper.map(resorts, Resorts.class);

        
        resortRepository.save(resort);
       


        
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     String[] pathInfo = req.getPathInfo().split("/"); // read from path( resort/...)
     String id = pathInfo[1]; // {id}
     Integer max= pathInfo.length;
     System.out.println("firstName" + id);
     Resorts resorts =  resortRepository.findByMappingCode(id);// 
    

        //resp.setContentType("application/json");
     if(max==2){
     String jsonString = gson.toJson(resorts); //
     PrintWriter out = resp.getWriter();
     resp.setContentType("application/json");
     resp.setCharacterEncoding("UTF-8");
     out.print(jsonString);
     out.flush();
     } else{
        String jsonString = gson.toJson(resorts.seasons); //
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(jsonString);
        out.flush();

     }

        }
}