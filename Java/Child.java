
/**
 * InnerChild
 */
 class Parent
{
   String name;
   String surname = "Jain";
    
   /**
    * @return the name
    */
  /**
   * @return the surname
   */
  public String getSurname() {
      return surname;
  }
}

/**
 * Child
 */
public class Child extends Parent {
   
    public static void main(String[] args) {
        Child c = new Child();
        c.name = "Rohit " + c.getSurname();

        System.out.println(c.name);
       

    }
    
}