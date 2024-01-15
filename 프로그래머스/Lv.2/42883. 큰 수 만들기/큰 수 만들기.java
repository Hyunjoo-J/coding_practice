class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int len = number.length();
        int idx = 0;
        //앞이 큰 수로 시작하면 무조건 가장 큰 수
        //len - k로 필요한 자리수 만큼 보면서 시작 값이 가장 큰 값을 찾음
        for(int i = 0; i < len - k; ++i){
            char max = 0;
            for(int j = idx; j <= i + k; ++j){
                if(max < number.charAt(j)){
                    max = number.charAt(j);
                    idx = j + 1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}