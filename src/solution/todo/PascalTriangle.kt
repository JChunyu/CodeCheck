package solution.todo

class PascalTriangle {
    fun generate(numRows: Int): List<List<Int>> {
        val arrayList = arrayListOf<ArrayList<Int>>()
        if (numRows == 0) return emptyList()
        for (i in 0 until numRows) {
            val subList = arrayListOf<Int>()
            subList.add(1)
            for (j in 1 until i) {
                val preList = arrayList[i -1]
                subList.add(preList[j -1] + preList[j])
            }
            if (i != 0) {
                subList.add(1)
            }
            arrayList.add(subList)
        }
        return arrayList
    }
}

/*
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();

        if (numRows == 0) return lists;

        for (int i=0;i<numRows;i++){
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for (int j=1;j<i;j++){
                List<Integer> prevRow = lists.get(i-1);
                int temp = prevRow.get(j-1)+prevRow.get(j);
                row.add(temp);
            }
            if (i!=0){
                row.add(1);
            }
            lists.add(row);
        }
        return lists;
     }
* */