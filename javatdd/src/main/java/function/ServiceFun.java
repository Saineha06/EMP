package function;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ServiceFun {

    Supplier<String> nameSuppler=()->{
        return "neha";
    };
    Supplier<String>nameSupplerLamda=() -> "neha";
    public String nameUpperCaseWithFunctionParam(Function<String, String> upper, String name) {
        return upper.apply(name);
    };
    Function<String, String> nameUpperCaseFun = (name) -> {
        return name.toUpperCase();
    };
    BiFunction<String, String, String> biFunctionConcatFun = (firstName, lName) -> {
        return firstName.concat(lName);
    };

    public static void main(String[] args) {
        ServiceFun serviceFun = new ServiceFun();
        String upperCaseName = serviceFun.nameUpperCaseFun.apply("neoteric");
        System.out.println("Out put From Function -" + upperCaseName);
        String concat = serviceFun.biFunctionConcatFun.apply("Sai", "neha");
        System.out.println(concat);
        String nameUpperCaseWithFunctionParam = serviceFun.nameUpperCaseWithFunctionParam(serviceFun.nameUpperCaseFun, "neo");
        System.out.println(nameUpperCaseWithFunctionParam);
    }
}



