package effectivejava.builderifmoremember;

/**
 * @author : chelei
 * @description: telescoping constructor
 * @date : 2019/7/27 15:46
 */
public class CarHasMuchMemberNormal {
    // required
    private String brand;
    private String color;
    private String lisencePlateNumber;

    // optional
    private int length;
    private int width;
    private int driverNum;

    public CarHasMuchMemberNormal(String brand,
                                  String color,
                                  String lisencePlateNumber) {
        this(brand, color, lisencePlateNumber, 0);
    }
    public CarHasMuchMemberNormal(String brand,
                                  String color,
                                  String lisencePlateNumber,
                                  int length) {
        this(brand, color, lisencePlateNumber, length, 0);
    }
    public CarHasMuchMemberNormal(String brand,
                                  String color,
                                  String lisencePlateNumber,
                                  int length,
                                  int width) {
        this(brand, color, lisencePlateNumber, length, width, 0);
    }
    public CarHasMuchMemberNormal(String brand,
                                  String color,
                                  String lisencePlateNumber,
                                  int length,
                                  int width,
                                  int driverNum) {
        this.brand = brand;
        this.color = color;
        this.lisencePlateNumber = lisencePlateNumber;
        this.length = length;
        this.width = width;
        this.driverNum = driverNum;
    }
}
