package chap02;

/*
배열의 값들 뿐만 아니라, 클래스 변수 및 인스턴스 변수도 초깃값으로 초기화됨을 보여주는 코드.
 */

public class supple1 {
    static boolean fact; //클래스 변수. 초깃값인 false로 초기화됨.
    public static void main(String[] args) {
        checkInstanceField a = new checkInstanceField();

        if (fact)
            System.out.println("fact: " + fact);
        else
            System.out.println("fact: " + fact);

        if (a.fact)
            System.out.println("fact: " + a.fact);
        else
            System.out.println("fact: " + a.fact);

    }
}

class checkInstanceField {
    boolean fact; //인스턴스 변수. 초깃값인 false로 초기화됨.
}
