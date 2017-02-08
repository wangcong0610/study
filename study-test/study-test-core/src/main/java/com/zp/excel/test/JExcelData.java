package com.zp.excel.test;

import com.meidusa.fastjson.JSONArray;
import com.meidusa.fastjson.JSONObject;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.*;

/**
 * Author: Zhang Peng
 * Date: 2017/1/6 0006
 * Description:
 */
public class JExcelData {

    public static void main(String[] args) {
        dealEmailData();
    }

    public static void dealAddressData() {
        System.out.println("开始处理地址缺失数据");
        System.out.println("=============================================================================================");
        Workbook readwb = null;
        WritableWorkbook wwb = null;
        InputStream inputStream = null;

        int addressSheetNo = 1;
        int productNoColumn = 0;
        int newAddressColumn = 5;
        int newProductNoColumn = 6;
        try {
            //从本地文件创建Workbook
            File file = new File("d://test.xls");
            System.out.println(file.exists());
            inputStream = new FileInputStream(file);
            readwb = Workbook.getWorkbook(inputStream);
            //利用已经创建的Excel工作薄,创建新的可写入的Excel工作薄
            wwb = Workbook.createWorkbook(file, readwb);
            //Sheet的下标是从0开始
            //获取第一张Sheet表
            Sheet readSheet = readwb.getSheet(addressSheetNo);
            WritableSheet writeSheet = wwb.getSheet(addressSheetNo);
            //获取Sheet表中所包含的总列数
            int rsColumns = readSheet.getColumns();
            //获取Sheet表中所包含的总行数
            int rsRows = readSheet.getRows();
            //获取指定单元格的对象引用
            for (int i = 4000; i < rsRows; i++) {
                String productNo = readSheet.getCell(productNoColumn, i).getContents();
                JSONObject addressJson = getAddressJson("/allData.txt", productNo);
                if (addressJson == null) {
//                    System.out.println("查询失败 " + productNo);
                    System.out.println(i + " 失败");
                } else {
                    String address = getAddress(addressJson);
                    // 新邮箱地址是在第6列
                    if (address == null || address.isEmpty() || address == "" || address.equals("")) {
                        System.out.println(i + " 为空");
                        continue;
                    }
                    System.out.println(i + " productNo = " + productNo + ", address = " + address);
                    Label labelEmail = new Label(newAddressColumn, i, address);
                    Label labelProductNo = new Label(newProductNoColumn, i, productNo);
                    writeSheet.addCell(labelEmail);
                    writeSheet.addCell(labelProductNo);
                }
            }
            wwb.write();
            System.out.println("=============================================================================================");
            System.out.println("处理地址缺失数据完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (wwb != null)
                    wwb.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }
            try {
                if (readwb != null)
                    readwb.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void dealEmailData() {
        System.out.println("开始处理邮箱缺失数据");
        System.out.println("=============================================================================================");
        Workbook readwb = null;
        WritableWorkbook wwb = null;
        InputStream inputStream = null;

        int emailSheetNo = 0;
        int productNoColumn = 0;
        int newEmailColumn = 5;
        int newProductNoColumn = 6;
        try {
            //从本地文件创建Workbook
            File file = new File("d://test.xls");
            System.out.println(file.exists());
            inputStream = new FileInputStream(file);
            readwb = Workbook.getWorkbook(inputStream);
            //利用已经创建的Excel工作薄,创建新的可写入的Excel工作薄
            wwb = Workbook.createWorkbook(file, readwb);
            //Sheet的下标是从0开始
            //获取第一张Sheet表
            Sheet readSheet = readwb.getSheet(emailSheetNo);
            WritableSheet writeSheet = wwb.getSheet(emailSheetNo);
            //获取Sheet表中所包含的总列数
            int rsColumns = readSheet.getColumns();
            //获取Sheet表中所包含的总行数
            int rsRows = readSheet.getRows();
            //获取指定单元格的对象引用
            for (int i = 3000; i < rsRows; i++) {
                String productNo = readSheet.getCell(productNoColumn, i).getContents();
                JSONObject addressJson = getAddressJson("/allData.txt", productNo);
                if (addressJson == null) {
//                    System.out.println("查询失败 " + productNo);
                    System.out.println(i + " 失败");
                } else {
                    String email = getEmail(addressJson);
                    // 新邮箱地址是在第6列
                    if (email == null || email.isEmpty() || email == "" || email.equals("")) {
                        System.out.println(i + " 为空");
                        continue;
                    }
                    System.out.println(i + " productNo = " + productNo + ", email = " + email);
                    Label lableEmail = new Label(newEmailColumn, i, email);
                    Label lableProductNo = new Label(newProductNoColumn, i, productNo);
                    writeSheet.addCell(lableEmail);
                    writeSheet.addCell(lableProductNo);
                }
            }
            wwb.write();
            System.out.println("=============================================================================================");
            System.out.println("处理邮箱缺失数据完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (wwb != null)
                    wwb.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }
            try {
                if (readwb != null)
                    readwb.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getAddress(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        JSONObject bestAddress = jsonObject.getJSONObject("bestAddress");
        if (bestAddress != null) {
            return (String) bestAddress.get("address");
        }
        JSONArray addressArray = jsonObject.getJSONArray("addressArray");
        if (addressArray != null && addressArray.size() > 0) {
            JSONObject addressJson = addressArray.getJSONObject(addressArray.size() - 1);
            return (String) addressJson.get("address");
        }
        JSONObject oldAddress = jsonObject.getJSONObject("oldAddress");
        if (oldAddress != null) {
            return (String) oldAddress.get("address");
        }
        return null;
    }

    public static String getEmail(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        JSONObject bestAddress = jsonObject.getJSONObject("bestAddress");
        if (bestAddress != null) {
            return (String) bestAddress.get("email");
        }
        JSONArray addressArray = jsonObject.getJSONArray("addressArray");
        if (addressArray != null && addressArray.size() > 0) {
            JSONObject addressJson = addressArray.getJSONObject(addressArray.size() - 1);
            return (String) addressJson.get("email");
        }
        JSONObject oldAddress = jsonObject.getJSONObject("oldAddress");
        if (oldAddress != null) {
            return (String) oldAddress.get("email");
        }
        return null;
    }

    public static JSONObject getAddressJson(String fileName, String productNo) throws IOException {
        // 读文件
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(JExcelData.class.getResourceAsStream(fileName)));
        String line = null;
        int count = 1;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                try {
                    JSONObject jsonObject = JSONObject.parseObject(line);
                    String productNoFromjson = (String) jsonObject.get("productNo");
                    if (productNoFromjson != null && productNoFromjson.equals(productNo)) {
                        return jsonObject;
                    }
                } catch (Exception e) {
                    System.out.println("error:" + e);
                }
            }
        } finally {
            bufferedReader.close();
        }
        return null;
    }

    public static void old() {
        jxl.Workbook readwb = null;

        try {

            //构建Workbook对象, 只读Workbook对象

            //直接从本地文件创建Workbook
            InputStream instream = new FileInputStream(JExcelData.class.getResource("/test.xlsx").getPath());

            readwb = Workbook.getWorkbook(instream);


            //Sheet的下标是从0开始

            //获取第一张Sheet表

            Sheet readsheet = readwb.getSheet(0);

            //获取Sheet表中所包含的总列数

            int rsColumns = readsheet.getColumns();

            //获取Sheet表中所包含的总行数

            int rsRows = readsheet.getRows();

            //获取指定单元格的对象引用

            for (int i = 0; i < rsRows; i++)

            {

                for (int j = 0; j < rsColumns; j++)

                {

                    Cell cell = readsheet.getCell(j, i);

                    System.out.print(cell.getContents() + " ");

                }

                System.out.println();

            }


            //利用已经创建的Excel工作薄,创建新的可写入的Excel工作薄

            jxl.write.WritableWorkbook wwb = Workbook.createWorkbook(new File(

                    "F:/红楼人物1.xls"), readwb);

            //读取第一张工作表

            jxl.write.WritableSheet ws = wwb.getSheet(0);

            //获得第一个单元格对象

            jxl.write.WritableCell wc = ws.getWritableCell(0, 0);

            //判断单元格的类型, 做出相应的转化

            if (wc.getType() == CellType.LABEL)

            {

                Label l = (Label) wc;

                l.setString("新姓名");

            }

            //写入Excel对象

            wwb.write();

            wwb.close();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            readwb.close();

        }
    }

}
