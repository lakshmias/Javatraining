//Interface for a printer
interface Printer {
    void print(String document);
   }
   
   //Concrete implementation of the Printer interface
    class ConsolePrinter implements Printer {
    public void print(String document) {
        System.out.println(document);
    }
   }
   
   //Null object implementation of the Printer interface
    class NullPrinter implements Printer {
    public void print(String document) {
        // do nothing
    }
   }
   
   //Example usage
   public class PrinterApplication {
    public static void main(String[] args) {
        Printer printer = getPrinter();
        printer.print("Hello, world!");
    }
    
    public static Printer getPrinter() {
        // return null to use the ConsolePrinter, or return new NullPrinter() to use 
        //the Null Object
        return new NullPrinter();
    }
   }
   
   /*
    In this example, we have an interface called Printer that defines a method called print. 
    We also have a concrete implementation of the Printer interface called ConsolePrinter that prints 
    the document to the console. Finally, we have a Null Object implementation of the Printer interface 
    called NullPrinter that does nothing.
   
   In the PrinterApplication class, we have a method called getPrinter that returns either null 
   (to use the ConsolePrinter) or a new instance of the NullPrinter (to use the Null Object). 
   The main method calls getPrinter to get an instance of the Printer interface, and then calls its 
   print method with a string argument.
   
   If we were to call getPrinter and it returned null, the print method would throw a NullPointerException.
    However, if we were to call getPrinter and it returned a new instance of NullPrinter, 
    the print method would do nothing and the application would continue running without any errors.
   
   Overall, the Null Object pattern can help to prevent null pointer exceptions in Java applications and
    provide a more robust and reliable application. 
     
      
    */