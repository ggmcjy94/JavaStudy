package you.annotation;


import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
@SuppressWarnings("1111")// 값이 이상하면 무시함
@TestInfo(testedBy = "aaa", testTools = {"Junit","Junit5"}, testDate= @DateTime(yymmdd="160101", hhmmss="235959"))
public class AnnotationStudy2 {

    public static void main(String[] args) {
        Class<AnnotationStudy2> cls = AnnotationStudy2.class;

        TestInfo anno = cls.getAnnotation(TestInfo.class);
        System.out.println("anno.testedBy() = " + anno.testedBy());
        System.out.println("anno.testDate().yymmdd() = " + anno.testDate().yymmdd());
        System.out.println("anno.testDate().hhmmss() = " + anno.testDate().hhmmss());
        for (String str : anno.testTools()) {
            System.out.println("str = " + str);
        }
        System.out.println();

        Annotation[] annoArr = cls.getAnnotations();
        for (Annotation a : annoArr) {
            System.out.println("a = " + a);
        }
    }
}
@Retention(RetentionPolicy.RUNTIME) //실행시 가능
@interface TestInfo {
    int count() default 1;
    String testedBy();
    String[] testTools() default "Junit";
    TestType testType() default TestType.FIRST;
    DateTime testDate();
}

@Retention(RetentionPolicy.RUNTIME)
@interface DateTime{
    String yymmdd();
    String hhmmss();
}
enum TestType{
    FIRST, SECOND;
}