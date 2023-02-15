package solution.array

class CompareVersion {
    /*
    * left > right  return 1
    *  == 0
    * < -1
    * */
    fun compare(version1: String, version2: String): Int {
        val lefts = version1.split('.')
        val rights = version2.split('.')

        val minLength = lefts.size.coerceAtMost(rights.size)
        val maxLength = lefts.size.coerceAtLeast(rights.size)
        var i = 0

        while (i < minLength) {
            val leftUnit = lefts[i].toIntOrNull() ?: 0
            val rightUnit = rights[i].toIntOrNull() ?: 0
            when {
                leftUnit > rightUnit -> {
                    return 1
                }
                leftUnit == rightUnit -> {
                    i++
                }
                else -> {
                    return -1
                }
            }
        }

        if (i < maxLength) {
            if (lefts.size > minLength) {
                while (i < maxLength) {
                    val last = lefts[i].toIntOrNull() ?: 0
                    when {
                        last > 0 -> {
                            return 1
                        }
                        last == 0 -> {
                            i++
                        }
                        else -> {
                            return -1
                        }
                    }
                }
            }
            if (rights.size > minLength) {
                while (i < maxLength) {
                    val last = rights[i].toIntOrNull() ?: 0
                    when {
                        last > 0 -> {
                            return -1
                        }
                        last == 0 -> {
                            i++
                        }
                        else -> {
                            return 0
                        }
                    }
                }
            }
        }
        return 0
    }

}