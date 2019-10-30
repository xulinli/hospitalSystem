package com.hos.controller.storage;

import com.hos.entity.StroageIn;
import com.hos.service.storage.StorageInService;
import com.hos.utils.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author xu
 * @date 19/10/29-8:33
 */
@Controller
@RequestMapping(value = "/report")
public class LoadExcel {

    @Autowired
    private StorageInService storageIn;

    /**
     * 导出报表
     *
     * @return
     * @author xu
     * @date 19/10/29-8:33
     */
    @RequestMapping(value = "/export")
    @ResponseBody
    public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取数据
        List<StroageIn> list = storageIn.query();

        //excel标题
        String[] title = {"编号", "药品名称", "数量", "供货商", "操作人员", "入库时间", "过期时间", "有效期", "价格"};

        //excel文件名
        String fileName = "药库库存表" + System.currentTimeMillis() + ".xls";

        //sheet名
        String sheetName = "药库库存表";

        //创建二维数组用于存储数据
        String[][] content = new String[list.size()][];

        for (int i = 0; i < list.size(); i++) {
            content[i] = new String[title.length];
            StroageIn obj = list.get(i);
            content[i][0] = String.valueOf(obj.getId());
            content[i][1] = obj.getName();
            content[i][2] = String.valueOf(obj.getNumber());
            content[i][3] = obj.getSupplier();
            content[i][4] = obj.getAction();
            content[i][5] = obj.getInTime();
            content[i][6] = obj.getOutTime();
            content[i][7] = obj.getExpirationTime();
            content[i][8] = String.valueOf(obj.getPrice());
        }

        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}