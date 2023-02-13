package com.skiers.project.controllers;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.skiers.project.models.Resorts;
import com.skiers.project.repositories.ResortRepository;


@WebServlet("/resorts")
public class ResortList extends HttpServlet {
    @Autowired
    ResortRepository resortRepository;
    private Gson gson = new Gson();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Resorts> listtotal = new ArrayList<>();
        listtotal = resortRepository.findAll();         
        String jsonString = gson.toJson(listtotal); //
        PrintWriter out = resp.getWriter();
        //resp.setContentType("application/json");
        //resp.setCharacterEncoding("UTF-8");
        resp.setStatus(200);
        out.print(jsonString);
        out.flush();
    }
}












