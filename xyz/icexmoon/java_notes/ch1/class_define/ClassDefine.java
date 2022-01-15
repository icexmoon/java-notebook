package ch1.class_define;
class Test{}

class ClassDefine {
    int intMember;
    boolean boolMember;
    double doubleMember;
    Test test;


    public static void main(String[] args) {
        ClassDefine cd = new ClassDefine();
        System.out.println("cd.intMember:"+cd.intMember);
        System.out.println("cd.boolMember:"+cd.boolMember);
        System.out.println("cd.doubleMember:"+cd.doubleMember);
        System.out.println("cd.test:"+cd.test);
        int intLocal;
        boolean boolLocal;
        double doubleLocal;
        Test test;
        // System.out.println(intLocal);
        // System.out.println(boolLocal);
        // System.out.println(doubleLocal);
        // System.out.println(test);
    }
}
// cd.intMember:0
// cd.boolMember:false
// cd.doubleMember:0.0
// cd.test:null