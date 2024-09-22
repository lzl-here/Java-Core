package lzl.com.mid;

public class Sqrt {
    public static void main(String[] args) {
        double v = calSqrt(0.5);
        System.out.println(v);
    }

    public static double calSqrt(double number) {
        double l = 0, r = Math.max(1.0, number); // number小于1时，mid 比 number大，所以右区间要比number大，就选1
        double mid = l + (r - l) / 2;
        while (Math.abs(number - (mid * mid)) > 0.00001) {
            // System.out.println(mid);
            if ((mid * mid) > number) {
                r = mid;
            } else if ((mid * mid) < number) {
                l = mid;
            } else {
                return mid;
            }
            mid = l + (r - l) / 2;
        }
        return mid;
    }
}
