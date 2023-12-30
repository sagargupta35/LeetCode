class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int [] arr = new int [deck.length];
        Arrays.sort(deck);
        int i = 0, j = 0;
        boolean flag = true;
        while(j < deck.length){
            while(arr[i] != 0) i = (i+1)%deck.length;
            if(flag){
                arr[i] = deck[j++];
            }
            i = (i+1)%arr.length;
            flag = !flag;
        }
        return arr;
    }
}
