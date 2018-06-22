package java_core.ClassLoader;

import java.io.*;

/**
 * Created by codebug on 16-12-11.
 */
public class CustomClassLoader extends ClassLoader {

    private String name; // 类加载器的名字
    private String path = ""; // 加载类的路径
    private final String fileType = ".class"; // .class文件扩展名

    public CustomClassLoader(String name) {
        super();
        this.name = name;
    }

    public CustomClassLoader(ClassLoader parent, String name) {
        super(parent);
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 将class文件作为二进制流读取到byte数组中去
     *
     * @param name
     * @return
     */
    private byte[] loadClassData(String name) {
        byte[] data = null;
        name = name.replace(".", File.separator);

        // 这里使用了java7的try-with-resources语句
        // 代码简单了很多
        try (InputStream in = new BufferedInputStream(new FileInputStream(
                new File(path + name + fileType)));
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            int ch = 0;
            while (-1 != (ch = in.read())) {
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * JVM调用的加载器的方法
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = this.loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }

    public static void main(String[] args) throws Exception {
        CustomClassLoader loader1 = new CustomClassLoader("loader1");
        loader1.setPath("/home/codebug/Idea workspace/Learning-From-Book/target/classes/");
        Class<?> clazz = loader1.loadClass("java_core.DynamicProxy.Person");
        Object object = clazz.newInstance();
        System.out.println(clazz.getName());
        System.out.println(clazz.getConstructors().length);
        System.out.println(object.toString());
    }
}