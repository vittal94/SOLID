package org.example.DIP

//DBConnection is a low level module
//Auth is a high level module

object DIPViolation {
    class MySQLConnection {
        fun connect(host: String, user: String, password: String) {
            println("return MYSQLConnection: $host $user $password")
        }
    }
    //In this case if we are want to use a new type of DB, we should refactor the code of class Auth
    //Because Auth class coupled to MySQLConnection
    class Auth(private val mySQLConnection: MySQLConnection) {
        fun authenticate(login: String, password: String) {
            mySQLConnection.connect("host",login,password)
        }
    }
}

//Now we are remove the strong coupling between MySQLConnection and Auth
//They coupled by abstraction
object DIPUsage {
    interface DBConnection {
        fun connect(host: String,user: String,password: String)
    }
    class MySQLConnection : DBConnection {
        override fun connect(host: String, user: String, password: String) {
            println("MySQLConnection are connection to: $host $user $password")
        }
    }
    //If we are want to add new type of DB, this class won't be affected
    class Auth(private val dBConnection: DBConnection) {
        fun authenticate(login: String,password: String) {
            dBConnection.connect("host", login,password)
        }
    }
}