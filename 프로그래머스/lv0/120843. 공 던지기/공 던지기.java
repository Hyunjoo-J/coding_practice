class Solution {
    public int solution(int[] numbers, int k) {
        return numbers[(2*k - 2) % numbers.length];
    }
}