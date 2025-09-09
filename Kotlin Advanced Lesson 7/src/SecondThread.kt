class SecondThread : Runnable {

    var thread  = Thread(this)
    override fun run() {
        for (i in 1..10) {
            println("My second thread $i")
            Thread.sleep(2000)
        }
    }

    init {
        thread.start()
    }

}