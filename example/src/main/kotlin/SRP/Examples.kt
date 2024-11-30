package org.example.SRP

//This is a violation of SRP because the book have two responsibilities,
//two different actors: BookManagement(like librarian) and Data Presentation Mechanism(like the way we want
//to deliver a content to user - -on-screen, graphical UI, text only UI, maybe printing)

object BooksThatPrintsThemself {
       class Book(val title: String, val author: String) {
          fun turnPage(){
           println("Return pointer of the next page.")
          }
       fun printCurrentPage() {
           println("Printing the current page.")
         }
       }
}

//Even this basic example gives you an advantage in design flexibility
object SeparatingBusinessLogicFromPresentationLogic {
    class Book(val title: String, val author: String) {
        fun turnPage() {
            println("Return a pointer of the next page.")
        }
        fun getCurrentPage(): String = "Current page."


    }

    interface Printer {
        fun printPage(book: Book)
    }

    class PlainTextPrinter : Printer  {
        override fun printPage(book: Book) {
            println("Plaint text: ${book.getCurrentPage()}")
        }
    }

    class HtmlPrinter : Printer {
        override fun printPage(book: Book) {
            println("Html text: ${book.getCurrentPage()}")
        }

    }
}

//We can identify several actors like Book Management System and Persistence.
//Whenever we want to change persistence we change this class.
//Whenever we want to change how to get from one page to another, we have to modify this class.
object BooksThatSavesThemself {
    class Book(val title: String, val author: String) {
        fun turnPage() {
            println("Return a pointer of the next page.")
        }
        fun getCurrentPage(): String = "Current page."

        fun save() {
            println("Saving to DB.")
            val byteArray = mutableListOf<String>()
            byteArray.add(this.title)
            byteArray.add(this.author)
        }
    }
}

object SeparatePersistenceFromBookManagement {
    class Book(val title: String, val author: String) {
        fun turnPage() {
            println("Return a pointer of the next page.")
        }
        fun getCurrentPage(): String = "Current page."
    }
    class SimpleFilePersistence {
        fun save(book: Book) {
            val byteArray = mutableListOf<String>()
            byteArray.add(book.title)
            byteArray.add(book.author)
        }
        }
    }
