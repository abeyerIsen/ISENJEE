package yncrea.pw02;

import javassist.Modifier;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;

public class TestUtils {

    private TestUtils() {
        super();
    }


    public static void shouldHaveMethod(Class<?> clazz, String methodName, Class<?> returnType, Visibility visibility, Class<?>... parametersType) throws NoSuchMethodException {
        // GIVEN
        // WHEN
        Method method = clazz.getDeclaredMethod(methodName, parametersType);
        // THEN
        assertThat(method).isNotNull();
        assertThat(method.getReturnType()).isEqualTo(returnType);
        switch (visibility) {
        case PUBLIC:
            assertThat(Modifier.isPublic(method.getModifiers())).isTrue();
            break;
        case PRIVATE:
            assertThat(Modifier.isPrivate(method.getModifiers())).isTrue();
            break;
        case PROTECTED:
            assertThat(Modifier.isProtected(method.getModifiers())).isTrue();
            break;
        }
    }


    public static <A extends Annotation> void shouldHaveAnnotationOnClass(Class<?> clazz, Class<A> annotationClazz) {
        // GIVEN
        // WHEN
        A[] annotations = clazz.getAnnotationsByType(annotationClazz);
        // THEN
        assertThat(annotations).hasSize(1);
    }


    public static <A extends Annotation> void shouldHaveAnnotationOnMethod(Method method, Class<A> annotationClazz) {
        // GIVEN
        // WHEN
        A[] annotations = method.getAnnotationsByType(annotationClazz);
        // THEN
        assertThat(annotations).hasSize(1);
    }


    public enum Visibility {
        PUBLIC, PRIVATE, PROTECTED
    }
}
