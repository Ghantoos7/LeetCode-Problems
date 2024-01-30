class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {

        int size = matches.length;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < size; i++){

            if (map.containsKey(matches[i][1])){
                map.put(matches[i][1],map.get(matches[i][1]) + 1);
            }
            else{
                map.put(matches[i][1],1);
            }

            if (!map.containsKey(matches[i][0])){
                map.put(matches[i][0],0);

            }
        }

            List<Integer> winners = new ArrayList<>();
            List<Integer> losers = new ArrayList<>();

            List<List<Integer>> out = new ArrayList<>();

            for (int key : map.keySet()){
                if (map.get(key) == 0){
                    winners.add(Integer.valueOf(key));
                }
                else if (map.get(key) == 1){
                    losers.add(Integer.valueOf(key));
                }
            }

            Collections.sort(winners);
            Collections.sort(losers);

            out.add(winners);
            out.add(losers);

            return out;


    }
}