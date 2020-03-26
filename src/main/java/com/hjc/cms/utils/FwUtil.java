package com.hjc.cms.utils;

//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.EncodeHintType;
//import com.google.zxing.MultiFormatWriter;
//import com.google.zxing.common.BitMatrix;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
//import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

//import static xd.fw.service.IConst.DEFAULT_TIME_PATTERN;

public class FwUtil {

//    public static String UTF8 = "UTF-8";
//    //static int[] months = new int[]{0,31,29,31,30,31,30,31,31,30,31,30,31};
//    public static final SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_TIME_PATTERN);
//
//    public static String getValidateCode() {
//        return String.format("%04d", Math.abs(new Random().nextInt(9999)));
//    }
//
//    public static Object getBean(String name) {
//        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
//        return wac.getBean(name);
//    }
//
//    // sdf is not thread safe so we need add synchronized
//    public synchronized static int getLastDayInMonth(int year, int month) {
//        Calendar calendar = Calendar.getInstance();
//        try {
//            calendar.setTime(sdf.parse(String.format("%d-%02d-%02d 00:00:00", year, month, 1)));
//        } catch (Exception e) {
//            throw new IllegalArgumentException("can not parse data", e);
//        }
//        calendar.add(Calendar.DAY_OF_MONTH, -1);
//        return calendar.get(Calendar.DAY_OF_MONTH);
//    }
//
//    public static int[] getLastMonth() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.MONTH, -1);
//        return new int[]{calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1};
//    }
//
            public static String md5(String plainText) {
            return DigestUtils.md5Hex(plainText);
            }
//
//    public static void invokeBeanFields(Object o, BeanFieldProcess p) throws IllegalAccessException {
//        Field[] fields = o.getClass().getDeclaredFields();
//        Object v;
//        for (Field f : fields) {
//            f.setAccessible(true);
//            v = f.get(o);
//            p.process(f, v);
//        }
//    }
//
//    public static void invokeBeanFieldsWidthConditions(Object o, BeanFieldProcess p, BeanFieldCondition condition) throws IllegalAccessException {
//        invokeBeanFields(o, (f, v) -> {
//            if (condition.accept(f, v)) {
//                p.process(f, v);
//            }
//        });
//    }
//
//    public interface BeanFieldCondition {
//        boolean accept(Field f, Object o);
//    }
//
//    public interface BeanFieldProcess {
//        void process(Field f, Object o);
//    }
//
    public interface SafeEachProcess<T> {
        void process(T t);
    }
//
//    public interface SafeArrayProcess<T> {
//        void process(T t, int i);
//    }

    public static <T> void safeEach(Collection<T> list, SafeEachProcess<T> p) {
        if (list == null || list.size() < 1) {
            return;
        }
        list.forEach(p::process);
    }

//    public static <T> void safeEach(T[] array, SafeArrayProcess<T> p) {
//        if (array == null || array.length < 1) {
//            return;
//        }
//        for (int i = 0; i < array.length; i++) {
//            p.process(array[i], i);
//        }
//    }
//
    public interface CompareItem<T> {
        boolean compare(T t, T o);
    }

