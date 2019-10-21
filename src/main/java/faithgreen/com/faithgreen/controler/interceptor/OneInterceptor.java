package faithgreen.com.faithgreen.controler.interceptor;

import faithgreen.com.faithgreen.pojo.FaithJsonResult;
import faithgreen.com.faithgreen.utils.JsonUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class OneInterceptor implements HandlerInterceptor
{
    /**
     * 在请求处理之前调用（controller的方法之前）
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception
    {
        System.out.println("被 one 拦截，放行。。。");
        if (true)
        {
            returnErrorResponse(response, FaithJsonResult.errorMsg("被one拦截"));
        }
        return true;
    }

    private void returnErrorResponse(HttpServletResponse response, FaithJsonResult result)
            throws IOException
    {
        OutputStream out = null;
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json");
        try
        {
            response.getOutputStream().write(JsonUtils.objectToJson(result).getBytes("utf-8"));
        }
        finally
        {
            if (out != null)
            {
                out.close();
            }
        }
    }

    /**
     * 在请求处理之后调用，但是在呗视图渲染之前（controller的方法之后）
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override public void postHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler, ModelAndView modelAndView) throws Exception
    {
    }

    /**
     * 在整个请求结束之后调用，也就是在DispatcherServlet渲染了对应的视图之后执行
     * （一般用于资源的清理）
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception ex) throws Exception
    {
    }
}
