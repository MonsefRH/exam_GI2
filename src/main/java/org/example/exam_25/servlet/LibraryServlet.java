package org.example.exam_25.servlet;

import com.google.gson.Gson;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exam_25.dao.InterfaceDAo_impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class LibraryServlet extends HttpServlet {
    private InterfaceDAo_impl dao= new InterfaceDAo_impl();
    private Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String action = req.getParameter("action");
        int userId = Integer.parseInt(req.getParameter("userId"));
        int documentId = Integer.parseInt(req.getParameter("documentId"));

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        Map<String, String> response = new HashMap<>();

        if ("borrow".equals(action)) {
            dao.borrowDocument(userId, documentId);
            response.put("message", "Document borrowed successfully");
        } else if ("return".equals(action)) {
            dao.returnDocument(userId, documentId);
            response.put("message", "Document returned successfully");
        } else {
            response.put("error", "Invalid action");
        }

        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(response));
        out.flush();
    }
}