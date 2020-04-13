package com.spring.work02.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
@EnableAsync
public class MailController {
    @Autowired
    @Qualifier("mailService")
    private MailService mailService;
    @RequestMapping(value = "/sendMail.do", method = RequestMethod.GET)
    public void sendSimpleMail(HttpServletRequest request,
                               HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        StringBuffer sb = new StringBuffer();
        sb.append("<html><body>");
        sb.append("<meta http-equiv='Content-Type' content='text/html; charset=euc-kr'>");
        sb.append("<h1>제품 소개</h1><br/>");
        sb.append("신간 도서 소개.<br/><br/>");
        sb.append("<a href='http://www.yes24.com/Product/Goods/86038744?Acode=101'>");
        sb.append("<img src='http://image.yes24.com/goods/86038744/800x0'/></a>");
        sb.append("</body></html>");
        String str = sb.toString();
        mailService.sendMail("gkska1029@naver.com", "Test HTML Mail", str);
        out.print("메일을 보냈습니다.");
    }
}
