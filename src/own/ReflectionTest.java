package own;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static java.lang.System.out;

/**
 * @author:yuze
 * @description:反射练习
 * @data:2022/1/15
 */
public class ReflectionTest {
    public static void main(String[] args) {
        String name = "com.java.easy.User";
        try {
            Class cl = Class.forName(name);
            Class supercl = cl.getSuperclass();//父类信息
            String modifiers = Modifier.toString(cl.getModifiers());//权限修饰符信息
            if (modifiers.length() > 0) out.print(modifiers + " ");
            out.print("class  " + name);
            if (supercl != null && supercl != Object.class) out.println("extends" + supercl.getName());
            out.print("\n{\n");
            printConstructors(cl);
            out.println();
            printMethods(cl);
            out.println();
            printFields(cl);
            out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static void printConstructors(Class cl) {//所有的构造器信息
        Constructor[] constructors = cl.getDeclaredConstructors();
        for (Constructor c : constructors) {
            String name = c.getName();//构造器的名字
            out.print(" ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) out.print(modifiers + " ");//所有权限修饰符
            out.print(name + "(");
            // print parameter types
            Class[] paramTypes = c.getParameterTypes();//存放所有参数的类型
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) out.print(", ");
                out.print(paramTypes[j].getName());
            }
            out.println(");");
        }
    }

    public static void printMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            Class retType = m.getReturnType();//方法的返回值类型
            String name = m.getName();//方法名字
            out.print("  ");
            // print modifiers, return type and method name
            String modifiers = Modifier.toString(m.getModifiers());//权限修饰符
            if (modifiers.length() > 0) out.print(modifiers + " ");
            out.print(retType.getName() + " " + name + "(");

            //print parameter types
            Class[] paramTypes = m.getParameterTypes();//所有参数类型
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) out.print("f ");
                out.print(paramTypes[j].getName());
            }
            out.println(");");
        }
    }
    public static void printFields(Class cl)
    {
        Field[] fields = cl.getDeclaredFields();//获取类的所有声明字段
        for (Field f : fields)
        {
            Class type = f.getType();
            String name = f.getName();
            out.print(" ");
            String modifiers = Modifier.toString(f.getModifiers());//权限修饰符
            if (modifiers.length()> 0) System.out.print(modifiers + " ");
            out.println(type.getName() + " " + name + ";");
        }
    }
}
