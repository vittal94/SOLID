package org.example.OCP

//This class violates the OCP, because if we want to  add new type of Sender, we need to modify
//Notifier class also
object BadDesignOfSender {
    class SMSSender{
        fun sendSMS() {
            println("Sending SMS.")
        }
    }

    class PushSender {
        fun sendPush() {
            println("Sending push message.")
        }
    }

    class EmailSender{
        fun sendEmail(){
            println("Sending email message.")
        }
    }

    class Notifier(private val sender: Any) {
        fun notifying() {
            if (sender is EmailSender) {
                sender.sendEmail()
            }
            else if(sender is PushSender) {
                sender.sendPush()
            }
            else if (sender is SMSSender) {
                sender.sendSMS()
            }
            // if we add a new type of sender like DoveSender, we need to modify this class
            //thus we violate the OCP because class should be close for modification
            //else if(sender is DoveSender)
            //    sender.sendByDove()
        }
    }
}

//if we use the abstraction of a Sender, we can extend the functionality of Notifier without modifying it
//we modify just Sender
object GoodDesignOfSender {
    interface Sender {
        fun send()
    }
    class SMSSender : Sender {
        override fun send() {
            println("Sending SMS.")
        }
    }
    class EmailSender : Sender {
        override fun send() {
            println("Sending the email.")
        }
    }

    class PushSender : Sender {
        override fun send() {
            println("Sending the push message.")
        }
    }

    class Notifier(private val sender: Sender){
        fun notifying() {
            sender.send()
        }
    }
}