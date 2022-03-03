package back.exception;

import java.io.*;

// 리팩토링, gof 디자인패턴
public class BackExceptionStudy2 extends RuntimeException{

    public static void main(String[] args) {
        try {

        } catch (Throwable e) {
            throw new ResponseException("hi", e); //에러 원인 파악을 위해 cause 를 같이 넘겨준다 , 따로 메시지만 보내도됌 경우에 따라
        }
    }



}
