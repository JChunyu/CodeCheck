package microsoft.dynamicprogramming

class GiftMaxValue {
    /*
    * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
    * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
    * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
    *
    * */
    fun maxValue(grid: Array<IntArray>): Int {
        for (i in grid.indices) {
            for (j in 0 until grid[0].size) {
                if(i == 0 && j ==0) {
                    continue // 第一个元素的累计价值就是自己
                } else if(i == 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1] // i = 0，不能向上，上一个累计价值只能来自左侧
                } else if (j == 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j] // j = 0，不能向左，上一个累计价值只能来自上侧
                } else {
                    // 当前累计价值为，当前位置的值 + 来自左边或上边较大的值
                    grid[i][j] = Math.max(grid[i][j] + grid[i][j - 1], grid[i][j] + grid[i - 1][j])
                }
            }
        }
        return grid[grid.size - 1][grid[0].size - 1]
    }
}