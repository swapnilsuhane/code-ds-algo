package main.java.leetcode;

public class ContainerWithMostWater {
    public static int maxAreaBF(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            int width = 0;
            for (int j = i; j < height.length; j++, width++) {
                int minHeight = height[i] < height[j] ? height[i] : height[j];
                int area = minHeight * width;
                maxArea = maxArea < area ? area : maxArea;
            }
        }

        return maxArea;
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0, j=(height.length-1); i != j; ) {
            int area;
            int leftHeight = height[i];
            int rightHeight = height[j];
            int minHeight = leftHeight<rightHeight ? leftHeight : rightHeight;
            int width = (j-i);
            area =  minHeight * width;
            System.out.println("leftHeight: " + leftHeight +", " + "rightHeight: " +rightHeight + ", width: " +width  +", area: " +area);
            maxArea = maxArea< area ? area : maxArea;

            //move left if height is increasing
            if(height[i]<height[j]){
                i++;
            //else move right
            } else{
                j--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] h = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        //int[] h = {1, 2, 4, 3};
        int m = maxArea(h);
        System.out.println("Max Area: " + m);
    }
}
