/**
 * Where the cats and dogs fight to the death
 *  broken as hell
 * @author (your name)
 * @version (a version number or a date)
 */
public class Kennel
{
    // instance variables - replace the example below with your own
    private final int MAXCATS = 9, MAXDOGS = 5;
   
    // going to make arrays of dogs and cats holding objects
    private Dog[] dogs = new Dog[MAXDOGS];
    private Cat[] cats = new Cat[MAXCATS];
       
    /**
     * Constructor for objects of class Kennel
     */
    public Kennel()
    {
        // initialise instance variables
        this.fillKennel();
    }
   
    public void fillKennel()
    {
        for (int i = 0; i < dogs.length; i++)
        {
            dogs[i] = new Dog("Dog " + Integer.toString(i+1));
            System.out.print(dogs[i].getName() + " goes ");
            dogs[i].bark();
            System.out.println();
           
        }
       
        for (int i = 0; i < cats.length; i++)
        {
            cats[i] = new Cat("Cat " + Integer.toString(i+1));
            System.out.print(cats[i].getName() + " goes ");
            cats[i].meow();
            System.out.println();
        }
    }
   
    public void dogAttack(Dog dog, Cat cat)
    {
        System.out.println(dog.getName() + " bites " + cat.getName());
        cat.hit(dog.bite());
       
        // check that cat is still alive
        if (!cat.isAlive())
        {
            System.out.println(cat.getName() + " is dead :(");
        }
    }
   
    public void catAttack(Cat cat,Dog dog)
    {
        System.out.println(cat.getName() + " bites " + dog.getName());
        dog.hit(cat.claw());
       
        // check that cat is still alive
        if (!dog.isAlive())
        {
            System.out.println(dog.getName() + " is dead :(");
        }
    }
       
        public void fight()
        {        
            int first;
            int attacker, defender;
            boolean end = false;
            while (!end)
        {
            first = (int) (1 + Math.random() * 2);
            if (first <= 1)
            {
                do
                {
            attacker = (int)(Math.random() * MAXCATS);
                }while (cats[attacker].isAlive() == false);
               
                do
                {
                    defender = (int)(Math.random() * MAXDOGS);
                }while (dogs[defender].isAlive() == false);
               
                catAttack(cats[attacker], dogs[defender]);
       
            }
        }
    }

    public int checkWinner()
    {
   
        int catsAlive = MAXCATS, dogsAlive = MAXDOGS;
       
        for (Cat cat: cats)
        {
            if (!cat.isAlive())
            {
                catsAlive--;
            }
        }
        for (Dog dog: dogs)
        {
            if(!dog.isAlive())
            {
                dogsAlive--;
            }
        }
       
        if (catsAlive == 0)
        {        
            return 0;
        } else if (dogsAlive == 0)
        {
            return 1;
        }
           
        return -1;
    }
}