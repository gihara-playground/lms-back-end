package com.ijse.lms.lmsbackend;

import com.ijse.lms.lmsbackend.dto.StudentDTO;
import com.ijse.lms.lmsbackend.exception.ValidationException;
import jakarta.json.*;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbException;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getContentType()==null || !request.getContentType().toLowerCase().startsWith("application/json")){
            response.sendError(415);
            return;
        }
//        BufferedReader reader = request.getReader();
//        StringBuilder sb = new StringBuilder();
//        reader.lines().forEach(line -> sb.append(line+"\n"));
//        System.out.println(sb.toString());
//
//        JsonReader jsonReader = Json.createReader(request.getReader());
//        JsonArray array = jsonReader.readArray();
//        for (int i = 0; i < array.size(); i++) {
//            JsonObject elm = array.getJsonObject(i);
//            System.out.println(elm.getString("name"));
//            System.out.println(elm.getString("nic"));
//            System.out.println(elm.getString("email"));
//        }
//
//        response.setContentType("application/json");
//        JsonWriter writer = Json.createWriter(response.getWriter());
//        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
//        arrayBuilder.add(10);
//        arrayBuilder.add(false);
//        arrayBuilder.add(Json.createArrayBuilder().add(10).add(20).build());
//        arrayBuilder.add(Json.createObjectBuilder().add("id","C001").add("name","Gihara").build());
//        JsonArray jsonArray = arrayBuilder.build();
//        writer.writeArray(jsonArray);
//        Jsonb jsonb = JsonbBuilder.create();
//        List<Customer> customerList = jsonb.fromJson(request.getReader(),
//                new ArrayList<Customer>(){}.getClass().getGenericSuperclass());
//
//        customerList.forEach(System.out::println);
//
//        List<Customer> anotherCustomerList = new ArrayList<>();
//        anotherCustomerList.add(new Customer("C001", "Nuwan", "Galle"));
//        anotherCustomerList.add(new Customer("C001", "Nuwan", "Galle"));
//        anotherCustomerList.add(new Customer("C001", "Nuwan", "Galle"));
//        anotherCustomerList.add(new Customer("C001", "Nuwan", "Galle"));
//        anotherCustomerList.add(new Customer("C001", "Nuwan", "Galle"));
//
//        response.setContentType("application/json");
//        jsonb.toJson(anotherCustomerList, response.getWriter());
        Jsonb jsonb = JsonbBuilder.create();
        try {
            StudentDTO studentDTO = jsonb.fromJson(request.getReader(), StudentDTO.class);
            if (studentDTO.getName() == null || !studentDTO.getName().matches("[A-Za-z ]+")){
                throw new ValidationException("Invalid student name");
            }else if (studentDTO.getNic() == null || !studentDTO.getNic().matches("\\d{9}[Vv]")){
                throw new ValidationException("Invalid student nic");
            }else if (studentDTO.getEmail() == null || !studentDTO.getEmail().matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")){
                throw new ValidationException("Invalid student email");
            }
            System.out.println(studentDTO);
        }catch (JsonbException e){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JSON");
        }catch (ValidationException e){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        }
    }

}
