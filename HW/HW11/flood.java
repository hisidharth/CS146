package HW.HW11;

public class flood {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0 || image[0].length == 0 || sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return image;
        }
        int og = image[sr][sc];
        if (og == color) {
            return image;
        }
        driver(image, sr, sc, og, color);
        return image;
    }

    private void driver(int[][] image, int r, int c, int og, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != og) {
            return;
        }
        image[r][c] = newColor;
        driver(image, r + 1, c, og, newColor);
        driver(image, r - 1, c, og, newColor);
        driver(image, r, c + 1, og, newColor);
        driver(image, r, c - 1, og, newColor);
    }

    public static void main(String[] args) {
        flood flood = new flood();
        int[][] image = {{0, 1, 1}, {1, 0, 0}, {1, 0, 1}};
        int sr = 2, sc = 1, newColor = 2;

        int[][] result = flood.floodFill(image, sr, sc, newColor);
        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}
