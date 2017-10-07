package Assignment4;

public class Solutions {
    public static void main(String[] args) {
        System.out.println(changeString("2-4A0r7-4k", 4));
    }

    public static String changeString(String str, int k) {

        String dashDeleted = str.replaceAll("-", "");
        StringBuilder sb = new StringBuilder(dashDeleted);
        int length = dashDeleted.length();
        int dash;
        int index;
        if (length % k == 0) {
            dash = length / k - 1;
            index = k;

            while (dash > 0) {
                sb.insert(index, "-");
                index += k + 1;
                dash--;
            }
        } else {
            dash = length / k;
            index = length % k;

            while (dash > 0) {
                sb.insert(index, "-");
                index += k + 1;
                dash--;
            }
        }
        return sb.toString().toUpperCase();
    }
}

class Tool {
    protected int strength;
    protected char type;

    public void setStrength(int strength) {
        this.strength = strength;
    }

    protected boolean fight(Tool tool) {
        if (this.type == 'r') {
            if (tool.type == 's') {
                return this.strength * 2 > tool.strength;
            } else if (tool.type == 'p') {
                return this.strength > tool.strength * 2;
            } else {
                return this.strength > tool.strength;
            }
        } else if (this.type == 'p') {
            if (tool.type == 'r') {
                return this.strength * 2 > tool.strength;
            } else if (tool.type == 's') {
                return this.strength > tool.strength * 2;
            } else {
                return this.strength > tool.strength;
            }
        } else {
            if (tool.type == 'p') {
                return this.strength * 2 > tool.strength;
            } else if (tool.type == 'r') {
                return this.strength > tool.strength * 2;
            } else {
                return this.strength > tool.strength;
            }
        }
    }
}
class Scissors extends Tool {
    public Scissors(int strength) {
        this.type = 's';
        setStrength(strength);
    }
}

class Paper extends Tool {
    public Paper(int strength) {
        this.type = 'p';
        setStrength(strength);
    }
}

class Rock extends Tool {
    public Rock(int strength) {
        this.type = 'r';
        setStrength(strength);
    }
}

class RockPaperScissorsGame {
    public static void main(String args[]) {
        Scissors s = new Scissors(5);
        Paper p = new Paper(7);
        Rock r = new Rock(15);
        System.out.println(s.fight(p) + " , " + p.fight(s));
        System.out.println(p.fight(r) + " , " + r.fight(p));
        System.out.println(r.fight(s) + " , " + s.fight(r));
    }
}

class IpAddress {
    String decimal;
    String[] octets;

    public IpAddress(String decimal) {
        this.decimal = decimal;
        octets = decimal.split("\\.");
    }

    public String getDottedDecimal() {
        return decimal;
    }

    public int getOctet(int pos) {
        return Integer.parseInt(octets[pos - 1]);
    }

    public static void main(String[] args) {
        IpAddress ip = new IpAddress("216.27.6.136");
        System.out.println(ip.getDottedDecimal());
        System.out.println(ip.getOctet(4));
        System.out.println(ip.getOctet(1));
        System.out.println(ip.getOctet(3));
        System.out.println(ip.getOctet(2));
    }

}
class Student {

    String name;
    int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

class Course {

    private String title;
    private int numberOfStudent;
    private Student[] students;

    public Course(String title) {
        this.title = title;
        numberOfStudent = 0;
        students = new Student[10];
    }

    public Student[] getStudents() {
        return students;
    }

    public boolean isFull() {
        return numberOfStudent == 10;
    }

    public void registerStudent(Student student) {
        if (numberOfStudent < 10) {
            students[numberOfStudent] = student;
            numberOfStudent++;
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfStudent() {
        return numberOfStudent;
    }
}

class Solution5 {
    public String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num / 1000] + C[(num / 100) % 10] + X[(num / 10) % 10] + I[num % 10];
    }
}

class Solution6 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) {
            return findKth(nums1, 0, nums2, 0, len / 2 + 1);
        }
        return (
                findKth(nums1, 0, nums2, 0, len / 2) + findKth(nums1, 0, nums2, 0, len / 2 + 1)
        ) / 2.0;
    }

    public static int findKth(int[] A, int A_start,
                              int[] B, int B_start,
                              int k){
        if (A_start >= A.length) {
            return B[B_start + k - 1];
        }
        if (B_start >= B.length) {
            return A[A_start + k - 1];
        }

        if (k == 1) {
            return Math.min(A[A_start], B[B_start]);
        }

        int A_key = A_start + k / 2 - 1 < A.length
                ? A[A_start + k / 2 - 1]
                : Integer.MAX_VALUE;
        int B_key = B_start + k / 2 - 1 < B.length
                ? B[B_start + k / 2 - 1]
                : Integer.MAX_VALUE;

        if (A_key < B_key) {
            return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
        } else {
            return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3};
        int[] arr2 = {2};
        Solution6 s = new Solution6();
        System.out.println(s.findMedianSortedArrays(arr1, arr2));
    }
}

