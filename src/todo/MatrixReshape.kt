class MatrixReshape {
    fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        val arrayList = arrayListOf<Int>()
        mat.forEach { array ->
            array.forEach {
                arrayList.add(it)
            }
        }
        val newArray = Array(r) {
            IntArray(c)
        }
        if (arrayList.size != r * c) {
            return mat
        }
        var i = 0
        var j = 0
        var k = 0
        while (k < arrayList.size) {
            if (i < r && j < c) {
                newArray[i][j] = arrayList[k]
                if (j < c - 1) {
                    j++
                } else {
                    j = 0
                    if (i < r - 1) {
                        i++
                    }
                }
            } else {
                return mat
            }
            k++
        }
        return newArray
    }
}