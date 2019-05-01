public class Point3D extends Point {
    private int z;
    public Point3D(int newX, int newY, int newZ){
        super(newX, newY);
        z = newZ;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
