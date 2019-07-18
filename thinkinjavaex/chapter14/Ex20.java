// thinkinjavaex/chapter14/Ex20.java
import java.lang.reflect.*;
import java.lang.annotation.*;
import static com.wyett.util.Print.*;

public class Ex20 {
    public static void main(String[] args){
        if(args.length < 1){
            print("Usage: Input class name");
            System.exit(0);
        }
        Class<?> c = null;
        try{
            c = Class.forName(args[0]);
        } catch(ClassNotFoundException e){
            print("No such class: " + e);
        }
        //c: class Ex20
        print("c: " + c);
        print("c.annotation(): ");
        if(c.getAnnotations().length == 0)
            //none
            print("none");
        for(Annotation a : c.getAnnotations())
            print(a);
        //返回JLS中定义的底层类规范化名称
        // c.getCanonicalName(): Ex20
        print("c.getCanonicalName(): " + c.getCanonicalName());
        print("c.getClasses(): ");
        //返回包含某些Class对象class<?>[]数组
        if(c.getClasses().length == 0)
            print("none");
        for(Class c1 : c.getClasses())
            print(c1);
        
        //返回类加载器
        // c.getClassLoader(): sun.misc.Launcher$AppClassLoader@73d16e93
        print("c.getClassLoader(): " + c.getClassLoader());
		print("c.getConstructors(): ");
		if(c.getConstructors().length == 0) print("none");
        //返回构造器对象的数组
        //public Ex20()
		for(Constructor ctor : c.getConstructors())
			print(ctor);
        //返回直接存在此元素上的所有注释
		print("c.getDeclaredAnnotations(): ");
		if(c.getDeclaredAnnotations().length == 0) print("none");
		for(Annotation a : c.getDeclaredAnnotations())
			print(a);
        //返回Class对象的一个数组
		print("c.getDeclaredClasses(): ");
		if(c.getDeclaredClasses().length == 0) print("none");
		for(Class cl : c.getDeclaredClasses())
			print(cl);
        //返回Constructor对象的一个数组
		print("c.getDeclaredConstructors(): ");
		if(c.getDeclaredConstructors().length == 0) print("none");
		for(Constructor ctor : c.getDeclaredConstructors())
            //public Ex20()
			print(ctor);
        //返回field对象的一个数组
		print("c.getDeclaredFields(): ");
        //none
		if(c.getDeclaredFields().length == 0) print("none");
		for(Field f : c.getDeclaredFields())
			print(f);
        //返回method对象的一个数组，包含所有method
		print("c.getDeclaredMethods(): ");
		if(c.getDeclaredMethods().length == 0) print("none");
		for(Method m : c.getDeclaredMethods())
            //public static void Ex20.main(java.lang.String[])
			print(m);
        // 若该class对象是另一个类的成员，则返回的class对象表示该对象的声明类
        // null
		print("c.getDeclaringClass(): " + c.getDeclaringClass());
        //构造方法的本地或匿名类，底层类的立即封闭构造方法
		print("c.getEnclosingConstructor(): " + c.getEnclosingConstructor());
        //某一方法的本地或匿名类，底层类的立即封闭构造方法
		print("c.getEnclosingMethod(): " + c.getEnclosingMethod());
        //不表示枚举类型，则返回枚举类的元素或null
		print("c.getEnumConstants(): " + c.getEnumConstants());
        //所有filed组成的数组
		print("c.getDeclaredFields(): ");
        //none
		if(c.getFields().length == 0) print("none");
		for(Field f : c.getFields())
			print(f);
		print("c.getGenericInterfaces(): ");
        //none, 某些接口的Type，由该类的对象直接实现
		if(c.getGenericInterfaces().length == 0) print("none");
		for(Type t : c.getGenericInterfaces())
			print(t);
        //class所表示的实体(类,接口,基本类型，void)
        //class java.lang.Object
		print("c.getGenericSuperclass(): " + c.getGenericSuperclass());
		print("c.getInterfaces(): ");
        //对象所表示的类或实现的接口 none
		if(c.getInterfaces().length == 0) print("none");
		for(Class i : c.getInterfaces())
			print(i);
        //包含某些method对象的数组，包括从超类或接口继承的，公共方法
        /*public static void Ex20.main(java.lang.String[])
          public final void java.lang.Object.wait() throws java.lang.InterruptedException
          public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
          public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
          public boolean java.lang.Object.equals(java.lang.Object)
          public java.lang.String java.lang.Object.toString()
          public native int java.lang.Object.hashCode()
          public final native java.lang.Class java.lang.Object.getClass()
          public final native void java.lang.Object.notify()
          public final native void java.lang.Object.notifyAll()
        */
		print("c.getMethods(): ");
		if(c.getMethods().length == 0) print("none");
		for(Method m : c.getMethods())
			print(m);
        //类或接口的整数编码的修饰符
        // 1
		print("c.getModifiers(): " + c.getModifiers());
        //以String 形式返回Class表示的实体
        // Ex20
		print("c.getName(): " + c.getName());
        // 获取类的包
		print("c.getPackage(): " + c.getPackage());
        //返回ProtectionDomain
        /*
            c.getProtectionDomain(): ProtectionDomain  (file:/G:/java/thinkinjavaex/chapter14/ <no signer certificates>)
            sun.misc.Launcher$AppClassLoader@73d16e93
            <no principals>
            java.security.Permissions@70dea4e (
            ("java.lang.RuntimePermission" "exitVM")
            ("java.io.FilePermission" "\G:\java\thinkinjavaex\chapter14\-" "read")
            )
        */
		print("c.getProtectionDomain(): " + c.getProtectionDomain());
        // 获取类标记
        // null
		print("c.getSigners(): ");
		if(c.getSigners() == null)
			print(c.getSigners());
		if(c.getSigners() != null) {
			print();
			if(c.getSigners().length == 0) print("none");
			if(c.getSigners().length > 0) {
				for(Object s : c.getSigners()) 
					print(s);
			}
		}
        
		print("c.getSimpleName(): " + c.getSimpleName());
		print("c.getSuperclass(): " + c.getSuperclass());
		print("c.getTypeParameters(): " + c.getTypeParameters());
        //类对象表示注释类型，返回true
		print("c.isAnnotation(): " + c.isAnnotation());
        //指定类型的注释在此元素上，返回true
		print("c.isAnnotationPresent(Documented.class): " + c.isAnnotationPresent(Documented.class));
        //底层类是匿名类，返回true
		print("c.isAnonymousClass(): " + c.isAnonymousClass());
        //是否数组类
		print("c.isArray(): " + c.isArray());
        //判断c表示的类或接口，与Ex20.class表示的类或接口是否相同，或者是否是其超类或超接口
        //true
		print("c.isAssignableFrom(Ex20.class): " + c.isAssignableFrom(Ex20.class));
        //false
		print("c.isAssignableFrom(Object.class): " + c.isAssignableFrom(Object.class));
        //声明为枚举
		print("c.isEnum(): " + c.isEnum());
        //Object是否与class表示的对象赋值兼容
        //false
		print("c.isInstance(Object.class): " + c.isInstance(Object.class));
        //是否接口类型
		print("c.isInterface(): " + c.isInterface());
        //底层类是否本地类
		print("c.isLocalClass(): " + c.isLocalClass());
        //底层类是成员类
		print("c.isMemberClass(): " + c.isMemberClass());
        //是否基本类型
		print("c.isPrimitive(): " + c.isPrimitive());
        //是否符合类
		print("c.isSynthetic(): " + c.isSynthetic());
    }
}

