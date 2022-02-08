package ch12.cls_counter3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeCounter {
    private Map<Class<?>, Integer> counter = new HashMap<>();
    private Class<?> rootType;

    public TypeCounter(Class<?> rootType) {
        if (null == rootType) {
            throw new RuntimeException("param must not null.");
        }
        this.rootType = rootType;
    }

    public void count(List<?> objs) {
        for (Object object : objs) {
            Class<?> type = object.getClass();
            if (!this.rootType.isAssignableFrom(type)) {
                throw new RuntimeException(type.toString() + " is not a count target type.");
            }
            countType(type);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Map.Entry<Class<?>, Integer> entry : counter.entrySet()) {
            sb.append(entry.getKey().getSimpleName());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    private void countType(Class<?> type) {
        doCount(type);
        Class<?> superCls = type.getSuperclass();
        if (superCls != null && rootType.isAssignableFrom(superCls)) {
            countType(superCls);
        }
    }

    private void doCount(Class<?> type) {
        int value = counter.getOrDefault(type, 0);
        counter.put(type, value + 1);
    }

}
