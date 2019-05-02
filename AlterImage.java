public class AlterImage {
    public Pixel [][] generatePixelArray(int [][] reds, int[][] greens, int [][] blues) {
        boolean size = true;
        Pixel[][] image;
        if ((reds.length == greens.length) && (blues.length == reds.length)) {
            for(int temp = 0; temp<reds.length; temp++)
            {
                if(reds[temp].length != blues[temp].length || reds[temp].length != greens[temp].length || blues[temp].length != greens[temp].length){
                    size = false;
                }
            }
        }
        if(size){
            image = new Pixel[reds.length][reds[0].length];
            for(int row = 0; row<image.length;row++){
                for(int column = 0; column<image[row].length; column++){
                    image[row][column] = new Pixel(reds[row][column], greens[row][column], blues[row][column] );
                }
            }
        }
        else {
            image = new Pixel[0][0];
            System.err.println("Can't do that sorry");
        }
        return image;
    }
    public Pixel[][] fipImage (Pixel[][] image, boolean horiz){
        int rows = image.length;
        int columns = image[0].length;
        Pixel[][] newImage = new Pixel[rows][columns];
        if(horiz){
            for(int row = 0; row<image.length;row++){
                for(int column = 0; column<image[row].length; column++){
                    newImage[row][column] = image[rows][column];
                }
                rows = rows-1;
            }
        }
        else{
            for(int row = 0; row<image.length;row++){
                for(int column = 0; column<image[row].length; column++){
                    newImage[row][column] = image[row][columns];
                }
                columns = columns-1;
            }
        }
        return newImage;
    }
}
