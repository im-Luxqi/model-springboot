package com.wxq.modelspringboot.common.utils;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Component
public class JasperUtils {
    @Autowired
    private DataSource dataSource;

    public void printFile(String type, String jasperName, String fileNickName, Map<String, Object> jasperParameters,
                          HttpServletRequest request, HttpServletResponse response) {
        String jasperFilePath = JasperUtils.class.getResource("/").getPath().substring(1)
                + "jasper/" + jasperName + ".jasper";
        fileNickName += new SimpleDateFormat("yyyyMMddHHmmss").format(new Date().getTime());


        File jasperFile = new File(jasperFilePath);
        JasperReport jasperReport = null;
        JasperPrint jasperPrint = null;
        ServletOutputStream outStream = null;
        try {
            jasperReport = (JasperReport) JRLoader.loadObject(jasperFile);
            jasperPrint = JasperFillManager.fillReport(jasperReport, jasperParameters, dataSource.getConnection());

            fileNickName += ".pdf";
            fileNickName = new String(fileNickName.getBytes("GBK"), "ISO8859-1");
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileNickName + "\"");

            outStream = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
            outStream.flush();
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JRException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
