package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class BaseSchema {

    private final Map<String, Predicate<Object>> validations;

    public BaseSchema() {
        this.validations = new HashMap<>();
    }

    public final void add(Predicate<Object> predicate) {
//        StackWalker stackWalker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
//        StackWalker.StackFrame methodName = stackWalker.walk(
//                stream1 -> stream1
//                        .skip(1)
//                        .findFirst()
//                        .orElse(null));
//        String id = this.getClass().getName() + methodName.getMethodName();
        String id = "1";
        validations.put(id, predicate);
    }

    public final boolean isValid(Object obj) {
        if (this.validations.isEmpty()) {
            return Objects.isNull(obj) || (obj instanceof String && Objects.toString(obj).equals(""));
        }
        for (Predicate<Object> predicate : this.validations.values()) {
            if (!predicate.test(obj)) {
                return false;
            }
        }
        return true;
    }

}
