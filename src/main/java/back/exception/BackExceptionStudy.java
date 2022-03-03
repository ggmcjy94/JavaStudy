package back.exception;

import java.io.*;

// 리팩토링, gof 디자인패턴
public class BackExceptionStudy {

    public static void main(String[] args) {
        try {
            // TODO 여기서 어떤 예외를 던지냐에 달림
        } catch(IllegalArgumentException e) { // 순서 자식 정확한거

        } catch(RuntimeException e) { //  적인거

        }

        //멀티 catch
        try {
            throw new NullPointerException();
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getClass());
        }
        BackExceptionStudy back = new BackExceptionStudy();
        back.yuumi();
    }

    //checked RuntimeException 을 상속받지 않은 예외
    //unchecked RuntimeException 을 상속받은 예외
    private  void yuumi() {
        throw new IllegalArgumentException();
    }

    //close method 를 사용 할때는 try-with-resource 를 사용


    //문제점을 찾으시오
    static void copy(String src, String dest) throws Exception {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        } finally {
            if (in != null) in.close(); //여기서 exception 이 나버리면 out 이 close 가 안됌
            if (out != null) out.close();
        }

    }

    static void copySolution(String src, String dest) throws IOException{
        //자바 8 Closeable try with resource // close 를 해주는 catch 블록이 생김
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dest)) {
            byte[] buf = new byte[1024];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        }
//        InputStream in = null;
//        OutputStream out = null;
//        try {
//            out = new FileOutputStream(dest);
//            try {
//                in = new FileInputStream(src);
//                byte[] buf = new byte[1024];
//                int n;
//                while ((n = in.read(buf)) >= 0) {
//                    out.write(buf, 0, n);
//                }
//            } finally {
//                if (in != null) {
//                    try {
//                        in.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        } finally {
//            if (out != null) {
//                try {
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

    }


}
