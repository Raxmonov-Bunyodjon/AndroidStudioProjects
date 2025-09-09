class MyThread: Thread() {

    override fun run() {
        for (i in 0..20){
            println("Thread $i")
            sleep(2000)
        }
    }
    init {
        start()
    }
}