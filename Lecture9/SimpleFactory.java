package Lecture9;

interface Burger {
    void prepare();
}

class BasicBurger implements Burger {
    public void prepare () {
        System.out.println("Preparing Basic Burger");
    }
}

class StandardBurger implements Burger {
    public void prepare () {
        System.out.println("Preparing Standard Burger");
    }
}

class PremiumBurger implements Burger {
    public void prepare () {
        System.out.println("Preparing Premium Burger");
    }
}


class BurgerFactory {
    public Burger createBurger(String type) {
        if (type.equals("basic")) {
            return new BasicBurger();
        } else if (type.equals("standard")) {
            return new StandardBurger();
        } else if (type.equals("premium")) {
            return new PremiumBurger();
        }
        System.out.println("Invalid burger type");
        return null;
    }
}

public class SimpleFactory {
    public static void main(String[] args) {
        String type = "Standard";
        BurgerFactory factory = new BurgerFactory();
        Burger burger = factory.createBurger(type);
        burger.prepare();
    }
}
