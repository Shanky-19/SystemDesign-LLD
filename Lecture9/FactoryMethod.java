package Lecture9;

interface Burger {
    void prepare();
}

class BasicBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing Basic Burger");
    }
}

class StandardBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Standard Burger");
    }
}

class PremiusBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Premium Burger");
    }
}

class BasicWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Basic Wheat Burger");
    }
}

class StandardWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Standard Wheat Burger");
    }
}

class PremiumWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Premium Wheat Burger");
    }
}


interface BurgerFactory {
    Burger createBurger(String type);
}

// Burger King makes wheat burgers
class BurgerKing implements BurgerFactory {
    @Override
    public Burger createBurger(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicWheatBurger();
        } else if (type.equalsIgnoreCase("standard")) {
            return new StandardWheatBurger();
        } else if (type.equalsIgnoreCase("premium")) {
            return new PremiumWheatBurger();
        }
        System.out.println("Invalid burger type");
        return null;
    }
}
class BurgerSingh implements BurgerFactory {
    @Override
    public Burger createBurger(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicBurger();
        } else if (type.equalsIgnoreCase("standard")) {
            return new StandardBurger();
        } else if (type.equalsIgnoreCase("premium")) {
            return new PremiusBurger();
        } else {
            System.out.println("Invalid burger type");
            return null;
        }
    }
}

class KingBurgerFactory implements BurgerFactory {
    @Override
    public Burger createBurger(String type) {
        if (type.equals("basic")) {
            return new BasicWheatBurger();
        } else if (type.equals("standard")) {
            return new StandardWheatBurger();
        } else if (type.equals("premium")) {
            return new PremiumWheatBurger();
        }
        System.out.println("Invalid burger type");
        return null;
    }
}


public class FactoryMethod {
    // client code
    public static void main(String[] args) {
        BurgerFactory factory = new BurgerKing();
        Burger burger = factory.createBurger("standard");
        burger.prepare();
    }
}
