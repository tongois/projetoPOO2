/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.poo.tp02;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ton
 */
@WebServlet(name = "jurosSimpless", urlPatterns = {"/jurosSimpless"})
public class jurosSimpless extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet jurosSimpless</title>");      
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +
"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>"
                    );
            out.println("<style>");
            
            out.println(".caixa{width:100%;height:85px;background-color:#447FFF;}"
                    + ".caixa h1{text-align:center;padding-top:20px;color:#FFF;text-shadow:2px 3px 2px gray;}"
                    + ".formulario{width:300px;margin:30px auto;}"
                    + ".formulario label{font-size:15px;color:gray;font-weight:600;}"
                    + ".formulario .btnEnviar{background-color:#237382;border:3px;width:130px;height:40px;font-size:16px;color:#fff;}"
                    + ".formulario .limpar{background:rgb(252,45,54);margin-left:10px;}"
                    + ".tabResultado{width:700px;margin:0 auto;}"
                    + ".tabResultado th{background:#9EC0E3;font-weight:600;color:#fff;text-shadow:1px 1px 2px gray;font-size:18px;text-align:center;}"
                    + ".tabResultado td{background:#FDFFF5;text-align:center;font-size:18px;font-weight:bolder;color:#FF715E;}"
                    + "footer .caixa{margin-top:30px;}");
            
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='caixa'>");
            out.println(" <h1> Juros Simples</h1>");
            out.println("</div>");
            
            out.println("<form method='get' class=formulario>"
                    + "<div class=\"form-group\">\n" +
"    <label>Capital:</label>\n" +
"    <input type=\"text\" class=\"form-control\" id=\"exampleFormControlInput1\" placeholder=\"Informe o capital\" name='capital'>\n" +
"  </div>"
                    + "<div class=\"form-group\">\n" +
"    <label for=\"exampleFormControlInput1\">Taxa de Juros:</label>\n" +
"    <input type=\"text\" class=\"form-control\" id=\"exampleFormControlInput1\" placeholder=\"Informe a taxa de juros\" name='taxaJuros'>\n" +
"  </div>"
                    + "<div class=\"form-group\">\n" +
"    <label for=\"exampleFormControlInput1\">Periodo:</label>\n" +
"    <input type=\"text\" class=\"form-control\" id=\"exampleFormControlInput1\" placeholder=\"Informe o periodo em meses\" name='periodo'>\n" +
"  </div>"
                    + "<input type='submit' value='Calcular' class='btnEnviar'>"
                    + "<input type='reset' value='Limpar' class='btnEnviar limpar'> </form>");
            
            
            DecimalFormat df = new DecimalFormat("###,##0.00");
            DecimalFormat j = new DecimalFormat("###0");
            double capital = 0;
            double taxaJuros = 0;
            int periodo = 0;
            double montante = 0;
            double converteTaxa = 0;
            double juros = 0;
            
             capital = Double.parseDouble(request.getParameter("capital"));
             taxaJuros = Double.parseDouble(request.getParameter("taxaJuros"));
             periodo = Integer.parseInt(request.getParameter("periodo"));
             
            converteTaxa = (taxaJuros/100);
            juros = ((capital * converteTaxa)*periodo);
            montante = capital + juros;
            
            
            out.println(" <table class=\"table tabResultado\">\n" +
"    \n" +
"      <tr>\n" +
"        <th>Valor do Capital</th>\n" +
"        <td>R$"+df.format(capital) +"</td>\n" +
"      </tr>\n" +
"      <tr>\n" +
"        <th>Taxa de Juros</th>\n" +
"        <td>"+ j.format(taxaJuros)+"%</td>\n" +
"      </tr>\n" +
"      <tr>\n" +
"        <th>Periodo</th>\n" +
"        <td>"+periodo+" meses</td>\n" +
"      </tr>\n" +
"      <tr>\n" +
"        <th>Total de Juros</th>\n" +
"        <td>R$"+df.format(juros)+"</td>\n" +
"      </tr>"
    + " <tr>\n" +
"        <th>Montante</th>\n" +
"        <td>R$"+df.format(montante)+"</td>\n" +
"      </tr>  "
        + "</table>\n" +
"</div>");
            out.println("<footer>");
            out.println("<div class='caixa'></div>");
            out.println("</footer>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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
