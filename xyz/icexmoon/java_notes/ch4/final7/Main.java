package ch4.final7;

class Controller {
    public Controller() {

    }

    public final void request() {
        this.preRequest();
        this.doRequest();
        this.afterRequest();
    }

    protected void preRequest() {

    }

    protected void afterRequest() {

    }

    protected void doRequest() {

    }
}

class IndexController extends Controller {
    @Override
    protected void preRequest() {
        super.preRequest();
        //检查登录状态
    }

    @Override
    protected void doRequest() {
        super.doRequest();
        //加载首页html
    }
}

public class Main {
    public static void main(String[] args) {
        IndexController ic = new IndexController();
        ic.request();
    }
}
