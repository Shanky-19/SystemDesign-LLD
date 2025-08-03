package Lecture13;

interface ICharacter {
    String getAbilities();
}

class Mario implements ICharacter {
    @Override
    public String getAbilities() {
        return "Mario";
    }
}

class Luigi implements ICharacter {
    @Override
    public String getAbilities() {
        return "Luigi";
    }
}

abstract class CharacterDecorator implements ICharacter {
    ICharacter character;
    public CharacterDecorator(ICharacter character) {
        this.character = character;
    }
}

// Concrete Decorator: Height-Increasing Power-Up.
class HeightUp extends CharacterDecorator {
    public HeightUp(ICharacter character) {
        super(character);
    }

    public String getAbilities() {
        return character.getAbilities() + " with Height Up";
    }
}

// Concrete Decorator: Gun Power-Up.
class GunPowerUp extends CharacterDecorator {
    public GunPowerUp(ICharacter character) {
        super(character);
    }

    public String getAbilities() {
        return character.getAbilities() + " with Gun Power Up";
    }
}

// Concrete Decorator: Star-Ability Power-Up.
class StarPowerUp extends CharacterDecorator {
    public StarPowerUp(ICharacter character) {
        super(character);
    }   

    public String getAbilities() {
        return character.getAbilities() + " with Star Ability (Limited Time)";
    }
}



public class DecoratorPattern {
    public static void main(String[] args) {
        // Create a basic Mario character.
        ICharacter mario = new Mario();
        System.out.println("Basic Character: " + mario.getAbilities());

        // Decorate Mario with a HeightUp power-up.
        mario = new HeightUp(mario);
        System.out.println("After HeightUp: " + mario.getAbilities());

        // Decorate Mario further with a GunPowerUp.
        mario = new GunPowerUp(mario);
        System.out.println("After GunPowerUp: " + mario.getAbilities());

        // Finally, add a StarPowerUp decoration.
        mario = new StarPowerUp(mario);
        System.out.println("After StarPowerUp: " + mario.getAbilities());
    }
}