/*

G:\java\thinkinjavaex\chapter14>java Ex20 Ex20
c: class Ex20
c.annotation():
none
c.getCanonicalName(): Ex20
c.getClasses():
none
c.getClassLoader(): sun.misc.Launcher$AppClassLoader@73d16e93
c.getConstructors():
public Ex20()
c.getDeclaredAnnotations():
none
c.getDeclaredClasses():
none
c.getDeclaredConstructors():
public Ex20()
c.getDeclaredFields():
none
c.getDeclaredMethods():
public static void Ex20.main(java.lang.String[])
c.getDeclaringClass(): null
c.getEnclosingConstructor(): null
c.getEnclosingMethod(): null
c.getEnumConstants(): null
c.getDeclaredFields():
none
c.getGenericInterfaces():
none
c.getGenericSuperclass(): class java.lang.Object
c.getInterfaces():
none
c.getMethods():
public static void Ex20.main(java.lang.String[])
public final void java.lang.Object.wait() throws java.lang.InterruptedException
public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
public boolean java.lang.Object.equals(java.lang.Object)
public java.lang.String java.lang.Object.toString()
public native int java.lang.Object.hashCode()
public final native java.lang.Class java.lang.Object.getClass()
public final native void java.lang.Object.notify()
public final native void java.lang.Object.notifyAll()
c.getModifiers(): 1
c.getName(): Ex20
c.getPackage(): null
c.getProtectionDomain(): ProtectionDomain  (file:/G:/java/thinkinjavaex/chapter14/ <no signer certificates>)
 sun.misc.Launcher$AppClassLoader@73d16e93
 <no principals>
 java.security.Permissions@70dea4e (
 ("java.lang.RuntimePermission" "exitVM")
 ("java.io.FilePermission" "\G:\java\thinkinjavaex\chapter14\-" "read")
)


c.getSigners():
null
c.getSimpleName(): Ex20
c.getSuperclass(): class java.lang.Object
c.getTypeParameters(): [Ljava.lang.reflect.TypeVariable;@5c647e05
c.isAnnotation(): false
c.isAnnotationPresent(Documented.class): false
c.isAnonymousClass(): false
c.isArray(): false
c.isAssignableFrom(Ex20.class): true
c.isAssignableFrom(Object.class): false
c.isEnum(): false
c.isInstance(Object.class): false
c.isInterface(): false
c.isLocalClass(): false
c.isMemberClass(): false
c.isPrimitive(): false
c.isSynthetic(): false

*/