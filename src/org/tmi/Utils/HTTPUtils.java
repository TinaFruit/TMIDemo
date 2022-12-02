package org.tmi.Utils;

import javax.servlet.http.HttpServletResponse;

public class HTTPUtils {
    public static final int STATUS_404 =404;// resource not found
    public static final int STATUS_200 =200;// succeed
    public static final int STATUS_500 =500;// server side error
    public static final int STATUS_403 =403;// not authorized
    public static HttpServletResponse setResponseHeaders(HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.setHeader("Server", "tina");
        return response;
    }
}
