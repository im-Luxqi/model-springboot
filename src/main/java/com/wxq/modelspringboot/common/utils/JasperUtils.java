package com.wxq.modelspringboot.common.utils;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.*;
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

            switch (type){
                case "pdf":
                    fileNickName += ".pdf";
                    fileNickName = new String(fileNickName.getBytes("GBK"), "ISO8859-1");
                    response.setContentType("application/pdf");
                    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileNickName + "\"");
                    outStream = response.getOutputStream();
                    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
                    break;
                case "xlsx":
                    fileNickName += ".xlsx";
                    fileNickName = new String(fileNickName.getBytes("GBK"), "ISO8859-1");
                    response.setContentType("application/x-download");
                    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileNickName + "\"");
                    outStream = response.getOutputStream();

                    //设置导出时参数
                    SimpleXlsxReportConfiguration conf = new SimpleXlsxReportConfiguration();
                    conf.setWhitePageBackground(false);
                    conf.setDetectCellType(true);
                    JRXlsxExporter exporter = new JRXlsxExporter();
                    exporter.setConfiguration(conf);
                    //设置输入项
                    ExporterInput exporterInput = new SimpleExporterInput(jasperPrint);
                    exporter.setExporterInput(exporterInput);
                    //设置输出项
                    OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(outStream);
                    exporter.setExporterOutput(exporterOutput);
                    exporter.exportReport();
                    break;
            }

            assert outStream != null;
            outStream.flush();
            outStream.close();
        } catch (IOException | JRException | SQLException e) {
            e.printStackTrace();
        }
    }
}
