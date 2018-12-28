package com.wxq.modelspringboot.common.servlet;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@WebServlet(name = "test", urlPatterns = "/testServlet")  //标记为servlet，以便启动器扫描。
public class TestServlet extends HttpServlet {

    @Autowired
    DataSource dataSource;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
//        resp.getWriter().append(dataSource.toString());
        ServletContext context = this.getServletConfig().getServletContext();
        File jasperFile=new File("D://test1.jasper");
        JasperReport jasperReport = null;
        try {
            jasperReport = (JasperReport) JRLoader.loadObject(jasperFile);
        } catch (JRException e) {
            e.printStackTrace();
        }
        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport(jasperReport,null,dataSource.getConnection());
        } catch (JRException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.setContentType("application/pdf");
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyyMMddHHmmss");
        String name = new String("工单打印"
                + dateFormat.format(new Date().getTime()) + ".pdf");
        String fileName = new String(name.getBytes("GBK"), "ISO8859-1");
        response.setHeader("Content-Disposition",
                "attachment; filename=\"" + fileName + "\"");
        ServletOutputStream outStream = response.getOutputStream();
        try {
            JasperExportManager.exportReportToPdfStream(jasperPrint,
                    outStream);
        } catch (JRException e) {
            e.printStackTrace();
        }
        outStream.flush();
        outStream.close();
    }
}
