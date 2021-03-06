package io.weli.reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CallMethodReflectively {
    public String getMessages(List<String> messageList) {
        return messageList.get(0);
    }

    public static void main(String[] args) throws Exception {
        Method method =
                Class.forName("io.weli.reflection.CallMethodReflectively")
                        .getDeclaredMethod("getMessages", List.class);
        method.setAccessible(true);

        Object cmr = Class.forName("io.weli.reflection.CallMethodReflectively").newInstance();

        List<String> msgs = new ArrayList<>();
        msgs.add("Hello");
        msgs.add("world");
        System.out.println(method.invoke(cmr, msgs));
    }
}
