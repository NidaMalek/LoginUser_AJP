/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
public class NewServlet2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException{
        response.setContentType("text/html; charset=UTF-8");
        
        Connection con = null;
        
        //System.out.println("Success 1!!");
        try{
              Class.forName("com.mysql.cj.jdbc.Driver");
              con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sql","root","rootN");
              //System.out.println("connection successful");
              Statement st=con.createStatement();
              ResultSet rs=st.executeQuery("select * from login");
            String user= request.getParameter("username");
            String pass= request.getParameter("password");
            //String e1="Invalid Credentials!";
                boolean flag = false;
                 while(rs.next()){
                   if(user.equals(rs.getString(1)) && pass.equals(rs.getString(2))){
                     flag = true; 
                     break;
                   }
                   else{
                     flag = false;
                     //err="Invalid Credentials!";
                   }
                 }   
                   if(flag == true){
                     request.setAttribute("u1",user);
                     RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
                     rd.forward(request,response);
                     
                   }
                   else {
                   // request.setAttribute("err","Invalid username or password");
                    //out.println(e1);
                     
                     getServletContext().setAttribute("errmsg","Incorrect username or password");
                    response.sendRedirect("http://localhost:8080/mavenproject1/index.jsp");
                     
//                     request.setAttribute("errorMessage", "Invalid username or password"); 
//                    RequestDispatcher dispatcher = request.getRequestDispatcher("/LoginPage.jsp");
//                    rd.forward( request, response);
                   }
             
                
                      
         
        

    //System.out.println("Successs2!!");
        }
           
            catch(Exception e){
                     e.getStackTrace();
        }
        finally{
         con.close();
        System.out.println("Disconnected from database");   
        }
    }



// Code for checking username and password--> if both correct then welcome page otherwise it'll be on the same page as it was.(index.html)
//        
//            /* TODO output your page here. You may use following sample code. */
//            String user=request.getParameter("username");
//                //in index.html file the in input type tag name is given as username
//            String pass=request.getParameter("password");
//                //in index.html file the in input type tag name is given as password
//            if(user.equals("Nida") && pass.equals("N123"))
//            {
//                RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
//                rd.forward(request, response);
//                      
//            }
//            else
//            {
//                RequestDispatcher rd=request.getRequestDispatcher("index.html");
//                rd.forward(request, response);
//            }
//                System.out.println("Successs2!!");
//        }
//           
//            catch(Exception e){
//                     e.getStackTrace();
//        }
//    }
//     
    
    //Code for database
    
//              Class.forName("com.mysql.cj.jdbc.Driver");
//              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql","root","rootN");
//              System.out.println("connection successful");
//              Statement st=con.createStatement();
//              ResultSet rs=st.executeQuery("select * from login");
//            String u= request.getParameter("username");
//            String p= request.getParameter("password");
//            
//                boolean flag;
//                 while(rs.next()){
//                   if(u.equals(rs.getString(1)) && p.equals( rs.getString(2))){
//                     flag = true;
//                     break;
//                   }
//                   else{
//                     flag = false;
//                   }
//             
//                   if(flag=true){
//                     RequestDispatcher rd=request.getRequestDispatcher("welcom.jsp");
//                     rd.forward(request,response);
//                   }
//                   else {
//                     RequestDispatcher rd = request.getRequestDispatcher("index.html");
//                     rd.forward(request,response);
//                   }
//             
//                }
        

//New task:14/04/2022
//create a new .jsp file ,copy code of login page from .html file, to print the name of user at welcome page through which 
//user logged in
//we've created json cauze the name we want to display it can be through java and login page is in html so we need jsp which
//supports java in html
//
//
//
//
//
//
//              Class.forName("com.mysql.cj.jdbc.Driver");
//              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql","root","rootN");
//              System.out.println("connection successful");
//              Statement st=con.createStatement();
//              ResultSet rs=st.executeQuery("select * from login");
//            String user= request.getParameter("username");
//            String pass= request.getParameter("password");
//            
//                boolean flag;
//                 while(rs.next()){
//                   if(user.equals(rs.getString(1)) && pass.equals( rs.getString(2))){
//                     flag = true;
//                     break;
//                   }
//                   else{
//                     flag = false;
//                   }
//             
//                   if(flag==true){
//                     request.setAttribute(user,user);
//                     RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
//                     rd.forward(request,response);
//                   }
//                   else {
//                     request.setAttribute("err","Invalid Credentials!");
//                     RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//                     rd.forward(request,response);
//                   }
//             
//                }
//
//    System.out.println("Successs!!");
//        }
//           
//            catch(Exception e){
//                     e.getStackTrace();
//        }
//}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        try {
            processRequest(request, response);
//        try {
//            processRequest(request, response);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(NewServlet2.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//        catch (SQLException ex) {
//            Logger.getLogger(NewServlet2.class.getName()).log(Level.SEVERE, null, ex);
//        }
        } 
//        
    catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(NewServlet2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(NewServlet2.class.getName()).log(Level.SEVERE, null, ex);
        }
//        catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(NewServlet2.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        catch (SQLException ex) {
//            Logger.getLogger(NewServlet2.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        catch (SQLException ex) {
//            Logger.getLogger(NewServlet2.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
//        catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(NewServlet2.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        catch (SQLException ex) {
//            Logger.getLogger(NewServlet2.class.getName()).log(Level.SEVERE, null, ex);
//        }
         
//        catch (SQLException ex) {
//            Logger.getLogger(NewServlet2.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

