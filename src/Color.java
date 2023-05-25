public class Color {
    private int red;
    private int green;
    private int blue;

    public Color(String[] values) {
        this.red = Integer.parseInt(values[0].trim());
        this.green = Integer.parseInt(values[1].trim());
        this.blue = Integer.parseInt(values[2].trim());
    }

    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }
}
