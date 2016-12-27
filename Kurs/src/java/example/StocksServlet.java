package example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

/**
 *
 * @author MegaNout
 */
public class StocksServlet extends HttpServlet {

    public void doGet (HttpServletRequest req, HttpServletResponse res)
    {
        doPost(req, res);
    }
    public void doPost (HttpServletRequest req, HttpServletResponse res)
    {
        PrintWriter out = null;
        res.setContentType("text/html");
        try {
            out = res.getWriter();
        }catch(Exception ex){}
        Hashtable quotes = new Hashtable();
        quotes.put("MSFT", new Double(100.95));
        quotes.put("ORCL", new Double(50.95));
        
        Enumeration values = req.getParameterNames();
        Vector symbolVector = new Vector();
        while(values.hasMoreElements())
        {
            String name = (String)values.nextElement();
            String[] value = req.getParameterValues(name);
            if(name.equalsIgnoreCase("symbol"))
            {
                int len = value.length;
                for(int i=0; i<len; i++)
                    symbolVector.addElement(value[i]);
            }
        }