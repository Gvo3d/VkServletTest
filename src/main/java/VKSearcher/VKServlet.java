package VKSearcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Gvozd on 10.07.2016.
 */
public class VKServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("cp1251");
        PrintWriter out = resp.getWriter();

        out.println("<meta http-equiv=\"refresh\" content=\"0;url=https://oauth.vk.com/authorize? \n" +
                "\" +\n" +
                "                \" client_id=5542076& \\n\" +\n" +
                "                \" scope=nohttps& \\n\" +\n" +
                "                \" redirect_uri=https://oauth.vk.com/blank.html& \\n\" +\n" +
                "                \" display=page& \\n\" +\n" +
                "                \" v=5.0& \\n\" +\n" +
                "                \" response_type=token\">");
        out.close();
    }
}
