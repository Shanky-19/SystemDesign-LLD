package Lecture8;

// --- Strategy Interface for Walk ---
interface WalkableRobot {
    void walk();
}

// --- Concrete Strategies for walk ---
class NormalWalkingRobot implements WalkableRobot {
    public void walk() {
        System.out.println("Normal Walking");
    }
}

class NoWalkingRobot implements WalkableRobot {
    public void walk() {
        System.out.println("Not walking");
    }
}

// --- Strategy Interface for Talk ---
interface TalkableRobot {
    void talk();
}

// --- Concrete Strategies for Talk ---
class NormalTalkingRobot implements TalkableRobot {
    public void talk() {
        System.out.println("Normal Talking");
    }
}

class NoTalkingRobot implements TalkableRobot {
    public void talk() {
        System.out.println("Not Talking");
    }
}

interface FlyableRobot {
    void fly();
}

class FlyWithWingsRobot implements FlyableRobot {
    public void fly() {
        System.out.println("Flying with wings");
    }
}

class FlyWithJetRobot implements FlyableRobot {
    public void fly() {
        System.out.println("Flying with jet");
    }
}

abstract class Robot {
    private WalkableRobot walkableRobot;
    private TalkableRobot talkableRobot;
    private FlyableRobot flyableRobot;

    public Robot(WalkableRobot walkableRobot, TalkableRobot talkableRobot, FlyableRobot flyableRobot) {
        this.walkableRobot = walkableRobot;
        this.talkableRobot = talkableRobot;
        this.flyableRobot = flyableRobot;
    }

    public void walk() {
        walkableRobot.walk();
    }

    public void talk() {
        talkableRobot.talk();
    }

    public void fly() {
        flyableRobot.fly();
    }

    // Abstract method for subclasses
    public abstract void projection();
}


// --- Concrete Robot Types ---
class CompanionRobot extends Robot {
    public CompanionRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f) {
        super(w, t, f);
    }

    @Override
    public void projection() {
        System.out.println("Projecting Companion Robot");
    }
}

class WorkerRobot extends Robot {
    public WorkerRobot (WalkableRobot w, TalkableRobot t, FlyableRobot f) {
        super(w, t, f);
    }

    @Override
    public void projection() {
        System.out.println("Projecting Worker Robot");
    }
}



public class StrategyDesignPattern {
    public static void main(String[] args) {
        Robot robot1 = new CompanionRobot(new NormalWalkingRobot(), new NormalTalkingRobot(), new FlyWithJetRobot());
        robot1.walk();
        robot1.talk();
        robot1.fly();
        robot1.projection();

        System.out.println("--------------------");

        Robot robot2 = new WorkerRobot(new NoWalkingRobot(), new NoTalkingRobot(), new FlyWithWingsRobot());
        robot2.walk();
        robot2.talk();
        robot2.fly();
        robot2.projection();
    }
}
