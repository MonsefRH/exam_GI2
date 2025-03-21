package org.example.exam_25.servlet;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exam_25.dao.InterfaceDAo_impl;
import org.example.exam_25.module.Document;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class DocumentServlet extends HttpServlet {
    private InterfaceDAo_impl dao= new InterfaceDAo_impl();
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        List<Document> documents = dao.getAvailableDocuments();
        String jsonResponse = gson.toJson(documents);

        PrintWriter out = resp.getWriter();
        out.print(jsonResponse);
        out.flush();
    }
}