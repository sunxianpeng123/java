package reflect;

class Value {
    static {
        // System.out.println("静态初始化块执行");
    }
 
    public void f(int k) {
        System.out.println(k);
    }
 
    public int g(int k) {
        return k * k;
    }
 
    public static void staticF() {
        System.out.println("静态方法");
    }
 
    private int x;
 
    @Override
    public String toString() {
        return "Value [x=" + x + "]";
    }
 
    public int getX() {
        return x;
    }
 
    public void setX(int x) {
        this.x = x;
    }
 
    public Value() {
 
    }
 
    public Value(int x) {
        this.x = x;
    }
 
    private Value(String s) {
 
    }
}