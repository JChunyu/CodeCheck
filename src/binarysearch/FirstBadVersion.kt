package binarysearch

class FirstBadVersion {
    fun firstBadVersion(n: Int) : Int {
        var min = 1
        var max = n
        while (min <= max) {
            val center = min + (max - min) / 2
            if (isBadVersion(center)) {
                max = center - 1
            } else {
                min = center + 1
            }
        }
        return min
    }

    fun isBadVersion(version: Int): Boolean = false
}

/*
 public int firstBadVersion(int n) {
        int min = 1;
        int max = n;
        while(min<=max){
            int mid = min+(max-min)/2;
            if(isBadVersion(mid)){
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        return min;
    }
}
* */