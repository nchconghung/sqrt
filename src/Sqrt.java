public class Sqrt {
    private static final double epsilon = 0.00001;
    private static double func(int n,double x) {
        // f(x) = x^2 + n*x +n^/4 - n
        return x*x - n*x + n*n/4 - n;
    }

    public static double cal(int n) {
        if (n < 0) return -1;

        // Tìm căn bậc 2 của n ra số dương
        // Ta có n = (a-x)^2 -> f(x)= x^2 + 2ax + a^2 - n với số a tùy chọn a=n/2, và x là số gia giảm (và a-x > 0)
        // => f(x) = x^2 + n*x + n^2/4 - n
        // Vì a - x >= 0 -> ta tính xấp xỉ phương trình f(x) = 0 theo kỹ thuật chia nhị phân (Bisection) với x nằm trong khoảng [-a,a]
        // tìm giá trị xấp xỉ của phương trình f(x) = 0
        double left = -n/2,right = n/2,middle;
        while (right-left > epsilon) {
            middle = (left + right)/2;
            if (func(n,left) * func(n,middle) < 0) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return n/2 - (left + right) / 2;
    }
}
