package com.javaSamples.designPatterns;



import java.io.*;
import java.lang.reflect.Constructor;

public class SingletonDemo{

    public static void main(String[] args) throws Exception {
//        Singleton s = Singleton.INSTANCE;
//        System.out.print(s.getI());
//        s.setI(2);
//        System.out.print(s.getI());

        //Code to show reflection problem in Singleton
//      AdvancedSingleton ads = AdvancedSingleton.getInstance();
//      AdvancedSingleton ads1 = null;
//
//        Constructor c = AdvancedSingleton.class.getDeclaredConstructor();
//        c.setAccessible(true);
//        ads1=(AdvancedSingleton) c.newInstance();

        //Code to show serialization problem in singleton

        AdvancedSingleton ads = AdvancedSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.txt"));
        out.writeObject(ads);
        out.close();

        ObjectInput in = new ObjectInputStream(new FileInputStream("file.txt"));
        AdvancedSingleton ads1 = (AdvancedSingleton) in.readObject();
        in.close();
        System.out.println("Hashcode of Object 1 - "+ads.hashCode());
        System.out.println("Hashcode of Object 2 - "+ads1.hashCode());

        AdvancedSingleton s = AdvancedSingleton.getInstance();
        AdvancedSingleton sclone = (AdvancedSingleton) s.clone();
        System.out.println("Hashcode of Object 2 - "+s.hashCode());
    }
}

//enum Singleton {
//    INSTANCE;
//    private transient int i=3 ;
//
//    public int getI() {
//        return i;
//    }
//
//    public void setI(int i) {
//        this.i = i;
//    }
//}

final class AdvancedSingleton implements Serializable {

    private static volatile AdvancedSingleton ads ;

    //taking care of refrection problem
    private AdvancedSingleton() throws Exception
    {
      /* if(null==ads){
           ads = new AdvancedSingleton();
       } else {        throw new Exception("Reflection not supported");
      }*/
    }

    //taking care of the multi-thread problem
    public static AdvancedSingleton getInstance() throws Exception{
        if(null == ads){
            synchronized (AdvancedSingleton.class) {
                if (null == ads) {
                    ads = new AdvancedSingleton();
                }
            }
        }
        return ads;
    }

    //Taking care of the clone problem
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Clone not supported");
    }

    //Taking care of deserialization
    public Object readResolve(){
        return ads;
    }
}