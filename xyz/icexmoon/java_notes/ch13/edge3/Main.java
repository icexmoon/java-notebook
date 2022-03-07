package ch13.edge3;

class NormalHolder{
    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

}

public class Main {
    public static void main(String[] args) {
        NormalHolder nh = new NormalHolder();
        nh.setContent("Hello World!");
        String msg = (String)nh.getContent();
        System.out.println(msg);
    }
}
