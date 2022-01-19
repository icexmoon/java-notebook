package ch7.static1;

class OulterCls{
    static class InnerCls{
        private String privateAttr = "private_attr";
        protected String protectedAttr = "protected_attr";
        public String publicAttr = "public_attr";
        static String staticAttr = "static_attr";
        public static void staticFunc(){
            System.out.println("staticFunc() is called.");
        }

        public void normalFunc(){
            System.out.println("normalFunc() is called.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        OulterCls.InnerCls innerCls = new OulterCls.InnerCls();
        innerCls.staticFunc();
        innerCls.normalFunc();
        // staticFunc() is called.
        // normalFunc() is called.
    }
}
