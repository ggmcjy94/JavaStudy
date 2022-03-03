package you.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

//@Repeatable 여러번 붙일 수있게함  ToDo[] values(); 이런식으로 배열에 담아야함
@Inherited // 상속 가능 하게함
@Target({FIELD, TYPE, TYPE_USE})
//Runtime 클래스 파일에 존재함 실행시 사용가능 예 Controller
// SOURCE 클래스 파일에 존재하지 않음 예 override
@Retention(RUNTIME)
public @interface MetaAnnotationStudy {

}

@MetaAnnotationStudy //적용 대상이 Type 인 경우
class MyClass {
    @MetaAnnotationStudy // 적용대상이 FIELD 인경우
    int i;
    @MetaAnnotationStudy //적용 대상이 TYPE_USE 인경우
    MyClass mc;
}
