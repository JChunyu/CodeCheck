package java

class Outter {
    private fun printOut() {
        println("Out")
    }

    inner class Inn {

        fun setListener(r: Runnable) {
            r.run()
        }

        fun printInn() {
            setListener(object : Runnable {
                override fun run() {
                    printOut()
                }
            })
        }
    }
}
