fun main(){

    val myThread = MyThread()
//
//    if (myThread.isAlive){
//        println("My thread is alive")
//
//    }
    myThread.join()
    val secondThread = SecondThread()

//    if (secondThread.thread.isAlive){
//        println("My second thread is alive")
//    }
}