    public static <T> void replaceOrAddListItem(List<T> list, T t, CompareItem<T> compare) {
        if (list == null) {
            list = new ArrayList<>();
        }

        for (int i = 0; i < list.size(); i++) {
            if (compare.compare(list.get(i), t)) {
                list.set(i, t);
                return;
            }
        }
        list.add(t);
    }

//    public static boolean verify(Map<String, ?> params, String key) {
//        List<String> list = new ArrayList<String>();
//        String sign = null;
//        String value;
//        for (Map.Entry<String, ?> entry : params.entrySet()) {
//            if (entry.getValue() instanceof String[]) {
//                value = ((String[]) entry.getValue())[0];
//            } else {
//                value = String.valueOf(entry.getValue());
//            }
//            if (entry.getKey().equals("sign")) {
//                sign = value;
//                continue;
//            }
//            if (StringUtils.isBlank(value)) {
//                continue;
//            }
//            list.add(entry.getKey() + "=" + value + "&");
//        }
//        return getSign(list, key).equals(sign);
//    }
//
//    public static String getSign(List<String> params, String key) {
//        int size = params.size();
//        String[] arrayToSort = params.toArray(new String[size]);
//        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < size; i++) {
//            sb.append(arrayToSort[i]);
//        }
//        sb.append("key=").append(key);
//        return MD5.MD5Encode(sb.toString());
//    }
//
//    public static int executeCmd(File directory, String[] cmd) throws Exception{
//        ProcessBuilder builder = new ProcessBuilder(cmd);
//        Process process = builder.directory(directory).inheritIO().start();
//        process.waitFor();
//        return process.exitValue();
//    }
//
//    public static String executeCmd(AsyncTaskExecutor taskExecutor, File directory, String[] cmd) throws Exception {
//        ProcessBuilder builder = new ProcessBuilder(cmd);
//        builder.directory(directory);
//        Process process = null;
//        BufferedReader br = null;
//        BufferedReader br2 = null;
//        StringBuilder buffer = new StringBuilder();
//        try {
//            process = builder.start();
//            br = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            br2 = new BufferedReader(new InputStreamReader(process.getErrorStream()));
//            Future<String> info = taskExecutor.submit(new ReaderThread(br));
//            Future<String> error = taskExecutor.submit(new ReaderThread(br2));
//            buffer.append(info.get(10, TimeUnit.SECONDS)).append(error.get(10, TimeUnit.SECONDS));
//        } finally {
//            if (process != null) {
//                process.waitFor();
//            }
//            if (br != null) {
//                br.close();
//            }
//            if (br2 != null) {
//                br.close();
//            }
//        }
//        return buffer.toString();
//    }
//
//    public static void unzip(File zipFile, File destDir) throws IOException {
//        try (ZipFile zip = new ZipFile(zipFile)) {
//            Enumeration<? extends ZipEntry> entries = zip.entries();
//            ZipEntry zipEntry;
//            byte[] buffer = new byte[1024];
//            InputStream ins = null;
//            int count;
//            FileOutputStream os = null;
//            while (entries.hasMoreElements()) {
//                zipEntry = entries.nextElement();
//                File itemFile = new File(destDir, zipEntry.getName());
//                try {
//                    if (zipEntry.isDirectory()) {
//                        if (!itemFile.exists() && !itemFile.mkdirs()) {
//                            throw new IOException("can not make dir :" + zipEntry.getName());
//                        }
//                        continue;
//                    }
//                    if (itemFile.exists() && !itemFile.delete()) {
//                        throw new IOException("can no delete file:" + itemFile);
//                    }
//                    os = new FileOutputStream(itemFile);
//                    ins = zip.getInputStream(zipEntry);
//                    while ((count = ins.read(buffer)) > -1) {
//                        os.write(buffer, 0, count);
//                    }
//                } finally {
//                    if (os != null) os.close();
//                    if (ins != null) ins.close();
//                }
//            }
//        }
//    }
//
//    static class ReaderThread implements Callable<String> {
//        static Logger logger = LoggerFactory.getLogger(ReaderThread.class);
//        BufferedReader br;
//
//        ReaderThread(BufferedReader br) {
//            this.br = br;
//        }
//
//        public String call() {
//            StringBuilder lines = new StringBuilder();
//            String line;
//            try {
//                while ((line = br.readLine()) != null) {
//                    lines.append(line).append("\n");
//                    logger.info(line);
//                }
//            } catch (IOException e) {
//                logger.error("", e);
//            }
//            return lines.toString();
//        }
//    }
//
//    private static final int BLACK = 0xFF000000;
//    private static final int WHITE = 0xFFFFFFFF;
//
//    public static byte[] qrCode(String content, int width, int height) throws Exception {
//
//        Map<EncodeHintType, Object> hints = new HashMap<>();
//        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
//        hints.put(EncodeHintType.MARGIN, 0);
//        BitMatrix matrix = new MultiFormatWriter().encode(content,
//                BarcodeFormat.QR_CODE, width, height, hints);
//
//        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//        for (int x = 0; x < width; x++) {
//            for (int y = 0; y < height; y++) {
//                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
//            }
//        }
//        ImageIO.write(image, "png", new File("C:\\Users\\exiglvv\\Documents\\work\\a.png"));
//        try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
//            ImageIO.write(image, "png", os);
//
//            return os.toByteArray();
//        }
//    }
//
//    public static Workbook parseFile(InputStream inputStream) throws Exception {
//        Workbook book = null;
//        try {
//            book = WorkbookFactory.create(inputStream);
//        } finally {
//            if (inputStream != null) {
//                inputStream.close();
//            }
//        }
//        return book;
//    }
//
//    public static Cell setCellValue(Sheet sheet, int row, int cell, Object value) {
//        Row rowForWrite = sheet.getRow(row);
//        if (rowForWrite == null) {
//            rowForWrite = sheet.createRow(row);
//        }
//        Cell cellForWrite = rowForWrite.getCell(cell);
//        if (cellForWrite == null) {
//            cellForWrite = rowForWrite.createCell(cell);
//        }
//        if (value instanceof Double) {
//            cellForWrite.setCellValue((Double)value);
//        } else {
//            cellForWrite.setCellValue(value.toString());
//        }
//
//        return cellForWrite;
//    }
//
//    public static String getCellValue(Cell cell) {
//        if (cell == null) {
//            return null;
//        }
//        String value;
//        try {
//            value = String.valueOf(cell.getStringCellValue());
//        } catch (IllegalStateException e) {
//            try {
//                value = String.valueOf(cell.getNumericCellValue());
//            } catch (IllegalStateException e1) {
//                try {
//                    value = String.valueOf(cell.getBooleanCellValue());
//                } catch (IllegalStateException e2) {
//                    value = null;
//                }
//            }
//        }
//        return StringUtils.isBlank(value) || "无".equals(value) ? null : value.trim();
//    }
//
//    public static int search(Object[] objects, Object obj) {
//        if (obj == null) {
//            return -1;
//        }
//        for (int index = 0; index < objects.length; index++) {
//            if (obj.equals(objects[index])) {
//                return index;
//            }
//        }
//        return -1;
//    }
//
//    public static float toFixed(double d, int n) {
//        int power = (int) Math.pow(10, n);
//        return (float) (Math.round(d * power)) / power;
//    }
//
//    public static void toFixed(float[] data, int n) {
//        for (int i = 0; i < data.length; i++) {
//            data[i] = toFixed(data[i], n);
//        }
//    }
//
//    final static SimpleDateFormat orderSdf = new SimpleDateFormat("HHmmssyyyyMMddSSS");
//
//    public static synchronized String createOutTradeNo() {
//        return orderSdf.format(new Date());
//    }
//
//    public static int[] getCurrentYearAndMonth(Date belong) {
//        Calendar instance = Calendar.getInstance();
//        instance.setTime(belong);
//        return new int[]{instance.get(Calendar.YEAR), instance.get(Calendar.MONTH) + 1};
//    }
//
//    public static String encode(String data, byte[] key, int keyLength, boolean decode) throws Exception {
//        byte[] source;
//        if (decode) {
//            source = Base64.getDecoder().decode(data);
//        } else {
//            source = data.getBytes(UTF8);
//        }
//        for (int i = 0; i < source.length; i++) {
//            source[i] ^= key[i % keyLength];
//        }
//        if (decode) {
//            return new String(source);
//        } else {
//            return Base64.getEncoder().encodeToString(source);
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//
//        System.out.println(orderSdf.format(new Date()));
//        File[] files = new File("D:\\output\\a\\b\\").listFiles();
//        int startId = -600;
//
//        for (File file: files) {
//            Scanner scanner = new Scanner(file);
//            String line;
//
//            String[] users = new String[] {"刘萍","黄超","保安公司","吴凤祥","王以睿","郭亚平"};
//            String[] keys = new String[] {"payType", "startTime","endTime","settleFee","fee"};
//
//            while (scanner.hasNextLine()) {
//                line = scanner.nextLine();
//                if (line.contains("car out") && Arrays.stream(users).anyMatch(line::endsWith)) {
//                    String [] array = line.substring(line.lastIndexOf(" ") + 1).split("-");
//
//                    String line_ = "", line2;
//                    while (scanner.hasNextLine()) {
//                        line_ = scanner.nextLine();
//                        if (line_.contains("add items:")) {
//                            break;
//                        }
//                    }
//                    line2 = line_;
//
//                    //System.out.println(Arrays.toString(array));
//                    startId--;
//
//                    Function<String,String> v = key -> line2.substring(line2.indexOf(key)
//                            + key.length() + 1, line2.indexOf(",", line2.indexOf(key)));
//
//                    System.out.println(String.format("insert into t_park_car values (%d,'%s','10004','%s','%s','%s','%s',%s,'%s');",
//                            startId,
//                            array[1],
//                            v.apply("startTime"),
//                            v.apply("endTime"),
//                            array[0],array[2]
//                            ,v.apply("fee") ,"0001"
//                    ));
//
//                    System.out.println(
//                            String.format("insert into park_users_pay_item values (%d,null, %s,'%s','%s',%f,%f,%f, %f, %d);",
//                                    startId, v.apply("payType"),
//                                    v.apply("startTime"),
//                                    v.apply("endTime"),
//                                    Float.parseFloat(v.apply("settleFee")),
//                                    Float.parseFloat(v.apply("fee")),
//                                    Float.parseFloat(v.apply("cashOff")),
//                                    Float.parseFloat(v.apply("sysOff")),
//                                    startId
//                            ));
//
//                }
//            }
//            scanner.close();
//        }
//    }
}
