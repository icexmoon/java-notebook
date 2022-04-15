package ch20.usecase;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.Fmt;

public class UseCaseAnalysis {
    public static void main(String[] args) {
        List<Integer> allUseCaseIds = new ArrayList<>();
        allUseCaseIds.addAll(Arrays.asList(1, 2, 3, 4, 5));
        List<Class<?>> allCls = new ArrayList<>();
        allCls.addAll(Arrays.asList(Student.class, ClassRoom.class));
        int totalCase = allUseCaseIds.size();
        int downCase = 0;
        for (Class<?> cls : allCls) {
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                UseCase useCase = method.getAnnotation(UseCase.class);
                if (useCase != null) {
                    int id = useCase.id();
                    String description = useCase.description();
                    Fmt.printf("usecase #%d is done, description is %s\n", id, description);
                    allUseCaseIds.remove(Integer.valueOf(id));
                    downCase++;
                }
            }
        }
        int leftCase = allUseCaseIds.size();
        Fmt.printf("test %d use case, %d is down, %d is not.\n", totalCase, downCase, leftCase);
    }
}
// usecase #2 is done, description is remove student from classroom use case.
// usecase #1 is done, description is add student use case.
// test 5 use case, 2 is down, 3 is not.