package back.exception;


public class BackExceptionStudy3 extends RuntimeException{

    public String strongStringPrint(String name) {
        String str;

        try {
            StringBuilder sb = new StringBuilder();
            sb.append("*");
            sb.append(name);
            sb.append("*");
            str = "try pass";
            System.out.println(str);
//            throw  new Exception(); //return catch pass
            return sb.toString(); // return *study*
        } catch (Exception e) {
            str = "catch pass";
            return str;
        } finally {
            str = "finally pass";
            System.out.println(str);
//            return "finally";
//            finally 에 return 이 있으면 try 리턴이 안되고
//            finally return **finally 에는 return 을 쓰면 안됌
//            finally 에서 exception 을 던지는 것도 안좋은 예
//            자원 반납 또는 로그출력만
        }
    }

    public static void main(String[] args) {
        BackExceptionStudy3 back = new BackExceptionStudy3();
        System.out.println("정상결과 = " + back.strongStringPrint("study"));
    }



}
