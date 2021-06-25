package ru.geekbrains;

import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/product/*")
public class ProductServlet extends HttpServlet {
    private ProductRepository productRepository;
    @Override
    public void init() throws ServletException {
     productRepository = (ProductRepository) getServletContext().getAttribute("productRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getPathInfo() == null) {
            List<Product> products = productRepository.findAll();
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().println("<h3>Таблица продуктов</h3>\n");
            resp.getWriter().println("<html>\n" +
                    "<body>\n" +
                    "<table border=\"1\">\n" +
                    "<tr>\n" +
                    "<td>ID</td>" +
                    "<td>Name</td>" +
                    "</tr>\n"
            );
            for (Product product : products) {
                resp.getWriter().println(
                        "<tr>\n" +
                                "<td>" + product.getId() + "</td>" +
                                "<td>" +"<a href=\""+ req.getContextPath()+req.getServletPath()+"/"+product.getId() +"\" target=\"_blanc\">"+  product.getName() +"</a>"+ "</td>" +
                                "</tr>\n"
                );

            }
            resp.getWriter().println("</table>\n" +
                    "</body>\n" +
                    "</html>");

        } else {
            String pathInfo = req.getPathInfo();
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            String result = pathInfo.replaceAll("[^\\p{L}\\p{N}]+", "");
            Long id= Long.valueOf(result).longValue();
            productRepository.findById(id);


            resp.getWriter().println("<h3>Карточка продукта</h3>\n");
            resp.getWriter().println("<html>\n" +
                    "<body>\n" +
                    "<table border=\"1\">\n" +
                    "<tr>\n" +
                    "<td>ID</td>" +
                    "<td>Name</td>" +
                    "<td>Description</td>" +
                    "</tr>\n"
            );

                resp.getWriter().println(
                        "<tr>\n" +
                                "<td>" + id + "</td>" +
                                "<td>" +productRepository.findById(id).getName()+ "</td>" +
                                "<td>" +"in process"+ "</td>" +
                                "</tr>\n"
                );


            resp.getWriter().println("</table>\n" +
                    "</body>\n" +
                    "</html>");

        }
    }

}
